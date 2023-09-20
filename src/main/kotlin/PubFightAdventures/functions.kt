package PubFightAdventures

import kotlin.random.Random

/**
 * Hier bündel ich alle Funktionen, die zum Spiel gehören, um die Übersichtlichkeit in der Main zu gewährleisten
 */

//TODO: Background Functions

fun clearConsole() {                                            //Erstellt 50 leere printlines, um die Konsole aufzuräumen
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
    return (300..400).random()
}
fun randomDamageEnemy(): Int {
    return (120..150).random()
}

fun criticalHit(damage: Int): Int {
    val chance = Random.nextInt(1, 100)                 //1. Step: Random Zahl zwischen 1 & 100 generieren
    val multiplier = 1.5

    return if (chance <= 5) {                                          //2. Step: if-Schleife, falls Zahl 5 oder drunter liegt (5% Chance)
        val criticalDamage = (damage * multiplier).toInt()         //3. Step: Wenns eintritt, wird Schaden 1.5x erhöht
        println("${RED}Kritischer Treffer!$RESET")
        criticalDamage
    } else {
        damage
    }
}







//TODO: Simple Kampf-Mechanik
fun simpleFight() {                                         // Kampf-Logik verstehen - simpel ohne Klassen oder komplexe Skills

    //Kämpfer Stats, Items nützliche Funktionen
    var playerHP = 1500
    var enemyHP = 4000
    var round = 1
    val healpotion = 200

    while (playerHP > 0 && enemyHP > 0 && round < 300) {
        println("$YELLOW.-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Fight Stats -=-=-=-=-=-=-=-=-=-=-=-=-=-=-.$RESET")
        println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
        println("$YELLOW|$RESET Der Säufer hat $GREEN$playerHP$RESET Lebenspunkte                                      $YELLOW|$RESET")
        println("$YELLOW|$RESET Der Kneipenboss hat $RED$enemyHP$RESET Lebenspunkte                                 $YELLOW|$RESET")
        println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
        println("$YELLOW|$RESET      Schreib $YELLOW'a'$RESET für Angriff oder $GREEN'h'$RESET um dich zu heilen               $YELLOW|$RESET")
        println("$YELLOW`-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'$RESET")
        println("")
        println("")

        //Entscheidung des Spielers
        var eingabe = readln()

        //Entscheidungen von Spieler
        if (eingabe == "a") {
            clearConsole()

            yourturnVisual()

            //Angriffskraft der Spieler um Funktion criticalHit erweitert.
            //Ab v.36 in die if gepackt, weil die critHit-Meldung sonst unter den Fight-Stats kommt??
            val heroDamage = criticalHit(randomDamageHero())
            val enemyDamage = criticalHit(randomDamageEnemy())

            //Zug des Spielers
            enemyHP -= heroDamage
            println("                Du hast den Gegner mit $heroDamage Schaden verwundet")
            abschnitt()
            Thread.sleep(1000)

            enemyturnVisual()

            //Zug des Gegners
            playerHP -= enemyDamage
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
            val enemyDamage = criticalHit(randomDamageEnemy())

            //Angriff des Gegners
            playerHP -= enemyDamage
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
        println("$YELLOW                ███████ ██    ██ ███████ ███████     ██    ██ ███    ███ ███████  ██████  ███    ██ ███████ ████████                \n" +
                "                ██      ██    ██ ██      ██          ██    ██ ████  ████ ██      ██    ██ ████   ██ ██         ██                   \n" +
                "                ███████ ██    ██ █████   █████       ██    ██ ██ ████ ██ ███████ ██    ██ ██ ██  ██ ███████    ██                   \n" +
                "                     ██ ██    ██ ██      ██          ██    ██ ██  ██  ██      ██ ██    ██ ██  ██ ██      ██    ██                   \n" +
                "                ███████  ██████  ██      ██           ██████  ██      ██ ███████  ██████  ██   ████ ███████    ██                   \n" +
                "                                                                                                                                    \n" +
                "                                                                                                                                    \n" +
                "${GREEN}██████  ██    ██     ██   ██  █████  ███████ ████████      ██████  ███████ ██     ██  ██████  ███    ██ ███    ██ ███████ ███    ██ \n" +
                "██   ██ ██    ██     ██   ██ ██   ██ ██         ██        ██       ██      ██     ██ ██    ██ ████   ██ ████   ██ ██      ████   ██ \n" +
                "██   ██ ██    ██     ███████ ███████ ███████    ██        ██   ███ █████   ██  █  ██ ██    ██ ██ ██  ██ ██ ██  ██ █████   ██ ██  ██ \n" +
                "██   ██ ██    ██     ██   ██ ██   ██      ██    ██        ██    ██ ██      ██ ███ ██ ██    ██ ██  ██ ██ ██  ██ ██ ██      ██  ██ ██ \n" +
                "██████   ██████      ██   ██ ██   ██ ███████    ██         ██████  ███████  ███ ███   ██████  ██   ████ ██   ████ ███████ ██   ████ \n" +
                "                                                                                                                                    \n" +
                "                                                                                                                                    $RESET \n")
    } else {
        abschnitt()
        println("Das Spiel ist nach $round Runden beendet.")
    }
}

