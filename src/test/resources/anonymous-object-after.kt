interface Animal {

    fun move()

}

fun main() {
    val bird = object : Animal {

        override fun move() {
            println("flying...")
        }

    }
    bird.move()
}
