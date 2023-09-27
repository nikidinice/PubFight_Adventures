package PubFightAdventures

/**
 * BITTE DIE KONSOLE HOCHFAHREN & DAS SPIEL GENIEßEN!
 */
fun main() {
        intro()
//    simpleFight()
    nameCharacter()
    clearConsole()
    while (fighter.hp > 0 && trickster.hp > 0 && ranger.hp > 0 && enemy1.hp > 0 && enemy2.hp > 0) {
        gameStatus()
        playerAttack()
    }
}
