package PubFightAdventures

class Trickster(name: String, hp: Double, damage: Double) : Hero(name, hp, 1.0) {


    //TODO: SKILLS

    /**
     * Die Fähigkeit Fist of Zen benötigt eine Ladephase von einer Runde.
     * Dies blockiert zwar weitere Aktionen in einer Runde, fügt jedoch erheblichen Schaden zu.
     */
    var fingerNoJutsu = Skill("Finger no Jutsu", 50.0, 2, true, false)


    /**
     * Die Fähigkeit Pocket Sand erlaubt es dem Spieler den Gegner für eine Runde erblinden zu lassen.
     * Die Chance, dass er dadurch nichts trifft, ist sehr hoch!
     */
    var pocketSand = Skill("Pocket Sand", 0.0, 5, false, false)


    /**
     * Der heimtückische Schlag vom Trickster sieht zwar oberflächlich so aus, als würde er nicht treffen,
     * doch so wie aus minus und minus plus wird, so sitzt der Schlag wie bei einem gekonnten Katanahieb.
     */
    var doubleFakeHit = Skill("Double-Fake Hit", 2.0, 15, false, false)


    /**
     * Mit der Fähigkeit Waffe Geben sucht der Trickster für eine Runde lang eine beliebige Waffe
     * mit unterschiedlichen Werten. Wenn er sie endlich gefunden hat, darf er sich aussuchen,
     * welchem Charakter er sie geben möchte.
     */
    var waffeGeben = Skill("Waffe Geben", 0.0, 2, false, false)

    var tricksterSkills = listOf(
        fingerNoJutsu,
        pocketSand,
        doubleFakeHit,
        waffeGeben
    )
}