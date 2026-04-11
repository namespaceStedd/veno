package namespace.stedd.data.type;

import namespace.stedd.data.Converter;

/**
 * Расширенное представление объекта.
 * @author Namespace Stedd
 */
public interface ExObject {

    /**
     * Получение названия объекта.
     * @author Namespace Stedd
     * @return название объекта
     */
    default String name() {
        return "";
    }

    /**
     * Сравнение равнозначности текущего объекта и указанного.
     * @author Namespace Stedd
     * @param object указанный объект
     * @return равнозначность текущего объекта и указанного
     */
    default boolean equals(ExObject object) {
        return this.equals((Object) object);
    }

    /**
     * Определение принадлежности текущего объекта к указанным.
     * @author Namespace Stedd
     * @param objects указанные объекты
     * @return принадлежность текущего объекта к одному из указанных
     */
    default boolean equals(ExObject... objects) {
        for (ExObject object : objects) {
            if (this.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Преобразование объекта в JSON-строку.
     * @author Namespace Stedd
     * @return строчное представление объекта
     */
    default String toJsonString() {
        return Converter.json.toJson(this);
    }

}
