package PubFightAdventures

class Skill(
    val name: String,
    var damage: Double,
    var uses: Int,
    var charge: Boolean,
    var charging: Boolean,
    var effect: Boolean,
    var effectRounds: Int
) {
    override fun toString(): String {
        return name
    }

}