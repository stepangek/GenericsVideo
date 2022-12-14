/* 1. Обобщенные функции(generic-функции)
Дженерики или обобщения - это синтаксис в Java/Kotlin,
позволяющий при определении классов/интерфейсов/функций уйти от однозначного
определения типа и передавать его в качестве параметра.
*/

class Printer {
    fun <T> print(items: List<T>) {
        for (t in items) {
            println(t)
        }
    }
}

fun <T: Number> fraction(n: T, f: Int): Double {
    return n.toDouble() / f
}


fun main() {
    val printer = Printer()
    printer.print<Int>(arrayListOf(1,2,3,4,5))
    printer.print<String>(arrayListOf("Tom", "Alice", "Sam", "Kate", "Bob", "Helen"))

    val a: Int = 10
    val b: Double = 1.5
    println(fraction(a, 5)) // 2.0
    println(fraction(b, 3)) // 0.5
}


/*
Дженерики появились в Java только спустя 8 лет после начала ее существования в Java 5.
Исходно в JVM была возможность переопределить сигнатуру метода у наследника таким образом,
чтобы он был ковариантен(был в иерархии классов ниже исходного типа).
Можно этот случай реализовать и на kotlin, что по факту будет аналогом реализации out T
 */

open class A { open fun x() : Any  = "x"  }
// можно перекрыть так
open class Astr : A() { override fun x(): String = "hello" }
open class Aint : A() { override fun x(): Int = 1 }

// то есть чтобы так перегружать не надо писать `class A<out T> { open fun x() : T = TODO() }

// при этом обратная перегрузка(string -> any) не сработает, нарушается принцип подстановки Лисков из SOLID
/*open class B { open fun x() : String  = "x"  }*/
/*open class Bany : B() { override fun x(): Any = "hello" }*/



// аналогичный пример контрвариативности типов(аналог in в kotlin) без использования дженерик-параметра
// невозможен. то есть исходно в java через переопределение невозможно выразить что
// если "все строки - обьекты", то "всякий метод, оперирующий произвольными обьектами может выполнить операцию над строкой",
// или, если совсем условно, компилятор не может сам при переопределнии догадаться
// что пользователь хотел переопределить x(s: String), только скастить s:String в s:Any

// для функций с дженериком же для этого используются особые механизмы компилятора
/*
open class C { open fun x(s: String){}  }
open class Cany : C() { override fun x(s: Any){} }
*/


