// 9. where

// Функция с множественными верхними границами
fun <T> sort(xs: List<T>) where T : CharSequence, T : Comparable<T> {

}

// Класс с множественными верхними границами
class StringCollection<T>(xs: List<T>) where T: CharSequence, T: Comparable<T> {

}

fun main() {
    val collection = StringCollection<String>(listOf("string1", "string2"))
}