fun main() {
    val fruit = "apple"
    val animal = "cat"
    val yoi = """
    "fruit": "$fruit",
    "animal": "${animal.uppercase()}"
    """
    println(yoi)
}
