// 10. Star Projection

fun printArray(array: Array<*>) {
    array.forEach { println(it) }
}

fun main() {
    val arrayOfNumbers = arrayOf(1,2,3)
    printArray(arrayOfNumbers)

    val arrayOfStrings = arrayOf("1","2","3")
    printArray(arrayOfNumbers)
}