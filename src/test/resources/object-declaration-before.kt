interface Animal {

    fun move()

}

object Cat   :   Animal   {
    override fun move() {
        println("jump!")
    }
}
