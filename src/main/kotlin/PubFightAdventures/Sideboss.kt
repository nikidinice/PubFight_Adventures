package PubFightAdventures

import kotlin.random.Random

class Sideboss(name: String, hp: Double, damage: Double, cursed: Boolean) : Enemy(name, hp, damage, cursed) {

    override fun toString(): String {
        return name
    }


    /**
     * Der Couseng vom Kneipenboss ist nicht die hellste Birne, aber seinen besoffenen Körper zu schwingen, klappt noch... irgendwie...
     */
    var tritt = Skill("Tritt", 20.0, 10, false, false, false, 0)
    var schlag = Skill("Schlag", 20.0, 10, false, false, false, 0)
    var kopfnuss = Skill("Kopf", 20.0, 10, false, false, false, 0)
    var ellenbogen = Skill("Ellenbogen", 20.0, 10, false, false, false, 0)

    var sidebossSkills = listOf(
        tritt,
        schlag,
        kopfnuss,
        ellenbogen
    )

    public fun attack() {

        var skillNamen = sidebossSkills

        var randomHero = heroe[Random.nextInt(heroe.size)]

        val eingabe = 1..4
        val index = eingabe.random() - 1

        val attacke = skillNamen.elementAt(index)
        val schadenBerechnung: Double = calculateSkill(attacke, enemy2)
        val schaden = criticalHit(schadenBerechnung)

        if (ranger.bierfontaene.effect == true) {
            ranger.bierfontaene.effect = false
            println("Der Gegner sieht nichts und verfehlt")
        } else if (enemy1.couseng.uses == 0) {
            if (enemy2.hp > 0) {
                if (sidebossSkills[index].uses > 0) {
                    if (ranger.bierfontaene.effect == true) {
                        ranger.bierfontaene.effect = false
                        println("Der Gegner hat verfehlt!")

                        //Bereich der Abfragen
                    } else
                        if (index == 0) {
                            println("$enemy2: $attacke verursacht ${schaden.toDouble()} Schaden an $YELLOW$randomHero$RESET!")
                            randomHero.hp -= schaden.toDouble()
                            sidebossSkills[index].uses -= 1

                        } else if (index == 1) {
                            println("$enemy2: $attacke verursacht ${schaden.toDouble()} Schaden an $YELLOW$randomHero$RESET!")
                            randomHero.hp -= schaden.toDouble()
                            sidebossSkills[index].uses -= 1

                        } else if (index == 2) {
                            println("$enemy2: $attacke verursacht ${schaden.toDouble()} Schaden an $YELLOW$randomHero$RESET!")
                            randomHero.hp -= schaden.toDouble()
                            sidebossSkills[index].uses -= 1

                        } else if (index == 3) {
                            println("$enemy2: $attacke verursacht ${schaden.toDouble()} Schaden an $YELLOW$randomHero$RESET!")
                            randomHero.hp -= schaden.toDouble()
                            sidebossSkills[index].uses -= 1

                        } else {
                            println("Die Attacke $attacke wurde aufgebraucht!")
                        }
                }
            }
        }
    }
}
