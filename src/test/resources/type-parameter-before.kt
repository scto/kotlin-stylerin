inline fun   <  reified   T  >   isOfType(value: Any): Boolean {
    return value is T
}

fun main() {
    val result = isOfType<String>("hello")
    val result2 = isOfType<Int>("hello")
    println(result)
    println(result2)
}
