import stubs.Account

// 2. Класс с дженериком
class Box<T>(var t: T) {
    var value = t
}




// Так же generic-параметры позволяют выразить некоторые конструкции,
// Которые невозможно выразить без них. Функции x являются абсолютно идентичными
// т.к у нас нет необходимости выражать, что какие-либо параметры или возвращаемое значение должно быть одного типа
fun <T:Any> x1 (t: T) {}
fun x(t: Any) {}

fun <T:Any> x(t1: T, t2: T) {} // явная корреляция, что параметры t1 и t2 должны быть одонго типа
fun <T: Any> x2(t1: T) : T { return t1 } // аналогично, только что тип параметра должен быть такой же, как и возвращаемое значение

/* Работа с nullable-типами*/

/* В случае когда используется ? после Т имеется возможность использовать null в качестве возвращаемого значения. */
/* Тип неявно ограничен вершиной иерархии типов Any? */
class X<T>() { fun y(): T? { return null } }

/* Тип явно ограничен Any? */
class X2<T: Any?>() { fun y(param: T) : T? { return null } }

/* Новый синатаксис введный в 1.7.0 позволяет определить, что один из параметров должен быть строго не null  */
fun <T> elvisLike(x: T, y: T & Any): T & Any = x ?: y

fun main() {
    /*val badBox = Box() // Not enough information to infer type variable T*/

    val okBox = Box<String>("Великолепный Box со строкой")

    val okBox2 = Box<Int>(2)

    val okBox3 = Box(Account("USD", 300)) // type inference сработал и вывел тип на основе переданного значения конструктора

    // OK
    elvisLike<String>("", "").length
    // Error: 'null' cannot be a value of a non-null type
    /*elvisLike<String>("", null).length*/

}