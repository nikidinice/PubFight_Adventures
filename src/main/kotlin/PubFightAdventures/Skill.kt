package PubFightAdventures

class Skill(
    private val name: String,
    var damageRange: IntRange,
    var uses: Int,
    var charge: Boolean
) {

    fun use(enemy: Enemy) {                                                         //Ähnlich dem AP-System aus Pokemon. Jeder Angriff kann nur begrenzt oft benutzt werden. Besseres Balancing für starke Angriffe
        if (this.uses > 0) {
            enemy.hp -= criticalHit(damageRange.random())
            uses--
            println("$name trifft $enemy. Diese Fähigkeit ist noch $uses mal nutzbar.")
        } else {
            println("$name kann nicht mehr benutzt werden.")
        }
    }
}