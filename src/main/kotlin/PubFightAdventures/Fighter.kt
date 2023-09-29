package PubFightAdventures

class Fighter(name: String, hp: Double, damage: Double, cursed: Boolean) : Hero(name, hp, damage, cursed) {
    override fun toString(): String {
        return name
    }


    //TODO: SKILLS

    /**
     * Die Fähigkeit Fist of Zen benötigt eine Ladephase von einer Runde.
     * Dies blockiert zwar weitere Aktionen in einer Runde, fügt jedoch erheblichen Schaden zu. !! Ladephase
     */

    var fistOfZen =
        Skill(
            "Fist of Zen",
            damage * 100.0,
            2,
            true,
            false,
            false,
            0
        )                         //ab 0.5 Fähigkeiten als Klassen


    /**
     * Die Fähigkeit Bronzene Kniescheibe ermöglicht es dem Fighter seine Kniescheibe als Geschoss zu verwenden
     */

    var bronzeneKniescheibe = Skill("Bronzene Kniescheibe", damage * 35.0, 5, false, false, false, 0)


    /**
     * Die Fähigkeit Tokat verteilt eine feurige Schelle ins Gesicht des Gegners
     */
    var tokat = Skill("Tokat", damage * 25.0, 15, false, false, false, 0)

    /**
     * Setzt der Fighter Booze ein, greift der Held zur nächstgelegenen Flasche und trinkt sie aus.
     * Dadurch erhält er für 3 Runden einen HP-Boost von 10% und einen Schadens-Boost von 25%.
     */
    var booze = Skill("Booze", damage * 0.0, 2, false, false, false, 0)


    var fighterSkills = listOf(
        fistOfZen,
        bronzeneKniescheibe,
        tokat,
        booze
    )

    public fun attack() {

        var skillNamen = fighterSkills                                                                                                                  //Auflistung der Angriffe des Fighters
        println("Wähle einen Angriff aus!")
        println(
            "1 für ${fighterSkills.elementAt(0)}                    \uD83D\uDDE1\uFE0F${
                calculateSkill(
                    fighterSkills[0],
                    fighter
                ).toDouble()
            }                 | Uses left: ${fighterSkills.elementAt(0).uses}"
        )
        println(
            "2 für ${fighterSkills.elementAt(1)}            \uD83D\uDDE1\uFE0F${
                calculateSkill(
                    fighterSkills[1],
                    fighter
                ).toDouble()
            }        | Uses left: ${fighterSkills.elementAt(1).uses}"
        )
        println(
            "3 für ${fighterSkills.elementAt(2)}                        \uD83D\uDDE1\uFE0F${
                calculateSkill(
                    fighterSkills[2],
                    fighter
                ).toDouble()
            }                       | Uses left: ${fighterSkills.elementAt(2).uses}"
        )
        println(
            "4 für ${fighterSkills.elementAt(3)}                        \uD83C\uDF00      | Uses left: ${fighterSkills.elementAt(3).uses}"
        )

        val eingabe = readln()                                                                                                                               //Auswahl des Spielers
        val index = eingabe.toInt() - 1
        clearConsole()

        val target = chooseTarget(enemies)                                          //Auswahl des Gegners
        val attacke = skillNamen.elementAt(index)                                     //Angriff aus der Liste
        val schadenBerechnung: Double = calculateSkill(attacke, fighter)                    //
        val schaden = criticalHit(schadenBerechnung)

        if (enemy1.rauchbombe.effect == true) {
            enemy1.rauchbombe.effect = false
            println("Du siehst nichts und verfehlst...")
        } else if (fighter.hp > 0) {
            if (fighterSkills[index].uses > 0) {

                if (index == 3) {
                    if (fighter.booze.effect == false) {
                        fighter.damage += 0.2 // increase damage by 20%
                        fighter.hp *= 1.2 // increase hp by 20%
                        fighter.booze.effect = true
                        println("Du greifst zur nächsten Pulle Vodka und trinkst sie aus!\nDein Schaden und deine Lebenspunkte werden für 3 Runden um 20% erhöht.\n\n")
                        fighterSkills[3].uses -= 1
                    } else {
                        println("${YELLOW}Du verträgst momentan keinen weiteren Drink. Warte bis du nüchtern bist!$RESET")
                    }

                } else if (fighterSkills[index].charge == true) {
                    fighterSkills[index].charge = false
                    fighterSkills[index].charging = true

                    println("Sie haben $attacke gewählt. Diese Attacke muss sich noch eine Runde aufladen")
                } else {

                    if (fighterSkills[index].charging == true) {

                        fighterSkills[index].charging = false
                        println("Die Ladephase für $attacke ist vorbei!")
                        println("Du verursachst ${schaden.toDouble()} Schaden am ${target.name}")
                        target.hp -= schaden.toInt()
                        fighterSkills[index].uses -= 1
                        fighterSkills[index].charge = true
                    } else {
                        println("$attacke verursacht ${schaden.toDouble()} Schaden am ${target.name}!")
                        target.hp -= schaden.toDouble()
                        fighterSkills[index].uses -= 1
                    }
                }

                // Bereich für ausgelagerte Abfragen
                isBoozeActive()
                isAnfeuernActive()
            } else {
                println("Die Attacke $attacke wurde aufgebraucht!")
            }
        } else {
            gameStatus()
            println("Dieser Charakter hat keine Lebenspunkte mehr")
            playerAttack()
        }
    }
}
