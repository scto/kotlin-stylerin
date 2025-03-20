fun riskyFunction() {
    throw IllegalArgumentException("Something went wrong!")
}

fun main() {
    try{
        println("Attempting to execute riskyFunction...")
         riskyFunction()

    }catch  (e: IllegalArgumentException){
println("Caught an exception: ${e.message}")
    }  finally  {


            println("This will always execute, regardless of an exception.")
    }
}