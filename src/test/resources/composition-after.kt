class RussianDoll(private val name: String, private val child: RussianDoll? = null) {

    fun child(): RussianDoll? {
        return child
    }

    fun unwrap() {
        println(name)
        child?.unwrap()
    }

}

fun main() {
    val doll = RussianDoll(
        "Rin",
        RussianDoll(
            "Revomin",
            RussianDoll("Ian")
        )
    )
    doll.unwrap()
}
