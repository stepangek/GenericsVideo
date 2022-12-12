package stubs

interface IWithUidNullable {
    /**
     * Уникальный идентификатор
     */
    val uid: String?
}

interface IWithUid : IWithUidNullable {
    override val uid: String
}