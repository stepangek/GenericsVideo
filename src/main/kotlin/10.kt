import stubs.Dog

// 10. Star Projection

/*
Использование звездочки вместо типа позволяет подставлять абсолютно любые типы
в качестве параметра типа.
 */

fun printArray(array: Array<*>) {
    array.forEach { println(it) }
}


// Отличие <*> от <Any?>
// показать что если mutableList, то уже и здесь перестает работать
fun acceptAnyList(list: List<Any?>) {}
fun acceptStarList(list: List<*>) {}

fun acceptAnyArray(array: Array<Any?>) {}
fun acceptStarArray(array: Array<*>) {}

//Выведение типа при использовании проекций
interface Group<T : Dog> {
    fun insert(member: T): Unit
    fun fetch(): T
}

fun readIn(group: Group<in Nothing>) {
    // No change - inferred type of `item` is `Any?`
    val item = group.fetch()
}

// Gotta change the type argument here to `Dog`!
fun readOut(group: Group<out Dog>) {
    // Inferred type of `item` is now `Dog`
    val item = group.fetch()
}

// No change to the function signature!
fun readStar(group: Group<*>) {
    // Inferred type of `item` is `Dog`
    val item = group.fetch()
}


fun main() {
    val arrayOfNumbers = arrayOf(1,2,3)
    printArray(arrayOfNumbers)

    val arrayOfStrings = arrayOf("Hello", "Kotlin", "World")
    printArray(arrayOfNumbers)
    ////////////////////////////////

    val listOfStrings = listOf("Hello", "Kotlin", "World")
    acceptAnyList(listOfStrings)
    acceptStarList(listOfStrings)

    // при попытке передать лист строк в качестве входного(in) параметра, компилятор выдает ошибку
    // так как формально массив не опеределен с проекциями типов и его параметр опеределен как Т

    /*acceptAnyArray(arrayOfStrings)*/  // Compiler error here, добавление out проекции так же убирает ошибку
    acceptStarArray(arrayOfStrings)

    ////////////////////////////////
}

//TODO: _ , reifed type parameters
