// 7. out
import stubs.IWithUid
import stubs.ServiceResult

class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return value
    }

    /*fun toString(value: T) : String {
        return value.toString()
    }*/
}


// использование out обязательно, т.к. это позволяет компилятору использовать типы-наследники ниже по иерархии,
// а не только строго тот тип, который передан в качестве Т
fun copy(from: Array<out Any>, to: Array<Any?>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main(){
    val parameterizedProducer = ParameterizedProducer("string")
    val ref: ParameterizedProducer<Any> = parameterizedProducer

    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any: Array<Any?> = arrayOfNulls(3)

    copy(ints, any)

    assert(any[0] == 1)
    assert(any[1] == 2)
    assert(any[2] == 3)
}
