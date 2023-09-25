package PubFightAdventures

class Trickster(name: String, hp: Int) : Hero(name, hp) {


    //TODO: SKILLS

    /**
     * Die Fähigkeit Fist of Zen benötigt eine Ladephase von einer Runde.
     * Dies blockiert zwar weitere Aktionen in einer Runde, fügt jedoch erheblichen Schaden zu.
     */
    var fingerNoJutsu = Skill("Finger no Jutsu", 40..60, 2, false)


    /**
     * Die Fähigkeit Pocket Sand erlaubt es dem Spieler den Gegner für eine Runde erblinden zu lassen.
     * Die Chance, dass er dadurch nichts trifft, ist sehr hoch!
     */
    var pocketSand = Skill("Pocket Sand", 0..0, 5, false)


    /**
     * Der heimtückische Schlag vom Trickster sieht zwar oberflächlich so aus, als würde er nicht treffen,
     * doch so wie aus minus und minus plus ergibt, trifft der Double-Fake Hit allemal.
     */
    var doubleFakeHit = Skill("Double-Fake Hit", 20..35, 15, false)


    /**
     * Mit der Fähigkeit Waffe Geben sucht der Trickster für eine Runde lang eine beliebige Waffe
     * mit unterschiedlichen Werten. Wenn er sie endlich gefunden hat, darf er sich aussuchen,
     * welchem Charakter er sie geben möchte.
     */
    var waffeGeben = Skill("Waffe Geben", 0..0, 2, false)

    var tricksterSkills = listOf(
        fingerNoJutsu,
        pocketSand,
        doubleFakeHit,
        waffeGeben
    )
}