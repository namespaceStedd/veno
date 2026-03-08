package namespace.stedd.data.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Список колонок Таблицы.
 * @author Namespace Stedd
 */
public interface ColumnList {

    String columnName();   // Название столбца
    int length();   // Количество столбцов Таблицы
    boolean isLimited();   // Получение показателя присутствия ограничения по количеству символов столбца
    int getLimit();   // Получение ограничения по столбцу
    void setLimit(int limit);   // Применение ограничения по столбцу

    /**
     * Преобразование списка столбцов Таблицы в карту.
     * @author Namespace Stedd
     * @param columns список столбцов Таблицы
     * @return карта столбцов
     */
    static Map<ColumnList, String> toMap(ColumnList[] columns) {
        Map<ColumnList, String> columnMap = new HashMap<>();
        for (ColumnList column : columns) {
            columnMap.put(column, column.toString());
        }
        return columnMap;
    }

}
