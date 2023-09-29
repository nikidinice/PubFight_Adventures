package PubFightAdventures

import kotlin.math.roundToInt

/**
 * Globale Variablen, um sie in allen Funktionen nutzen zu können
 */

var fighter = Fighter("", 120.0, 1.0, false)
var trickster = Trickster("", 110.0, 1.0, false)
var ranger = Ranger("", 100.0, 1.0, false)
var inventory = Inventory()
var heroe = listOf(fighter, trickster, ranger)
var heroes = heroe
var randomHero = heroe.random()

var enemy1 = Boss("Kneipenboss", 400.0, 1.0, false)
var enemy2 = Sideboss("Couseng", 150.0, 1.0, false)
var enemies: MutableList<Enemy> = mutableListOf(enemy1)
var randomEnemy = enemies.random()

var round = 0

fun rundenZaehler() {
    round++
    return println("${GREEN}Runde: $round$RESET")
}

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
    if (enemy1.couseng.uses > 0) {
        println("$YELLOW.-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Fight Stats -=-=-=-=-=-=-=-=-=-=-=-=-=-=-.$RESET")
        println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
        println("$YELLOW|$RESET                       ${fighter.name} hat $GREEN${fighter.hp.roundToInt()}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                       ${trickster.name} hat $GREEN${trickster.hp.roundToInt()}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                       ${ranger.name} hat $GREEN${ranger.hp.roundToInt()}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                  Der Kneipenboss hat $RED${enemy1.hp}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                                                                       ")
        println("$YELLOW|$RESET             Schreibe $YELLOW'1' - '2' - '3'$RESET für die Rollenauswahl            $YELLOW|$RESET")
        println("$YELLOW|$RESET                oder $GREEN'4'$RESET um auf dein Inventar zuzugreifen              $YELLOW|$RESET")
        println("$YELLOW`-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'$RESET")
        println("")
        println("")
    } else {
        println("$YELLOW.-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Fight Stats -=-=-=-=-=-=-=-=-=-=-=-=-=-=-.$RESET")
        println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
        println("$YELLOW|$RESET                       ${fighter.name} hat $GREEN${fighter.hp}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                       ${trickster.name} hat $GREEN${trickster.hp}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                       ${ranger.name} hat $GREEN${ranger.hp}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                  Der Kneipenboss hat $RED${enemy1.hp}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                    Der Couseng hat $RED${enemy2.hp}$RESET❤\uFE0F Lebenspunkte")
        println("$YELLOW|$RESET                                                                       ")
        println("$YELLOW|$RESET             Schreibe $YELLOW'1' - '2' - '3'$RESET für die Rollenauswahl            $YELLOW|$RESET")
        println("$YELLOW|$RESET                oder $GREEN'4'$RESET um auf dein Inventar zuzugreifen              $YELLOW|$RESET")
        println("$YELLOW`-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'$RESET")
        println("")
        println("")
    }
}


fun playerAttack() {

    println("${YELLOW}1. ${fighter.name}")
    println("2. ${trickster.name}")
    println("3. ${ranger.name}")
    println("${GREEN}4. Inventar$RESET")

    val input = readln().toIntOrNull()
    clearConsole()

    when (input) {
        1 -> fighter.attack()
        2 -> trickster.attack()
        3 -> ranger.attack()
        4 -> inventory.useItem()
        5 -> fighter.hp -= 25                   //TODO: Entwickler-Modus - zu Testzwecken dem Fighter Schaden abziehen
        6 -> for (hero in heroe) {
            hero.hp -= 25                           //TODO: Entwickler-Modus - zu Testzwecken dem Fighter Schaden abziehen
        }

        else -> {
            println("${RED}Ungültige Eingabe$RESET\nBitte wähle eine Zahl zwischen 1 und 4\n")
            playerAttack()
        }
    }
}

fun isHpBelowMin() {
    if (fighter.hp < 0) {
        fighter.hp = 0.0
    } else if (trickster.hp < 0) {
        trickster.hp = 0.0
    } else if (ranger.hp < 0) {
        ranger.hp = 0.0
    } else if (enemy1.hp < 0) {
        enemy1.hp = 0.0
    } else if (enemy2.hp < 0) {
        enemy2.hp = 0.0
    }
}

fun isGameOver() {
    if (enemy1.couseng.uses <= 0) {
        if (fighter.hp <= 0 && trickster.hp <= 0 && ranger.hp <= 0) {
            abschnitt()
            println("Du hast das Spiel verloren. Der Kneipenboss gewinnt!")
        } else if (enemy1.hp <= 0 && enemy2.hp <= 0) {
            abschnitt()
            gewonnenvisual()
        }
    } else {
        if (fighter.hp <= 0 && trickster.hp <= 0 && ranger.hp <= 0) {
            abschnitt()
            println("Du hast das Spiel verloren. Der Kneipenboss gewinnt!")
        } else if (enemy1.hp <= 0) {
            enemy2.hp -= 9999
            abschnitt()
            gewonnenvisual()
        }
    }
}


fun enemyAttack() {                                         // Schleifen der gegnerischen KI
    println()
    enemy1.attack()
    println()
    enemy2.attack()
    println()
}

fun calculateSkill(skill: Skill, role: Hero): Double {      // Multipliziere den Schaden mit dem Multiplikator der Rolle. Wichtig wenn es um Buffs oder Tränke geht
    return skill.damage * role.damage
}


fun isCursed(hero: Hero) {                                   // Abfrage ob ein Spieler verflucht ist
    if (hero.cursed == true) {
        val schaden = hero.maxHp * 0.1
        hero.hp -= schaden
        println("${YELLOW}${hero.name} leidet unter dem Gift und verliert $schaden HP!$RESET")
        if (hero.hp <= hero.maxHp * 0.2) {
            hero.cursed = false
            println("${YELLOW}Der ${hero.name} hat das Gift überstanden!$RESET")
        }
    }
}

fun isCursedAll(heroe: List<Hero>) {
    for (hero in heroe){
        isCursed(hero)
    }
}


fun chooseTarget(enemies: List<Enemy>): Enemy {
    println("Wen möchtest du angreifen?")                               //Anzeigen, was sich in der Liste befindet
    for ((index, enemy) in enemies.withIndex()) {
        println("${index + 1}. ${enemy.name} (HP: ${enemy.hp})")
    }

    val eingabe = readln()                                       //Auswahl des Spielers
    clearConsole()

    for ((index, enemy) in enemies.withIndex()) {           //Rückgabewert formulieren aka. Position des Gegners in der Liste
        if (eingabe == (index + 1).toString()) {
            // Den entsprechenden Gegner zurückgeben
            return enemy
        }
    }

    // Eine Nachricht ausgeben, wenn die Eingabe ungültig ist
    println("Ungültige Eingabe. Bitte wähle ein gültiges Ziel.")

    // Die Funktion rekursiv aufrufen, bis eine gültige Eingabe eingegeben wird
    return chooseTarget(enemies)
}