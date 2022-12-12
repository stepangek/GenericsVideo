package stubs.validator

data class ValidationResult(
    var state: ValidationState = ValidationState.UNDEFINED,
    var message: String = "",
    val source: String = "",
    val results: MutableMap<String, String> = mutableMapOf(),
    val subResults: MutableList<ValidationResult> = mutableListOf(),
) {

    fun addSubResult(subResult: ValidationResult) {
        subResults.add(subResult)
    }

    fun addSubResults(subResult: Collection<ValidationResult>) {
        subResults.addAll(subResult)
    }

    fun normalize() {
        state = (subResults.map { it.state } + state).maxOf { it }
        subResults.removeIf { it.state == ValidationState.UNDEFINED }
    }

    /**
     * [ValidationState] не OK
     */
    fun isNotOk() = state == ValidationState.ERROR

    companion object {
        val EMPTY = ValidationResult()

        /**
         * [ValidationResult] со статусом [ValidationState.OK]
         */
        val OK = ValidationResult(state = ValidationState.OK)
    }
}

enum class ValidationState {
    UNDEFINED,
    OK,
    HINT,
    WARN,
    ERROR
}
