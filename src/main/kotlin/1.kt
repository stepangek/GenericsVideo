import stubs.Account

// 1. Класс с дженериком
class Box<T>(t: T) {
    var value = t
}

fun main() {
    /*val badBox = Box() // Not enough information to infer type variable T*/

    val okBox = Box<String>("Великолепный Box со строкой")

    val okBox2 = Box<Int>(2)

    val okBox3 = Box(Account("USD", 300)) // type inference сработал и вывел тип на основе переданного значения конструктора
}