@Deprecated ( "This class might be replaced with a more specific animal hierarchy in the future.")
class Animal {

        @Transient
    val name: String = "Generic Animal"

    @JvmOverloads
        @Synchronized
    fun move( @Suppress ("UNUSED_PARAMETER") speed: Int = 1) {
        println("moving...")
    }

}
