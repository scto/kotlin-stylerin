open class Animal {

    open fun move() {
        println("Animal moving...")
    }

}

class Bird : Animal() {

    override fun move() {
        super.move()
        println("Bird flying...")
    }

}
