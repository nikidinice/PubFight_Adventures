package PubFightAdventures

class Fighter(
    name: String,
    hp: Int
) :
    Hero(name, hp) {


    //TODO: SKILLS

    /**
     * Die Fähigkeit Fist of Zen benötigt eine Ladephase von einer Runde.
     * Dies blockiert zwar weitere Aktionen in einer Runde, fügt jedoch erheblichen Schaden zu
     */
    var fistOfZen = Skill("Fist of Zen", 40..60, 2, false)          //ab 0.5 Fähigkeiten als Klassen


    /**
     * Die Fähigkeit Bronzene Kniescheibe ermöglicht es dem Fighter seine Kniescheibe als Geschoss zu verwenden
     */

    var bronzeneKniescheibe = Skill("Bronzene Kniescheibe", 30..40, 5, false)


    /**
     * Die Fähigkeit Tokat verteilt eine feurige Schelle ins Gesicht des Gegners
     */
    var tokat = Skill("Tokat", 15..30, 15, false)


    /**
     * Setzt der Fighter Booze ein, greift der Held zur nächstgelegenen Flasche und trinkt sie aus.
     * Dadurch erhält er für 3 Runden einen HP-Boost von 10% und einen Schadens-Boost von 25%.
     */
    var booze = Skill("Booze", 0..0, 15, false)


    var fighterSkills = listOf(
        fistOfZen,
        bronzeneKniescheibe,
        tokat,
        booze)
}