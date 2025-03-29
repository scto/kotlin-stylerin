fun < T >singletonList(item  :T):List< T>{
    return listOf(item)
}

fun main() {
    val list = singletonList<String>("apple")
    println(list)
}
