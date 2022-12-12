package stubs.validator


interface IContext<E : Any> {
    val rowObject: JsonObject

    val entity: E

    var result: ValidationResult
}

fun <E : Any> IContext<E>.hasResults(): Boolean {
    return this.result.subResults.isNotEmpty()
}

interface IValidatorService<E : Any, C : IContext<E>> {
    val validators: Set<IValidatorRule<E, C>>

    fun validate(context: C): ValidationResult
}

data class JsonObject(val data: String = "")

interface IValidatorRule<E : Any, C : IContext<E>> {
    val phase: ValidationPhase
    fun exec(context: C)

    fun match(context: C): Boolean
}

enum class ValidationPhase {
    FORMAT_CONTROL,
    LOGIC_CONTROL
}