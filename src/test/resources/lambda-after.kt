fun main() {
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus
    val a = stringPlus.invoke("<-", "->")
    println(a)
    val b = stringPlus("Hello, ", "world!")
    println(b)
    val c = intPlus.invoke(1, 1)
    println(c)
    val d = intPlus(1, 2)
    println(d)
    val e = 2.intPlus(3)
    println(e)
}
