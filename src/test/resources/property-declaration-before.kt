class Cat {}

val Cat.name: String
    get() = "tofu"

fun main() {
    val cat = Cat()
    println(cat.name)
}
