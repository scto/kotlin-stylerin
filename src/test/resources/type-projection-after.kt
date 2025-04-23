// Define a generic Box class
class Box<T>(private var value: T) {

    fun get(): T = value

    fun set(newValue: T) {
        value = newValue
    }

    override fun toString(): String = "Box($value)"

}

// Covariant (out) projection - only allows reading
fun printBox(box: Box<out Number>) {
    val number: Number = box.get()
    println("Read from out-projected box: $number")
}

// Contravariant (in) projection - only allows writing
fun fillBox(box: Box<in Int>) {
    box.set(123)
    println("Wrote to in-projected box")
}

// Star projection - safe read-only with `Any?` type
fun inspectBox(box: Box<*>) {
    val value = box.get()
    println("Star-projected box contains: $value")
}

fun main() {
    val intBox = Box(10)
    val doubleBox = Box(3.14)
    val stringBox = Box("hello")
    // Demonstrate 'out' projection
    printBox(intBox)
    printBox(doubleBox)
    // Demonstrate 'in' projection
    fillBox(intBox)
    // Demonstrate '*' (star) projection
    inspectBox(intBox)
    inspectBox(stringBox)
}
