package PubFightAdventures

class Skill(
    private val name: String,
    var damageRange: IntRange,
    var uses: Int,
    var charge: Boolean
) {

    open fun useSkill(
        skill: Skill,
        enemy: Enemy
    ) {                                                         //Ähnlich dem AP-System aus Pokemon. Jeder Angriff kann nur begrenzt oft benutzt werden. Besseres Balancing für starke Angriffe
        var damage = criticalHit(damageRange.random())
        if (skill.charge) { // Der Skill muss aufgeladen werden
            skill.charge = false // Der Skill wird aufgeladen
            println("${skill.name} wird aufgeladen.")
        } else if (skill.uses > 0) {
            enemy.hp -= damage
            uses--
            println("$name trifft $enemy. Diese Fähigkeit ist noch $uses mal nutzbar.")
        } else {
            println("$name kann nicht mehr benutzt werden.")
        }
    }
}