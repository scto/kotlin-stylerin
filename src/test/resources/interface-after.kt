interface Animal {

    fun move()

}

class Bird : Animal {

    override fun move() {
        println("Bird flying...")
    }

}
