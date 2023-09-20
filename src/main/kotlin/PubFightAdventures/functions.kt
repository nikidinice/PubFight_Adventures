package PubFightAdventures

import kotlin.random.Random

/**
 * Hier bündel ich alle Funktionen, die zum Spiel gehören, um die Übersichtlichkeit zu gewährleisten
 */

//TODO: Background Functions

fun clearConsole() {
    for (i in 1..50) {
        println("")
    }
}

fun abschnitt() {
    for (i in 1..5) {
        println("")
    }
}

//TODO: Random-Schaden & Critical Hit
fun randomDamageHero(): Int {
    return (160..200).random()
}
fun randomDamageEnemy(): Int {
    return (50..70).random()
}

fun criticalHit(damage: Int): Int {

    val chance = Random.nextInt(1, 100)
    val multiplier = 1.5

    return if (chance <= 5) {
        val criticalDamage = (damage * multiplier).toInt()
        println("${RED}Kritischer Treffer!$RESET")
        criticalDamage
    } else {
        damage
    }
}


//TODO: Simple Kampf-Mechanik

fun simpleFight() {                                         // Kampf-Logik verstehen

    //Kämpfer Stats, Items nützliche Funktionen
    var playerHP = 1500
    var enemyHP = 4000
    var round = 1
    val healpotion = 100

    while (playerHP > 0 && enemyHP > 0 && round < 300) {
        println("$YELLOW.-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Fight Stats -=-=-=-=-=-=-=-=-=-=-=-=-=-=-.$RESET")
        println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
        println("$YELLOW|$RESET Der Säufer hat $GREEN$playerHP$RESET Lebenspunkte                                      $YELLOW|$RESET")
        println("$YELLOW|$RESET Der Kneipenboss hat $RED$enemyHP$RESET Lebenspunkte                                 $YELLOW|$RESET")
        println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
        println("$YELLOW|$RESET      Schreib $YELLOW'a'$RESET für Angriff oder $GREEN'h'$RESET um dich zu heilen               $YELLOW|$RESET")
        println("$YELLOW`-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'$RESET")


        //Entscheidung des Spielers
        var eingabe = readln()

        //Entscheidungen von Spieler
        if (eingabe == "a") {
            clearConsole()

            yourturnVisual()

            //Angriffskraft der Spieler um Funktion criticalHit erweitert
            val heroDamage = criticalHit(randomDamageHero())
            val enemyDamage = criticalHit(randomDamageEnemy())

            //Zug des Spielers
            enemyHP -= heroDamage
            println("                Du hast den Gegner mit $heroDamage Schaden verwundet")
            abschnitt()
            Thread.sleep(1000)

            enemyturnVisual()

            //Zug des Gegners
            playerHP -= criticalHit(randomDamageEnemy())
            println("                Der Gegner hat dich mit $enemyDamage Schaden verwundet")
            Thread.sleep(1000)
            round++
        }
        else if (eingabe == "h") {

            //Heilen
            playerHP += healpotion
            println("Du heilst dich um $healpotion Lebenspunkte")

            enemyturnVisual()

            //Angriffskraft der Spieler um Funktion criticalHit erweitert
            val heroDamage = criticalHit(randomDamageHero())
            val enemyDamage = criticalHit(randomDamageEnemy())

            //Angriff des Gegners
            playerHP -= criticalHit(randomDamageEnemy())
            println("                Der Gegner hat dich mit $enemyDamage Schaden verwundet")
            Thread.sleep(1000)
            round++
        } else {
            println("Du hast dich vertippt..")
        }
        abschnitt()
        println("Runde: $round")
    }
    if (playerHP <= 0) {
        abschnitt()
        println("Du hast das Spiel verloren. Der Kneipenboss gewinnt!")
    } else if (enemyHP <= 0) {
        abschnitt()
        println("Du hast das Spiel gewonnen. Der Kneipenboss wurde besiegt!")
    } else {
        abschnitt()
        println("Das Spiel ist nach $round Runden beendet.")
    }
}
private fun Int.random(): Any {
    return Int
}

