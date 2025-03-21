fun main() {
    val fruit: Any = "apple"
    if (fruit is String) {
        println("fruit is a string.")
    }
    val num: Any = 3
    val temp = num as Int
    println(temp + 2)
    if (num !is Boolean) {
        println("num is not a boolean")
    }
    val animal: Any = "cat"
    val cat: String? = animal as? String
    println(cat)
}
