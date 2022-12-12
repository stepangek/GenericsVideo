import stubs.*
import stubs.validator.*

//5. Использование нескольких generic-параметров

class Account<T, S>(private val id: T, private val sum: S)

fun main() {
    val acc = Account<String, Double>("354", 5000.87)
}


abstract class ValidatorService<E : Any, C : IContext<E>>(
    override val validators: Set<IValidatorRule<E, C>>
) : IValidatorService<E, C> {
    override fun validate(context: C): ValidationResult {
        validators
            .groupBy { it.phase }
            .toSortedMap()
            .forEach { (_, rules) ->
                if (!context.hasResults()) {
                    rules.forEach { if (it.match(context)) it.exec(context) }
                }
            }

        return context.result.also { it.normalize() }
    }
}

class DomainValidatorService(validators: Set<IValidatorRule<CentralExtendedDomain, DomainValidationContext>>) :
    ValidatorService<CentralExtendedDomain, DomainValidationContext>(
        validators = validators
    ) { }
