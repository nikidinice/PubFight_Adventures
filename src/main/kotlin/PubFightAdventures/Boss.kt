package PubFightAdventures

import kotlin.random.Random

open class Boss(name: String, hp: Double, damage: Double, cursed: Boolean) : Enemy(name, hp, damage, cursed) {
    override fun toString(): String {
        return name
    }


    /**
     * Mit dieser Fähigkeit schmeißt der Kneipenboss Geld auf die Gegner, welches alle anderen Besucher des Pubs haben wollen.
     * Bei ihrem gierigen Versuch etwas zu fangen rangeln und schlagen sich die Besucher und jeder Held kriegt dabei etwas ab.
     * !! Flächenschaden !!
     */
    var geld = Skill("Geld", 25.0, 5, false, false, false, 0)


    /**
     * Der Boss möchte dich wissen lassen, wer hier der Chef ist und gibt dir einen saftigen Punch ins Gesicht
     */
    var kissRing = Skill("Küss den Ring", 25.0, 15, false, false, false, 0)


    /**
     * Mit dieser Fähigkeit kann der Kneipenboss seinen Couseng ins Kampfgeschehen bringen, welcher ihn im Kampf bis zum bitteren Ende unterstützt
     */
    var couseng = Skill("Couseng", 0.0, 1, false, false, false, 0)


    /**
     * Mit der Fähigkeit Ehrenlos bietet der Kneipenboss einem Helden einen kostenlosen Shot an, welcher der Säufer natürlich nicht abschlagen kann.
     * Statt feinsten Spirituosen trinkt der Held pures Gift & leidet so lange, bis seine Lebenspunkte weniger als 20% betragen.
     */
    var ehrenlos = Skill("Ehrenlos", 0.0, 1, false, false, false, 0)


    /**
     * Mit dieser Fähigkeit sucht sich der Kneipenboss einen Stuhl und zieht ihn sofort einem der Helden über den Schädel
     */
    var stuhl = Skill("Stuhl", 50.0, 3, false, false, false, 0)


    /**
     * Mit dieser Fähigkeit kann sich der Kneipenboss wie eine Pussy verstecken und somit erleidet das Team 1 Runde keinen Schaden
     */
    var rauchbombe = Skill("Block", 0.0, 5, false, false, false, 0)


    var bossSkills = listOf(
        geld,
        kissRing,
        couseng,
        ehrenlos,
        stuhl,
        rauchbombe
    )

    public fun attack() {

        var skillNamen = bossSkills

        var randomHero = heroe[Random.nextInt(heroe.size)]

        val eingabe = 1..6
        val index = eingabe.random() - 1

        val attacke = skillNamen.elementAt(index)
        val schadenBerechnung: Double = calculateSkill(attacke, enemy1)
        val schaden = criticalHit(schadenBerechnung)

        if (ranger.bierfontaene.effect == true) {
            ranger.bierfontaene.effect = false
            println("Der Gegner sieht nichts und verfehlt")
        } else if (enemy1.hp > 0) {
            if (bossSkills[index].uses > 0) {
                if (ranger.bierfontaene.effect == true) {
                    ranger.bierfontaene.effect = false
                    println("Der Gegner hat verfehlt!")
                } else
                    if (index == 0) {
                        for (hero in heroe) {
                            hero.hp -= enemy1.geld.damage
                        }
                        println(
                            "Der ${enemy1.name} bewirft euch mit Geld.\n" +
                                    "Um euch herum schlagen sich die Leute um das Geld und erwischen euch dabei...\n" +
                                    "${RED}Alle Helden erleiden ${enemy1.geld.damage} Schaden$RESET"
                        )

                    } else if (index == 1) {
                        println("$attacke verursacht ${schaden.toDouble()} Schaden an $YELLOW$randomHero$RESET!")
                        randomHero.hp -= schaden.toDouble()
                        bossSkills[index].uses -= 1
                    } else if (index == 2) {
                        enemy1.couseng.uses -= 1
                        enemies.add(enemy2)
                        println("Der Kneipenboss ruft seinen Couseng...\n${RED}Ein neuer Gegner ist erschienen!$RESET")
                    } else if (index == 3) {
                        if (bossSkills[index].uses > 0) {
                            randomHero.cursed = true
                            enemy1.ehrenlos.uses -= 1

                            println(
                                "Der Boss bietet ${randomHero.name} einen ${GREEN}kostenlosen Shot$RESET an, welchen der Säufer natürlich nicht abschlagen kann.\n" +
                                        "Statt feinsten Spirituosen trinkt der Held ${RED}pures Gift$RESET!\n"
                            )
                        } else {
                            println("Der Boss kann keinen Shot mehr anbieten!")
                        }
                    } else if (index == 4) {
                        println("$attacke verursacht ${schaden.toDouble()} Schaden an $YELLOW$randomHero$RESET!")
                        randomHero.hp -= schaden.toDouble()
                        bossSkills[index].uses -= 1
                    } else if (index == 5) {
                        if (bossSkills[index].uses > 0)
                            if (enemy1.rauchbombe.effect == false) {
                                enemy1.rauchbombe.effect = true
                                println("$enemy1 wirft eine Rauchgranate...")
                                bossSkills[index].uses -= 1
                            }
                    }
                isFalschenwurfActive()
            } else {
                println("Die Attacke $attacke wurde aufgebraucht!")
            }
        }
    }
}
