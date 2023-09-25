package PubFightAdventures

class Sideboss(name: String, hp: Int): Enemy(name, hp) {


    /**
     * Der Couseng vom Kneipenboss ist nicht die hellste Birne, aber seinen besoffenen Körper zu schwingen, klappt noch... irgendwie...
     */
    var tritt = Skill("Tritt", 15..25, 10, false)
    var schlag = Skill("Schlag", 15..25, 10, false)
    var kopfnuss = Skill("Kopf", 15..25, 10, false)
    var ellenbogen = Skill("Ellenbogen", 15..25, 10, false)

    var sidebossSkills = listOf(
        tritt,
        schlag,
        kopfnuss,
        ellenbogen
    )
}