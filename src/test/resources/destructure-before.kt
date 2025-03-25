class User(val id: Int, val username: String) {

    operator fun component1() = this.id

    operator fun component2() = this.username

}

fun main() {
    val (id,username)= User(0, "Rin")
    println(id)
    println(username)
}
