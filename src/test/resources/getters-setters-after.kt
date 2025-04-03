class Animal {

    var name: String = ""
        @Deprecated("Use a different property")
        get() = field
        @Deprecated("Use a different property")
        set(value) {
            field = value
        }

    var age: Int = 0
        get() = field
        set(value) {
            field = value
        }

    fun move() {
        println("Moving...")
    }

}

fun main() {
    val animal = Animal()
    animal.name = "Elephant"
    animal.age = 10
    println("Name: ${animal.name}, Age: ${animal.age}")
    animal.move()
}
