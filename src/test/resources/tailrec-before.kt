tailrec fun factorial(n:Int,accumulator  :  Int=  1):  Int  {
    return if(n<=1)accumulator else factorial(n-1,accumulator*n)
}

fun main() {
    val result = factorial(5)
    println(result)
}
