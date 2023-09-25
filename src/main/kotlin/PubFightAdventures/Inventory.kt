package PubFightAdventures

class Inventory(name: String, hp: Int): Hero(name, hp) {

    /**
     * Ein Heiltrank, der einen Helden um 50% seiner maximalen Lebenspunkte heilt
     */
    var healthPotion = Skill("Heiltrank", 50..50, 3, false)


    /**
     * Ein Trank, der einem Helden die Schadenswerte dauerhaft um 10% erhöht
     */
    var damagePotion = Skill("Schaden+", 10..10, 1, false)
}