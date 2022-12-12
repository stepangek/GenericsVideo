import stubs.EmailEntity
import stubs.PersonEntity
import stubs.ServiceResult

// 3. Интерфейс с дженериком
// Показаны различные стратегии. Подстановка типа на этапе определения конкретного класса
// или на этапе создания экземпляра

interface IEntityRepository<T> {
    fun saveUnsafe(entity: T): ServiceResult // Переданный тип Т используется для определения типа обьекта, который будет передан
}

class EmailRepository : IEntityRepository<EmailEntity> {
    override fun saveUnsafe(entity: EmailEntity): ServiceResult = ServiceResult("SUCCESS")
}

class Repository<T> : IEntityRepository<T> {
    override fun saveUnsafe(entity: T): ServiceResult = ServiceResult("SUCCESS")
}

fun main() {
    val emailRepo = EmailRepository() // нет нужды передавать Т, так как он определен при определении класса
    val repo = Repository<PersonEntity>() // есть необходимость передавать Т, т.к. в Repository Т не определен
}

