open class Animal {

    open fun move() {
        println("Animal moving...")
    }

}

class Bird : Animal() {

    override fun move() {
        println("Bird flying...")
    }

}
