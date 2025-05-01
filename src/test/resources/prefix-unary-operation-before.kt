class Outer {

    val outerName = "Outer"

    inner class Inner {

        fun printNames() {
            val runnable = Runnable {
                println(  this  ::  class  .  simpleName  )
                println(  this@Inner  ::  class  .  simpleName  )
                println(  this@Outer  ::  class  .  simpleName  )
            }
            runnable.run()
        }

    }

}

fun main() {
    Outer().Inner().printNames()
}
