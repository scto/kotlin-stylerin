typealias NodeSet = Set<String>

typealias FileTable<K> = MutableMap<K, MutableList<String>>

fun main() {
    val nodeSet: NodeSet = setOf("apple")
    println(nodeSet)
}
