package stubs.validator

class DomainValidationContext private constructor(
    override val rowObject: JsonObject = JsonObject(),
    override var result: ValidationResult = ValidationResult(state = ValidationState.OK),
) : IContext<CentralExtendedDomain> {
    override val entity: CentralExtendedDomain = CentralExtendedDomain()

}