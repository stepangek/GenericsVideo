// 6. Type Erasure

open class Parent<T> {
    open fun f(x: T) { println("parent"); }
}

class Child : Parent<Int>() {
    override fun f(x: Int) { println("child") }
}

fun main() {
    val parent = Parent<String>()
    val child = Child()

    println(parent.javaClass.declaredMethods[0].parameterTypes[0])
    println(child.javaClass.declaredMethods[0].parameterTypes[0])

    val pc = parent.javaClass
    val cc = child.javaClass

}
