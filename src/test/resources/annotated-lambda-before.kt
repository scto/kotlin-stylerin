interface Callback {

    fun onComplete(result: String)

}

class Task(private val callback: Callback) {

    fun execute() {
        callback.onComplete("complete")
    }

}

fun main() {
    val task = Task(object : Callback {
        override   fun   onComplete  (  result  :   String  )   {
        println("Result: $result")
            }
    })
    task.execute()
}
