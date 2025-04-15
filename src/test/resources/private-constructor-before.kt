class Animal  private  constructor(  )  {
    fun move() {
        println("moving...")
    }
    companion object {
        val instance :  Animal  by  lazy{Animal()}
    }
}

fun main() {
    Animal.instance.move()
}
