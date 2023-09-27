package PubFightAdventures

class Boss(name: String, hp: Double): Enemy(name, hp) {
    override fun toString(): String {
        return name
    }


    /**
     * Mit dieser Fähigkeit schmeißt der Kneipenboss Geld auf die Gegner, welches alle anderen Besucher des Pubs haben wollen.
     * Bei ihrem gierigen Versuch etwas zu fangen rangeln und schlagen sich die Besucher und jeder Held kriegt dabei etwas ab.
     * !! Flächenschaden !!
     */
    var geld = Skill("Geld", 25.0, 5, false, false)


    /**
     * Der Boss möchte dich wissen lassen, wer hier der Chef ist und gibt dir einen saftigen Punch ins Gesicht
     */
    var kissRing = Skill("Küss den Ring", 25.0, 5, false,false)


    /**
     * Mit dieser Fähigkeit kann der Kneipenboss seinen Couseng ins Kampfgeschehen bringen, welcher ihn im Kampf bis zum bitteren Ende unterstützt
     */
    var couseng = Skill("Couseng", 0.0, 1, false,false)


    /**
     * Mit der Fähigkeit Ehrenlos bietet der Kneipenboss einem Helden einen kostenlosen Shot an, welcher der Säufer natürlich nicht abschlagen kann.
     * Statt feinsten Spirituosen trintkt der Held pures Gift & leidet so lange, bis seine Lebenspunkte weniger als 20% betragen.
     */
    var ehrenlos = Skill("Ehrenlos", 0.0, 1, false,false)


    /**
     * Mit dieser Fähigkeit sucht sich der Kneipenboss einen Stuhl und zieht ihn sofort einem der Helden über den Schädel
     */
    var stuhl = Skill("Stuhl", 50.0, 5, false, false)


    /**
     * Mit dieser Fähigkeit kann sich der Kneipenboss wie eine Pussy verstecken und erleidet 1 Runde keinen Schaden
     */
    var block = Skill("Block", 0.0, 15, false,false)


    var bossSkills = listOf(
        geld,
        kissRing,
        couseng,
        ehrenlos,
        stuhl,
        block
    )

//    fun executeSkill(skill: Skill, target: Enemy) {
//
//        if (skill.uses > 0) {
//            val damage = criticalHit(skill.damageRange.random())
//            target.hp -= damage
//            skill.uses--
//            println("${this.name} ${ skill.name } und fügt ${ target.name } $damage Schaden zu.")
//        } else {
//            println("")
//        }
    }