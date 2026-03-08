package namespace.stedd.data.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс отрисовки Таблицы.
 * @author Namespace Stedd
 */
public class Table {

    private final ColumnList[] columns;   // Список столбцов Таблицы
    private final DataRow[] data;   // Данные Таблицы
    private final Map<ColumnList, Integer> limitations;   // Список ограничений по размеру данных строки

    /**
     * Создание Таблицы.
     * @author Namespace Stedd
     * @param columns список столбцов
     * @param data данные Таблицы
     */
    public Table(ColumnList[] columns, DataRow[] data) {
        // Заполнение ограничений
        this.columns = columns;
        this.data = data;
        this.limitations = new HashMap<>();
        for (ColumnList column : this.columns) {
            this.limitations.put(column, maxLength(column, this.data));
        }
    }

    /**
     * Получение максимальной величины столбца.
     * @author Namespace Stedd
     * @param column колонка Таблицы
     * @return максимальная величина столбца
     */
    public static int maxLength(ColumnList column) {
        return column.toString().length();
    }

    /**
     * Получение максимальной величины столбца.
     * @author Namespace Stedd
     * @param column колонка Таблицы
     * @param data данные Таблицы
     * @return максимальная величина столбца
     */
    public static int maxLength(ColumnList column, DataRow[] data) {
        int maximum = maxLength(column);
        for (DataRow dataRow : data) {
            maximum = Math.max(dataRow.getInfo(column).length(), maximum);
        }
        return column.isLimited() ? Math.min(maximum, column.getLimit()) : maximum;
    }

    /**
     * Перенос данных строки в несколько строк.
     * @author Namespace Stedd
     * @param rowData данные строки
     * @return перенесённые данные
     */
    public String doDataBreak(Map<ColumnList, String> rowData) {
        Map<ColumnList, String[]> lineBrokenData = new HashMap<>();
        int linesCount = 1;
        for (ColumnList column : this.columns) {
            int limit = this.limitations.get(column);
            String[] lineBroken = this.doLineBreak(rowData.get(column), limit);
            lineBrokenData.put(column, lineBroken);
            linesCount = Math.max(linesCount, lineBroken.length);
        }
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < linesCount; i++) {
            for (ColumnList column : this.columns) {
                String[] columnData = lineBrokenData.get(column);
                int limit = this.limitations.get(column);
                String currentData = this.fillEmpties(
                        i < columnData.length ? columnData[i] : "",
                        ' ',
                        limit
                );
                data.append("| ").append(currentData).append(' ');
            }
            data.append("|\n");
        }
        return data.toString();
    }

    /**
     * Перенос одной строки по ограничителю.
     * @author Namespace Stedd
     * @param line переносимая строка
     * @param charCount ограничение по одной строке
     * @return перенесённая строка
     */
    public String[] doLineBreak(String line, int charCount) {
        int size = (int) Math.ceil((double) line.length() / charCount);
        String[] lineBroken = new String[size];
        for (int i = 0; !line.isEmpty(); i++) {
            if (line.length() < charCount) {
                lineBroken[i] = line;
                break;
            }
            lineBroken[i] = line.substring(0, charCount);
            line = line.substring(charCount);
        }
        return lineBroken;
    }

    /**
     * Дополнение непутёвых пробелов в строку для дополнения к её нужной величине.
     * @author Namespace Stedd
     * @param source исходная строка
     * @param empties заполняемые символы
     * @param length необходимая длина строки
     * @return необходимая строка
     */
    public String fillEmpties(String source, char empties, int length) {
        return String.valueOf(empties).repeat(Math.max(length - source.length(), 0)) + source;
    }

    /**
     * Получение отображения Таблицы.
     * @author Namespace Stedd
     * @return отображение Таблицы
     */
    @Override
    public String toString() {
        // Получение ширины Таблицы
        int width = 0;
        for (Integer limit : this.limitations.values()) {
            width += limit + 2;
        }
        width += this.limitations.size() + 1;
        System.out.println("Ширина Таблицы: " + width);

        // Объявление составителя Таблицы и строительство заголовка Таблицы
        StringBuilder table = new StringBuilder("—".repeat(width))
                .append('\n')
                .append(this.doDataBreak(ColumnList.toMap(this.columns)))
                .append("—".repeat(width));

        // Добавление данных таблицы "по очереди"
        for (DataRow rowData : this.data) {
            table.append('\n')
                    .append(this.doDataBreak(rowData.getInfo(this.columns)))
                    .append("—".repeat(width));
        }

        // Возврат Таблицы
        return table.toString();
    }

    /**
     * Получение готовой Таблицы.
     * @author Namespace Stedd
     * @param columns список столбцов
     * @param data данные Таблицы
     * @return готовая строковая таблица
     */
    public static String getPrintableTable(ColumnList[] columns, DataRow[] data) {
        return new Table(columns, data).toString();
    }

}
