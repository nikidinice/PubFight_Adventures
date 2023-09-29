package PubFightAdventures

class Ranger(name: String, hp: Double, damage: Double, cursed: Boolean) : Hero(name, hp, damage, cursed) {
    override fun toString(): String {
        return name
    }


    //TODO: SKILLS

    /**
     * Mit Flaschenwurf wirft der Ranger mit einer Flasche nach einem Gegner. Sollte die Flasche dabei zerspringen,
     * so fallen Scherben auf den Boden der gegnerischen Mannschaft, die für 3 Runden lang Bleeding verursachen.
     */
    var flaschenwurf = Skill("Flaschenwurf", 35.0, 2, false, false, false, 0)


    /**
     * Mit der Bierfontäne kann der Ranger aus sicherer Entfernung die gegnerische Mannschaft flächendeckend die Sicht stören,
     * sodass ihre Angriffe ins leere treffen. !! Block.
     */
    var bierfontaene = Skill("Bierfontäne", 0.0, 5, false, false, false, 0)


    /**
     * Wenn der Ranger erst seine Pom Poms rausholt und anfängt seine Kameraden zu motivieren,
     * ist kein Glas mehr sicher! Die Werte des gesamten Teams steigen für 3 Runden um 30%.
     */
    var anfeuern = Skill("Anfeuern", 0.0, 3, false, false, false, 0)


    /**
     * Der Ranger ist ein geübter Dartspieler. Mit feinster Präzision trifft er immer ins Schwarze!
     */
    var dartwurf = Skill("Dartwurf", 20.0, 15, false, false, false, 0)

    var rangerSkills = listOf(
        flaschenwurf,
        bierfontaene,
        anfeuern,
        dartwurf
    )

    public fun attack() {

        var skillNamen = rangerSkills
        println("Wähle einen Angriff aus!")
        println(
            "1 für ${rangerSkills.elementAt(0)}                    \uD83C\uDF00 \uD83D\uDDE1\uFE0F${
                calculateSkill(
                    rangerSkills[0],
                    ranger
                ).toDouble()
            }                       | Uses left: ${rangerSkills.elementAt(0).uses}"
        )
        println(
            "2 für ${rangerSkills.elementAt(1)}                      \uD83C\uDF00               | Uses left: ${rangerSkills.elementAt(1).uses}"
        )
        println(
            "3 für ${rangerSkills.elementAt(2)}                     ❤\uFE0F\u200D\uD83D\uDD25 \uD83D\uDDE1\uFE0F                     | Uses left: ${rangerSkills.elementAt(2).uses}"
        )
        println(
            "4 für ${rangerSkills.elementAt(3)}                         \uD83D\uDDE1\uFE0F${
                calculateSkill(
                    rangerSkills[3],
                    ranger
                ).toDouble()
            }                       | Uses left: ${rangerSkills.elementAt(3).uses}"
        )

        val eingabe = readln()
        val index = eingabe.toInt() - 1
        clearConsole()

        val target = chooseTarget(enemies)
        val attacke = skillNamen.elementAt(index)
        val schadenBerechnung: Double = calculateSkill(attacke, ranger)
        val schaden = criticalHit(schadenBerechnung)

        if (enemy1.rauchbombe.effect == true) {
            enemy1.rauchbombe.effect = false
            println("Du siehst nichts und verfehlst...")
        } else if (ranger.hp > 0) {
            if (rangerSkills[index].uses > 0) {
                if (index == 2) {
                    if (ranger.anfeuern.effect == false) {
                        ranger.anfeuern.effect = true
                        println("$YELLOW${ranger.name} packt seine Pom Poms aus und motiviert das Team!$RESET")
                        for (hero in heroe) {
                            hero.hp += (hero.maxHp * 0.3)
                            hero.damage += 0.3
                        }
                    }

                } else if (index == 0) {

                    if (ranger.flaschenwurf.effect == false) {
                        ranger.flaschenwurf.effect = true
                        println("$attacke verursacht ${schaden.toDouble()} Schaden am ${target.name}!")
                        target.hp -= schaden.toDouble()
                        rangerSkills[index].uses -= 1
                        println("${YELLOW}Der Boden ist voller Scherben.$RESET")
                    }

                } else if (index == 1) {
                    if (ranger.bierfontaene.effect == false) {
                        ranger.bierfontaene.effect = true
                        println("Du spritzt mit Bier um dich...")
                        rangerSkills[index].uses -= 1
                    }

                } else if (rangerSkills[index].charge == true) {
                    rangerSkills[index].charge = false
                    rangerSkills[index].charging = true

                    println("Sie haben $attacke gewählt. Diese Attacke muss sich noch eine Runde aufladen")
                } else {

                    if (rangerSkills[index].charging == true) {

                        rangerSkills[index].charging = false
                        println("Die Ladephase für $attacke ist vorbei!")
                        println("Du verursachst ${schaden.toDouble()} Schaden am ${target.name}")
                        target.hp -= schaden.toInt()
                        rangerSkills[index].uses -= 1
                        rangerSkills[index].charge = true
                    } else {
                        println("$attacke verursacht ${schaden.toDouble()} Schaden am ${target.name}!")
                        target.hp -= schaden.toDouble()
                        rangerSkills[index].uses -= 1
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