interface Base {

    fun println()

}

class BaseImpl(val x: Int) : Base {

    override fun println() {
        println(x)
    }

}

class Derived(b: Base) : Base by b

fun main() {
    val base = BaseImpl(3)
    Derived(base).println()
}
