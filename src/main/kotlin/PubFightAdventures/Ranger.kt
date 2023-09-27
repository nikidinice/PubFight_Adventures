package PubFightAdventures

class Ranger(name: String, hp: Double, damage: Double) : Hero(name, hp, 1.0) {


    //TODO: SKILLS

    /**
     * Mit Flaschenwurf wirft der Ranger mit einer Flasche nach einem Gegner. Sollte die Flasche dabei zerspringen,
     * so fallen Scherben auf den Boden der gegnerischen Mannschaft, die für 5 Runden lang Bleeding verursachen.
     */
    var flaschenwurf = Skill("Flaschenwurf", 35.0, 5, false, false)


    /**
     * Mit der Bierfontäne kann der Ranger aus sicherer Entfernung die gegnerische Mannschaft flächendeckend erblinden lassen.
     */
    var bierfontaene = Skill("Bierfontäne", 0.0, 5, false, false)


    /**
     * Wenn der Ranger seine Pom Poms rausholt und erst anfängt seine Kameraden zu motivieren,
     * ist kein Glas mehr sicher! Die Werte des gesamten Teams steigen für 3 Runden um 30%.
     */
    var anfeuern = Skill("Anfeuern", 0.0, 3, false, false)


    /**
     * Der Ranger ist ein geübter Dartspieler. Mit feinster Präzision trifft er immer ins Schwarze!
     */
    var dartwurf = Skill("Dartwurf", 20.0, 15, false, false)

    var rangerSkills = listOf(
        flaschenwurf,
        bierfontaene,
        anfeuern,
        dartwurf
    )

}