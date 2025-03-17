class Car {

    companion object Engine {

        fun condition(): Int {
            return 3
        }

    }

}

fun main() {
    val condition = Car.Engine.condition()
    println(condition)
}
