package PubFightAdventures

import kotlin.random.Random
class Skill(val skill: String, val damageRange: IntRange)

fun main(){

//Funktion die in einem Zahlenbereich eine zufällige Zahl wiedergibt
fun randomSkillSchaden(skill: Skill): Int {
    return skill.damageRange.random()
}

// Eine Liste von Skills mit ihren jeweiligen Schadensbereichen
val skills = listOf(
    Skill("Heldenpunch", 300..400),
    Skill("Boss Schelle", 120..150)
)

println(randomSkillSchaden(skills[0]))
}