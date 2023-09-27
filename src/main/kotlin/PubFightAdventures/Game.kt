package PubFightAdventures

/**
 * Globale Variablen, um sie in allen Funktionen nutzen zu können
 */

var fighter = Fighter("", 120.0, 1.0)
var trickster = Trickster("", 110.0, 1.0)
var ranger = Ranger("", 100.0, 1.0)
var inventory = Inventory()
var heroes = listOf(fighter, trickster, ranger)

var enemy1 = Boss("Kneipenboss", 250.0)
var enemy2 = Sideboss("Couseng", 100.0)
var enemies = mutableListOf(enemy1, enemy2)
var round = 1

fun nameCharacter() {

    nameCharacterVisual()
    fighterVisual()
    println("Gebe dem Fighter einen Namen:")
    fighter.name = readln()
    abschnitt()

    tricksterVisual()
    println("Gebe dem Trickster einen Namen:")
    trickster.name = readln()
    abschnitt()

    rangerVisual()
    println("Gebe dem Ranger einen Namen:")
    ranger.name = readln()
    abschnitt()

}

fun gameStatus() {

    println("$YELLOW.-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Fight Stats -=-=-=-=-=-=-=-=-=-=-=-=-=-=-.$RESET")
    println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
    println("$YELLOW|$RESET                       ${fighter.name} hat $GREEN${fighter.hp}$RESET❤\uFE0F Lebenspunkte")
    println("$YELLOW|$RESET                       ${trickster.name} hat $GREEN${trickster.hp}$RESET❤\uFE0F Lebenspunkte")
    println("$YELLOW|$RESET                       ${ranger.name} hat $GREEN${ranger.hp}$RESET❤\uFE0F Lebenspunkte")
    println("$YELLOW|$RESET                  Der Kneipenboss hat $RED${enemy1.hp}$RESET❤\uFE0F Lebenspunkte")
    println("$YELLOW|$RESET                                                                       ")
    println("$YELLOW|$RESET             Schreibe $YELLOW'1' - '2' - '3'$RESET für die Rollenauswahl            $YELLOW|$RESET")
    println("$YELLOW|$RESET                oder $GREEN'4'$RESET um auf dein Inventar zuzugreifen              $YELLOW|$RESET")
    println("$YELLOW`-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'$RESET")
    println("")
    println("")
}


fun playerAttack() {

    println("1. ${fighter.name}")
    println("2. ${trickster.name}")
    println("3. ${ranger.name}")
    println("4. Inventar")

    val input = readln().toIntOrNull()
    clearConsole()

    when (input) {
        1 -> fighter.fighterAttack()
        2 -> trickster.tricksterSkills
        3 -> ranger.rangerSkills
        4 -> inventory.useItem()
        5 -> fighter.hp -= 25                   //TODO: Entwickler-Modus - zu Testzwecken dem Fighter Schaden abziehen
        else -> {
            println("${RED}Ungültige Eingabe$RESET\nBitte wähle eine Zahl zwischen 1 und 4\n")
            playerAttack()
        }
    }
}

fun calculateSkill(skill: Skill, role: Hero): Double {
    // Multipliziere den Schaden der Fähigkeit mit dem Schaden der Rolle
    return skill.damage * role.damage
}