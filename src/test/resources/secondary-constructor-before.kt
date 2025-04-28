class Person {

    var name: String

    var age: Int

    constructor  (  name  :   String )   {
this.name = name
                this.age = 0}

    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }

    fun introduce() {
        println("Hi, I'm $name and I'm $age years old.")
    }

}

fun main() {
    val person1 = Person("Alice")
    val person2 = Person("Bob", 25)
    person1.introduce()
    person2.introduce()
}
