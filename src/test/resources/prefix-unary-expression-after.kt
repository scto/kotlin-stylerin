class Num {

    companion object {

        fun isEven(number: Int): Boolean {
            return number % 2 == 0
        }

    }

}

fun main() {
    val result = !Num.isEven(0)
    println(result)
}
