package namespace.stedd.data.table;

import java.util.Map;

/**
 * Строка данных таблицы.
 * @author Namespace Stedd
 */
public interface DataRow {
    String getInfo(ColumnList column);   // Получение информации по столбцу
    Map<ColumnList, String> getInfo(ColumnList[] columns);   // Получение информации по всей строке
}
