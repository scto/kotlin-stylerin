import kotlin.random.Random

class A {

    fun a(action: (String) -> Unit) {
        action("Hello from A")
    }

}

class B {

    fun b(msg: String) {
        println("B received: $msg")
    }

}

fun main() {
    when (val num = Random.nextInt(0, 2)) {
        0 -> println(num)
        else -> println(num)
    }
    val message = ("Yoi") + " Yoi"
    println(message)
    val obj1 = A()
    val obj2 = B()
    obj1.a(
        {
            obj2.b(it)
        }
    )
}
