package PubFightAdventures


//TODO: FARBCODES FÜR DIE UX/UI
val BLACK = "\u001B[30m"
val RED = "\u001B[31m"
val GREEN = "\u001B[32m"
val YELLOW = "\u001B[33m"
val BLUE = "\u001B[34m"
val MAGENTA = "\u001B[35m"
val CYAN = "\u001B[36m"
val WHITE = "\u001B[37m"
val RESET = "\u001B[0m"

val farben = listOf(BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, WHITE)
var Index = 0



//TODO: MAIN ZUM TESTEN
fun main() {
    intro()
}

fun intro() {
    clearConsole()

    println(
                "██     ██ ███████ ██       ██████  ██████  ███    ███ ███████ \n" +
                "██     ██ ██      ██      ██      ██    ██ ████  ████ ██      \n" +
                "██  █  ██ █████   ██      ██      ██    ██ ██ ████ ██ █████   \n" +
                "██ ███ ██ ██      ██      ██      ██    ██ ██  ██  ██ ██      \n" +
                " ███ ███  ███████ ███████  ██████  ██████  ██      ██ ███████ \n" +
                "                                                              \n"
    )

    Thread.sleep(500)

    println(
                "████████  ██████  \n" +
                "   ██    ██    ██ \n" +
                "   ██    ██    ██ \n" +
                "   ██    ██    ██ \n" +
                "   ██     ██████  \n" +
                "                  \n" +
                "                  "
    )

    Thread.sleep(500)


    println(
            "$RED   ▄███████▄ ███    █▄  ▀█████████▄     ▄████████  ▄█     ▄██████▄     ▄█    █▄        ███                  \n" +
                "  ███    ███ ███    ███   ███    ███   ███    ███ ███    ███    ███   ███    ███   ▀█████████▄              \n" +
                "  ███    ███ ███    ███   ███    ███   ███    █▀  ███▌   ███    █▀    ███    ███      ▀███▀▀██              \n" +
                "  ███    ███ ███    ███  ▄███▄▄▄██▀   ▄███▄▄▄     ███▌  ▄███         ▄███▄▄▄▄███▄▄     ███   ▀              \n" +
                "▀█████████▀  ███    ███ ▀▀███▀▀▀██▄  ▀▀███▀▀▀     ███▌ ▀▀███ ████▄  ▀▀███▀▀▀▀███▀      ███                  \n" +
                "  ███        ███    ███   ███    ██▄   ███        ███    ███    ███   ███    ███       ███                  \n" +
                "  ███        ███    ███   ███    ███   ███        ███    ███    ███   ███    ███       ███                  \n" +
                " ▄████▀      ████████▀  ▄█████████▀    ███        █▀     ████████▀    ███    █▀       ▄████▀                $RESET\n" +
                "                                                                                                                        \n" +
                "$YELLOW   ▄████████ ████████▄   ▄█    █▄     ▄████████ ███▄▄▄▄       ███     ███    █▄     ▄████████    ▄████████    ▄████████ \n" +
                "  ███    ███ ███   ▀███ ███    ███   ███    ███ ███▀▀▀██▄ ▀█████████▄ ███    ███   ███    ███   ███    ███   ███    ███ \n" +
                "  ███    ███ ███    ███ ███    ███   ███    █▀  ███   ███    ▀███▀▀██ ███    ███   ███    ███   ███    █▀    ███    █▀  \n" +
                "  ███    ███ ███    ███ ███    ███  ▄███▄▄▄     ███   ███     ███   ▀ ███    ███  ▄███▄▄▄▄██▀  ▄███▄▄▄       ███        \n" +
                "▀███████████ ███    ███ ███    ███ ▀▀███▀▀▀     ███   ███     ███     ███    ███ ▀▀███▀▀▀▀▀   ▀▀███▀▀▀     ▀███████████ \n" +
                "  ███    ███ ███    ███ ███    ███   ███    █▄  ███   ███     ███     ███    ███ ▀███████████   ███    █▄           ███ \n" +
                "  ███    ███ ███   ▄███ ███    ███   ███    ███ ███   ███     ███     ███    ███   ███    ███   ███    ███    ▄█    ███ \n" +
                "  ███    █▀  ████████▀   ▀██████▀    ██████████  ▀█   █▀     ▄████▀   ████████▀    ███    ███   ██████████  ▄████████▀  \n" +
                "                                                                                   ███    ███                           $RESET"
    )

    Thread.sleep(4000)
    clearConsole()

    for (i in 1..10) {
        var color = farben[Index]

        clearConsole()
        println(
              "$color██████  ██    ██     ██████  ███████ ████████ ██████  ██ ████████ ████████ ███████ ████████     ██████  ██ ███████     ██████   █████  ██████  \n" +
                    "██   ██ ██    ██     ██   ██ ██         ██    ██   ██ ██    ██       ██    ██         ██        ██   ██ ██ ██          ██   ██ ██   ██ ██   ██ \n" +
                    "██   ██ ██    ██     ██████  █████      ██    ██████  ██    ██       ██    ███████    ██        ██   ██ ██ █████       ██████  ███████ ██████  \n" +
                    "██   ██ ██    ██     ██   ██ ██         ██    ██   ██ ██    ██       ██         ██    ██        ██   ██ ██ ██          ██   ██ ██   ██ ██   ██ \n" +
                    "██████   ██████      ██████  ███████    ██    ██   ██ ██    ██       ██    ███████    ██        ██████  ██ ███████     ██████  ██   ██ ██   ██ $RESET\n" +
                    " "
        )
        Index = (Index + 1) % farben.size
        Thread.sleep(200)
        if (i >= 10)
            break
    }
    println("        \n" +
            "$RED ██▓  $RESET          Hallo Partymate ..*mhm*.. ich meine FIGHTER! \n" +
            "$RED▓██▒  $RESET          Nach einer durchzechten Partynacht mit deinen Freunden seid ihr in diesem einen zwielichtigen Schuppen gelandet, an dem ihr sonst immer vorbeilauft.\n" +
            "$RED▒██▒  $RESET          An dem Außenschild stand schließlich „1 Sieg - eine Flasche UMSONST“ geschrieben… \n" +
            "$RED░██░  $RESET          \n" +
            "$RED░██░  $RESET          ╔═╗┬┌─┐┬ ┬┌┬┐┌─┐┬  ┬ ┬┌┐    ╔═╗┬ ┬┌┐  \n" +
            "$RED░▓    $RESET          ╠╣ ││ ┬├─┤ │ │  │  │ │├┴┐───╠═╝│ │├┴┐ \n" +
            "$RED ▒ ░  $RESET          ╚  ┴└─┘┴ ┴ ┴ └─┘┴─┘└─┘└─┘   ╩  └─┘└─┘ \n" +
            "$RED ▒ ░  $RESET          \n" +
            "$RED ░    $RESET          ...das war das Ladenschild...\n" +
            "                ...welches die Jungs übersehen hatten...\n" +
            "            ")
    abschnitt()
}

fun yourturnVisual(){

    println("${GREEN}██    ██  ██████  ██    ██ ██████      ████████ ██    ██ ██████  ███    ██ ")
    Thread.sleep(100)
    println(" ██  ██  ██    ██ ██    ██ ██   ██        ██    ██    ██ ██   ██ ████   ██ ")
    Thread.sleep(100)
    println("  ████   ██    ██ ██    ██ ██████         ██    ██    ██ ██████  ██ ██  ██ ")
    Thread.sleep(100)
    println("   ██    ██    ██ ██    ██ ██   ██        ██    ██    ██ ██   ██ ██  ██ ██ ")
    Thread.sleep(100)
    println("   ██     ██████   ██████  ██   ██        ██     ██████  ██   ██ ██   ████ ")
    Thread.sleep(100)
    println("                                                                           $RESET")
    Thread.sleep(100)
    println("                                                                           ")

}

fun enemyturnVisual(){

    println("${RED}███████ ███    ██ ███████ ███    ███ ██    ██     ████████ ██    ██ ██████  ███    ██ ")
    Thread.sleep(100)
    println("██      ████   ██ ██      ████  ████  ██  ██         ██    ██    ██ ██   ██ ████   ██ ")
    Thread.sleep(100)
    println("█████   ██ ██  ██ █████   ██ ████ ██   ████          ██    ██    ██ ██████  ██ ██  ██ ")
    Thread.sleep(100)
    println("██      ██  ██ ██ ██      ██  ██  ██    ██           ██    ██    ██ ██   ██ ██  ██ ██ ")
    Thread.sleep(100)
    println("███████ ██   ████ ███████ ██      ██    ██           ██     ██████  ██   ██ ██   ████ ")
    Thread.sleep(100)
    println("                                                                                       $RESET")
    Thread.sleep(100)
    println("                                                                                       ")
    Thread.sleep(100)
    println("                                                                                       ")

}