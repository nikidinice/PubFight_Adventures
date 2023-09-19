package PubFightAdventures

class Fighter(name: String, hp: Int) : Hero(name, hp) {

    /**
     * Die Fähigkeit Fist of Zen benötigt eine Ladephase von einer Runde.
     * Dies blockiert zwar weitere Aktionen in einer Runde, fügt jedoch erheblichen Schaden zu
     */
    fun fistOfZen(name: String, damage: Int, usable: Int = 1) {
        var name = "Fist of Zen"
        var damage = 69
    }

    /**
     * Die Fähigkeit Bronzene Kniescheibe schießt eine metallische Kniescheibe aus dem Knie auf den Gegner
     */
    fun bronzeneKniescheibe(name: String, damage: Int, usable: Int = 5) {
        var name = "Bronzene Kniescheibe"
        var damage = 30
    }

    /**
     * Die Fähigkeit Tokat verteilt eine feurige Schelle ins Gesicht des Gegners
     */
    fun tokat(name: String, damage: Int, usable: Int = 10) {
        var name = "Tokat"
        var damage = 20
    }

    /**
     * Die Fähigkeit Booze greift der Held zur nächstgelegenen Flasche und trinkt sie aus.
     * Dadurch erhält er für 2 Runden einen HP-Boost von 10% und einen Schadens-Boost von 25%.
     */
    fun booze(name: String, usable: Int = 1){
        var name = "Tokat"
    }
}