package PubFightAdventures

class Trickster(name: String, hp: Double, damage: Double, cursed: Boolean) : Hero(name, hp, damage, cursed) {
    override fun toString(): String {
        return name
    }


    //TODO: SKILLS

    /**
     * Die Fähigkeit Fist of Zen benötigt eine Ladephase von einer Runde.
     * Dies blockiert zwar weitere Aktionen in einer Runde, fügt jedoch erheblichen Schaden zu.
     */
    var fingerNoJutsu = Skill("Finger no Jutsu", 100.0, 2, true, false, false, 0)


    /**
     * Die Fähigkeit Pocket Sand erlaubt es dem Spieler den Gegner für eine Runde erblinden zu lassen.
     * Dies blockt den Schaden des Gegners für die nächste Runde
     */
    var pocketSand = Skill("Pocket Sand", 0.0, 5, false, false, false, 0)


    /**
     * Der heimtückische Schlag vom Trickster sieht zwar oberflächlich so aus, als würde er nicht treffen,
     * doch so wie aus minus und minus plus wird, so sitzt der Schlag wie bei einem gekonnten Katanahieb.
     */
    var doubleFakeHit = Skill("Double-Fake Hit", 25.0, 15, false, false, false, 0)


    /**
     * Der Trickster greift in seine Trickkiste und holt Adrenalinspritzen aus. Das ganze Team erhält 25% mehr Gesundheit!
     */
    var adrenalin = Skill("Adrenalin", 0.25, 1, false, false, false, 0)

    var tricksterSkills = listOf(
        fingerNoJutsu,
        pocketSand,
        doubleFakeHit,
        adrenalin
    )

    public fun attack() {

        var skillNamen = tricksterSkills
        println("Wähle einen Angriff aus!")
        println(
            "1 für ${tricksterSkills.elementAt(0)}                    \uD83D\uDDE1\uFE0F${
                calculateSkill(
                    tricksterSkills[0],
                    trickster
                ).toDouble()
            }                       | Uses left: ${tricksterSkills.elementAt(0).uses}"
        )
        println(
            "2 für ${tricksterSkills.elementAt(1)}                      \uD83C\uDF00                  | Uses left: ${tricksterSkills.elementAt(1).uses}"
        )
        println(
            "3 für ${tricksterSkills.elementAt(2)}                     \uD83D\uDDE1\uFE0F${
                calculateSkill(
                    tricksterSkills[2],
                    trickster
                ).toDouble()
            }                       | Uses left: ${tricksterSkills.elementAt(2).uses}"
        )
        println(
            "4 für ${tricksterSkills.elementAt(3)}                         ❤\uFE0F\u200D\uD83D\uDD25                  | Uses left: ${tricksterSkills.elementAt(3).uses}"
        )

        val eingabe = readln()
        val index = eingabe.toInt() - 1
        clearConsole()

        val target = chooseTarget(enemies)
        val attacke = skillNamen.elementAt(index)
        val schadenBerechnung: Double = calculateSkill(attacke, trickster)
        val schaden = criticalHit(schadenBerechnung)

        if (enemy1.rauchbombe.effect == true) {
            enemy1.rauchbombe.effect = false
            println("Du siehst nichts und verfehlst...")
        } else if (trickster.hp > 0) {
            if (tricksterSkills[index].uses > 0) {
                if (index == 1) {
                    if (trickster.pocketSand.effect == false) {
                        trickster.pocketSand.effect = true
                        println("$YELLOW$trickster greift in seine Tasche und wirft mit Sand um sich$RESET")
                        tricksterSkills[index].uses -= 1
                    }
                } else if (index == 3) {
                    fighter.hp += (fighter.maxHp * trickster.adrenalin.damage)
                    trickster.hp += (trickster.maxHp * trickster.adrenalin.damage)
                    ranger.hp += (ranger.maxHp * trickster.adrenalin.damage)
                    tricksterSkills[3].uses -= 1


                } else if (tricksterSkills[index].charge == true) {
                    tricksterSkills[index].charge = false
                    tricksterSkills[index].charging = true

                    println("Sie haben $attacke gewählt. Diese Attacke muss sich noch eine Runde aufladen")
                } else {

                    if (tricksterSkills[index].charging == true) {

                        tricksterSkills[index].charging = false
                        println("Die Ladephase für $attacke ist vorbei!")
                        println("Du verursachst ${schaden.toDouble()} Schaden am ${target.name}")
                        target.hp -= schaden.toInt()
                        tricksterSkills[index].uses -= 1
                        tricksterSkills[index].charge = true
                    } else {
                        println("$attacke verursacht ${schaden.toDouble()} Schaden am ${target.name}!")
                        target.hp -= schaden.toDouble()
                        tricksterSkills[index].uses -= 1
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
