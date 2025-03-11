class User (val name:String) {
    constructor ():this("Rin")
    fun greet() {
        println("This is " + this.name)
    }
}