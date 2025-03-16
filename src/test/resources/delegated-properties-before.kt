import kotlin.reflect.KProperty
class LoggerDelegate<T>(private var value: T){
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T{
        println("${property.name} accessed! Current value: $value")
        return value
    }
    operator fun setValue(thisRef:Any?,property:KProperty<*>, newValue: T){
        println("${property.name} changed! New value: $newValue")
        value = newValue
    }
}
class Example {
    var name:String by LoggerDelegate("Default")
}
fun main() {
    val example = Example()
    println(example.name)
    example.name = "Kotlin"
}