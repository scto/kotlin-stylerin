import kotlinx.coroutines.*

suspend fun runWithSuspension(block:   suspend   () -> Unit) {
    println("Before calling the suspend block")
    block()
    println("After calling the suspend block")
}

fun main() = runBlocking {
    runWithSuspension {
        delay(1000)
        println("Hello from suspended function!")
    }
}
