package PubFightAdventures

class Sideboss(name: String, hp: Double): Enemy(name, hp) {


    /**
     * Der Couseng vom Kneipenboss ist nicht die hellste Birne, aber seinen besoffenen Körper zu schwingen, klappt noch... irgendwie...
     */
    var tritt = Skill("Tritt", 20.0, 10, false, false)
    var schlag = Skill("Schlag", 20.0, 10, false, false)
    var kopfnuss = Skill("Kopf", 20.0, 10, false, false)
    var ellenbogen = Skill("Ellenbogen", 20.0, 10, false, false)

    var sidebossSkills = listOf(
        tritt,
        schlag,
        kopfnuss,
        ellenbogen
    )
}