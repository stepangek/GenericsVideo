// 4. Ограничение по верней границе иерархии
import stubs.IWithUid
import stubs.ServiceResult

interface IEntityRepositoryWithRestrict<T : IWithUid> {
    fun saveUnsafe(entity: T): ServiceResult
}

interface IWithUidNullable {
    val uid: String?
}

interface IWithUid : IWithUidNullable {
    override val uid: String
}

data class EmailEntityUid(override val uid: String) : IWithUid

class EmailRepositoryWithRestrict : IEntityRepositoryWithRestrict<EmailEntityUid> {
    override fun saveUnsafe(entity: EmailEntityUid): ServiceResult = ServiceResult("SUCCESS")
}

class RepositoryWithRestrict<T : IWithUid> : IEntityRepositoryWithRestrict<T> {
    override fun saveUnsafe(entity: T): ServiceResult = ServiceResult("SUCCESS")
}

