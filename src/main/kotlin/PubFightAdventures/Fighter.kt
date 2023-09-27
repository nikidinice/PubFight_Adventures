package PubFightAdventures

class Fighter(
    name: String,
    hp: Double,
    damage: Double
) :
    Hero(name, hp, damage) {


    //TODO: SKILLS

    /**
     * Die Fähigkeit Fist of Zen benötigt eine Ladephase von einer Runde.
     * Dies blockiert zwar weitere Aktionen in einer Runde, fügt jedoch erheblichen Schaden zu
     */

    var fistOfZen = Skill("Fist of Zen", damage * 100.0, 2, true, false)                         //ab 0.5 Fähigkeiten als Klassen


    /**
     * Die Fähigkeit Bronzene Kniescheibe ermöglicht es dem Fighter seine Kniescheibe als Geschoss zu verwenden
     */

    var bronzeneKniescheibe = Skill("Bronzene Kniescheibe", damage * 35.0, 5, false, false)


    /**
     * Die Fähigkeit Tokat verteilt eine feurige Schelle ins Gesicht des Gegners
     */
    var tokat = Skill("Tokat", damage * 25.0, 15, false, false)

    /**
     * Setzt der Fighter Booze ein, greift der Held zur nächstgelegenen Flasche und trinkt sie aus.
     * Dadurch erhält er für 3 Runden einen HP-Boost von 10% und einen Schadens-Boost von 25%.
     */
    var booze = Skill("Booze", damage * 0.0, 15, false, false)


    var fighterSkills = listOf(
        fistOfZen,
        bronzeneKniescheibe,
        tokat,
        booze
    )

    public fun fighterAttack() {

        var skillNamen = fighterSkills
        println("Wähle einen Angriff aus!")
        println("1 für ${fighterSkills.elementAt(0)}                    \uD83D\uDDE1\uFE0F${calculateSkill(fighterSkills[0], fighter).toDouble()}                 | Uses left: ${fighterSkills.elementAt(0).uses}")
        println("2 für ${fighterSkills.elementAt(1)}            \uD83D\uDDE1\uFE0F${calculateSkill(fighterSkills[1], fighter).toDouble()}        | Uses left: ${fighterSkills.elementAt(1).uses}")
        println("3 für ${fighterSkills.elementAt(2)}                        \uD83D\uDDE1\uFE0F${calculateSkill(fighterSkills[2], fighter).toDouble()}                       | Uses left: ${fighterSkills.elementAt(2).uses}")
        println("4 für ${fighterSkills.elementAt(3)}                        \uD83D\uDDE1\uFE0F${calculateSkill(fighterSkills[3], fighter).toDouble()}                       | Uses left: ${fighterSkills.elementAt(3).uses}")

        val eingabe = readln()
        val index = eingabe.toInt() - 1

        val attacke = skillNamen.elementAt(index)
        val schadenBerechnung: Double = calculateSkill(attacke, fighter)
        val schaden = criticalHit(schadenBerechnung)

            if (fighterSkills[index].uses > 0) {
                // Überprüfe, ob die Fähigkeit eine Ladephase hat
                if (fighterSkills[index].charge == true) {
                    // Setze charge auf false und charging auf true
                    fighterSkills[index].charge = false
                    fighterSkills[index].charging = true
                    // Sage dem Benutzer, dass die Fähigkeit sich auflädt
                    println("Sie haben $attacke gewählt. Diese Attacke muss sich noch eine Runde aufladen")
                } else {
                    // Überprüfe, ob die Fähigkeit sich auflädt oder bereit ist
                    if (fighterSkills[index].charging == true) {
                        // Setze charging auf false und führe die Fähigkeit aus
                        fighterSkills[index].charging = false
                        println("Die Ladephase für $attacke ist vorbei!")
                        println("Du verursachst ${schaden.toDouble()} Schaden")
                        enemy1.hp -= schaden.toInt()
                        fighterSkills[index].uses -= 1
                        fighterSkills[index].charge = true
                    } else {
                        // Führe die Fähigkeit aus, wenn sie keine Ladephase hat
                        println("$attacke verursacht ${schaden.toDouble()} Schaden!")
                        enemy1.hp -= schaden.toDouble()
                        fighterSkills[index].uses -= 1
                    }
                }
            } else {
                // Sage dem Benutzer, dass die Fähigkeit nicht mehr verfügbar ist
                println("Die Attacke $attacke wurde aufgebraucht!")
            }
    }
}