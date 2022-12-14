package stubs

enum class SaveMode {
    /** Обновление имеющегося плюс вставка нового если отсутсвует */
    UPSERT,
    /** Только вставка нового, ошибка при дублировании ключа */
    INSERT_ONLY,
    /** Подразумевает удаление репорттайпов, которые больше не существуют и перезапись остальных */
    OVERWRITE
}