import java.util.ArrayList

// 2. Функция с дженериком

class Printer {
    fun <T> print(items: ArrayList<T>) {
        for (t in items) {
            println(t)
        }
    }
}

fun main() {
    val printer = Printer()
    printer.print<Int>(arrayListOf(1,2,3,4,5))
    printer.print<String>(arrayListOf("Tom", "Alice", "Sam", "Kate", "Bob", "Helen"))
}
