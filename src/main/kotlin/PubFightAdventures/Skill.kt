package PubFightAdventures

class Skill(
    val name: String,
    var damage: Double,
    var uses: Int,
    var charge: Boolean,
    var charging: Boolean
) {
    override fun toString(): String {
        return name
    }

    open val useSkill = { skill: Skill, enemy: Enemy ->
        var damage = criticalHit(damage)
        if (skill.charge) {
            skill.charge = false
            println("${skill.name} wird aufgeladen.")
        } else if (skill.uses > 0) {
            enemy.hp -= damage.toInt()
            uses--
            println("$name trifft $enemy. Diese Fähigkeit ist noch $uses mal nutzbar.")
        } else {
            println("$name kann nicht mehr benutzt werden.")
        }
    }
}