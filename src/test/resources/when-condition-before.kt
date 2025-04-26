sealed class Status {

    object Success : Status()

    object Failure : Status()

    object Malformed : Status()

    object Unknown : Status()

}

fun handleStatus(status: Status) {
    when (status) {
        is   Status.Failure  ,   Status.Malformed   ->    {println("Something went wrong!")}
        is Status.Success -> {
            println("Everything is fine!")
        }
        else -> {
            println("Status is unknown.")
        }
    }
}

fun main() {
    handleStatus(Status.Success)
    handleStatus(Status.Failure)
    handleStatus(Status.Malformed)
    handleStatus(Status.Unknown)
}
