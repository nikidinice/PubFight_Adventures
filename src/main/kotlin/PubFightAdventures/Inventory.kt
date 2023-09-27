package PubFightAdventures

open class Inventory() {

    /**
     * Ein Heiltrank, der einen Helden um 50% seiner maximalen Lebenspunkte heilt
     */
    var healthPotion = Skill("Heiltrank", 0.5, 3, false, false)


    /**
     * Ein Trank, der einem Helden die Schadenswerte dauerhaft um 10% erhöht
     */
    var damagePotion = Skill("Schaden+", 1.1, 1, false, false)

    public var inventory = listOf(
        healthPotion,
        damagePotion
    )

    fun useItem() {
        println(
            "Wähle ein Item aus:\n\n" +
                    "1 für ${inventory.elementAt(0)}            Anzahl:${healthPotion.uses}\n" +
                    "2 für ${inventory.elementAt(1)}            Anzahl:${damagePotion.uses}\n"
        )

        val eingabe = readlnOrNull()
        val index = eingabe?.toIntOrNull()
        clearConsole()

        if (eingabe == "1") {
            if (healthPotion.uses > 0) {
                println("Wähle einen Spieler, den du heilen möchtest:")
                println("1. ${fighter.name}")
                println("2. ${trickster.name}")
                println("3. ${ranger.name}")

                val eingabe = readln().toIntOrNull()
                clearConsole()

                when (eingabe) {
                    1 -> {
                        fighter.hp += (fighter.maxHp * healthPotion.damage); healthPotion.uses -= 1
                        if (fighter.hp > fighter.maxHp) {
                            fighter.hp = fighter.maxHp
                        }
                        println(
                            "${GREEN}Die Lebenspunkte von ${fighter.name} wurden um 50% seiner maximalen Lebenspunkte geheilt!$RESET\n\n"
                        )
                    }

                    2 -> trickster.hp + (trickster.hp / 100 * healthPotion.damage)
                    3 -> ranger.hp + (ranger.hp / 100 * healthPotion.damage)
                    else -> {
                        println(
                            "${RED}Falsche Eingabe!\n" +
                                    "${RESET}Diesen Charakter gibt es nicht!\n" +
                                    "Probiere es erneut:\n"
                        )
                        useItem()
                    }
                }
            } else {
                println("${RED}Du hast alle deine Health Potions verbraucht$RESET\n\n")
            }
        } else if (eingabe == "2") {
            if (damagePotion.uses > 0) {
                println("Wähle eine Rolle, die du verstärken möchtest:")
                println("1. ${fighter.name}")
                println("2. ${trickster.name}")
                println("3. ${ranger.name}")

                val eingabe = readln().toIntOrNull()
                clearConsole()

                when (eingabe) {
                    1 -> {
                        fighter.damage *= damagePotion.damage;
                        println("Der Schaden von ${fighter.name} wurde permanent um 10% erhöht!")
                        damagePotion.uses -= 1
                    }

                    2 -> {
                        trickster.damage += damagePotion.damage
                    }

                    3 -> ranger.damage += damagePotion.damage
                    else -> println(
                        "${RED}Falsche Eingabe!\n" +
                                "${RESET}Dieses Item hast du nicht!"
                    )
                }
            }
        } else {
            println(
                "${RED}Falsche Eingabe!\n" +
                        "${RESET}Dieses Item hast du nicht!"
            )
            useItem()
        }
    }
}