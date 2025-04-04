interface Animal{
    fun move()
}
class Bird:Animal{
    override fun move(){println("Bird flying...")}
}
class Cat  :  Animal  {
    override fun move() {
        println("Cat running...")
    }
    companion object{
    const val ID=0
    }
}