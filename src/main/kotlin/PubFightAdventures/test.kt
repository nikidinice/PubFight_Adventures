package PubFightAdventures

//fun simpleFight2() {                                         // simple Kampflogik mit Charge-Funktion ausgetest
//
//    //Kämpfer Stats, Items nützliche Funktionen
//    var playerHP = 1500
//    var enemyHP = 4000
//    var round = 1
//    val healpotion = 200
//    var playerCharge = false
//
//    while (playerHP > 0 && enemyHP > 0 && round < 300) {
//        println("$YELLOW.-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Fight Stats -=-=-=-=-=-=-=-=-=-=-=-=-=-=-.$RESET")
//        println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
//        println("$YELLOW|$RESET Der Säufer hat $GREEN$playerHP$RESET Lebenspunkte                                      $YELLOW|$RESET")
//        println("$YELLOW|$RESET Der Kneipenboss hat $RED$enemyHP$RESET Lebenspunkte                                 $YELLOW|$RESET")
//        println("$YELLOW|$RESET                                                                       $YELLOW|$RESET")
//        println("$YELLOW|$RESET      Schreib $YELLOW'a'$RESET für Angriff oder $GREEN'h'$RESET um dich zu heilen               $YELLOW|$RESET")
//        println("$YELLOW`-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-'$RESET")
//        println("")
//        println("")
//
//        //Entscheidung des Spielers
//        var eingabe = readln()
//
//        //Entscheidungen von Spieler
//        if (eingabe == "a") {
//            clearConsole()
//
//
//            yourturnVisual()
//
//            // Angriffskraft des Spielers um Funktion criticalHit erweitert und verdoppelt
//            val heroDamage = criticalHit(randomDamageHero()) * 2
//
//            // Zug des Spielers
//            enemyHP -= heroDamage
//            println("                Du hast den Gegner mit einem mächtigen Schlag mit $heroDamage Schaden verwundet")
//            abschnitt()
//            Thread.sleep(1000)
//
//            enemyturnVisual()
//
//            // Zug des Gegners
//            val enemyDamage = criticalHit(randomDamageEnemy())
//            playerHP -= enemyDamage
//            println("                Der Gegner hat dich mit $enemyDamage Schaden verwundet")
//            Thread.sleep(1000)
//            round++
//
//            // Den Aufladestatus des Spielers zurücksetzen
//            playerCharge = false
//        } else {
//            clearConsole()
//
//            yourturnVisual()
//
//            // Den Spieler aufladen
//            println("                Du lädst dich auf und bereitest dich auf einen mächtigen Schlag vor")
//            abschnitt()
//            Thread.sleep(1000)
//
//            enemyturnVisual()
//
//            // Zug des Gegners
//            val enemyDamage = criticalHit(randomDamageEnemy())
//            playerHP -= enemyDamage
//            println("                Der Gegner hat dich mit $enemyDamage Schaden verwundet")
//            Thread.sleep(1000)
//            round++
//
//            // Den Aufladestatus des Spielers auf true setzen
//            playerCharge = true
//        }
//    }
//}

fun main() {                                                        //Ansätze von Menü & Wahl - objektorientiert

    var player1 = Fighter("", 120)
    var player2 = Trickster("", 110)
    var player3 = Ranger("", 100)
    var heroes = listOf(player1, player2, player3)

    var enemy1 = Boss("Kneipenboss", 250)
    var enemy2 = Sideboss("Couseng", 100)
    var enemies = listOf(enemy1, enemy2)

    println("Es gibt 3 verschiedene Rollen!\nGebe dem Fighter einen Namen:")
    player1.name = readln()
    println("Gebe dem Trickster einen Namen:")
    player2.name = readln()
    println("Gebe dem Ranger einen Namen:")
    player3.name = readln()
    println()
    println("Dein Team")
    println("__________")
    println("Fighter: ${player1.name}   |   Trickster: ${player2.name}   |   Ranger: ${player3.name}")
    println()

    while (player1.hp > 0 && player2.hp > 0 && player3.hp > 0 && enemy1.hp > 0 && enemy2.hp > 0) {
        println(
            "1: Boss | HP: ${enemy1.hp}\n" +
                    "2: Sideboss | HP: ${enemy2.hp}\n" +
                    "Wen möchtest du angreifen? Schreibe 1 oder 2"
        )

        var input = readln()
        var decision = mutableListOf<Enemy>()

        for (char in input) {
            when (char) {
                '1' -> decision.add(enemy1)
                '2' -> decision.add(enemy2)
                else -> println("$input gibt es nicht. Bitte wähle 1 oder 2.")
            }
        }

        for (enemy in decision) {
            player1.fistOfZen.useSkill(player1.fistOfZen, enemy)
            println("${enemy.name} trifft ${enemy.name} mit ${player1.fistOfZen.useSkill(player1.fistOfZen, enemy).} Schaden.")
        }
        if (player1.hp <= 0 && player2.hp <= 0 && player3.hp <= 0) {
            abschnitt()
            println("Du hast das Spiel verloren. Der Kneipenboss gewinnt!")
        } else if (enemy1.hp <= 0 && enemy2.hp <= 0) {
            abschnitt()
            println("Gewonnen Schweinebacke!")
        }
    }
}