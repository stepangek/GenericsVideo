// 8. in
import stubs.IWithUid
import stubs.ServiceResult

class ParameterizedConsumer<in T>{
    fun toString(value: T): String {
        return value.toString()
    }

    /*fun basicValue(value: T): T {
        return value
    }*/
}

// использование in обязательно, так как таким образом компилятор уведомляется,
// что в качестве целевого массива может быть не только Array<Int>, но и любой другой Array<?>,
// который может принимать в себя Int(является родителем для Int)

fun fill(dest: Array<in Int>,value: Int) {
    val objects: Array<Any?> = arrayOfNulls(1)
    fill(objects, 1)
}

fun main(){
    val parameterizedConsumer = ParameterizedConsumer<Number>()
    val ref: ParameterizedConsumer<Double> = parameterizedConsumer
}
