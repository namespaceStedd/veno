package namespace.stedd.data.type;

import java.util.List;

/**
 * Расширенное представление строки.
 * @author Namespace Stedd
 */
public class ExoString {

    private String string;   // Обычная строка

    /**
     * Создание строки NULL.
     * @author Namespace Stedd
     */
    public ExoString() {
        this.string = null;
    }

    /**
     * Создание строки NULL.
     * @author Namespace Stedd
     * @param string новая строка
     */
    public ExoString(String string) {
        this.string = string;
    }

    /**
     * Преобразование объекта в строку с проверкой на NULL.
     * @author Namespace Stedd
     * @param stringable подвергающийся острингнению объект
     * @param ifNull значение при пустом объекте
     * @return строчное значение для записи в Базу данных
     */
    public static String parseString(Object stringable, String ifNull) {
        return stringable != null ? String.valueOf(stringable) : ifNull;
    }

    /**
     * Получение текущей строки.
     * @author Namespace Stedd
     * @return текущая строка
     */
    public String getString() {
        return this.string;
    }

    /**
     * Получение текущей строки.
     * @author Namespace Stedd
     * @param ifNull значение при пустой строке
     * @return текущая строка
     */
    public String getString(String ifNull) {
        return parseString(this.string, ifNull);
    }

    /**
     * Обновление текущей строки.
     * @author Namespace Stedd
     * @param string новая строка
     */
    public void setString(String string) {
        this.string = string;
    }

    /**
     * Преобразование объекта в текущую строку с проверкой на NULL.
     * @author Namespace Stedd
     * @param stringable подвергающийся острингнению объект
     * @param ifNull значение при пустом объекте
     * @return строчное значение для записи в Базу данных
     */
    public void setString(Object stringable, String ifNull) {
        this.string = parseString(stringable, ifNull);
    }

    /**
     * Проверка строки на NOT NULL.
     * @author Namespace Stedd
     * @param string проверяемая строка
     * @return статус NOT NULL
     */
    public static boolean notNullStatus(String string) {
        return string != null && !string.isEmpty();
    }

    /**
     * Проверка текущей строки на NOT NULL.
     * @author Namespace Stedd
     * @return статус NOT NULL
     */
    public boolean isNotNull() {
        return notNullStatus(this.string);
    }

    /**
     * Преобразование массива в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив
     * @param delimiter разделитель
     * @return строчный массив
     * @param <T> универсальный параметр типа
     */
    public static <T> String toArrayString(T[] array, String delimiter) {
        StringBuilder arrayString = new StringBuilder();
        for (T element : array) {
            arrayString.append(element).append(delimiter);
        }
        int arrayLength = arrayString.length(), delimiterLength = delimiter.length();
        return arrayLength > delimiterLength ?
                arrayString.delete(arrayLength - delimiterLength, arrayLength).toString() :
                arrayString.toString();
    }

    /**
     * Преобразование списка в строку с разделителем.
     * @author Namespace Stedd
     * @param list список
     * @param delimiter разделитель
     * @return строчный список
     * @param <T> универсальный параметр типа
     */
    public static <T> String toListString(List<T> list, String delimiter) {
        StringBuilder arrayString = new StringBuilder();
        for (T element : list) {
            arrayString.append(element).append(delimiter);
        }
        int arrayLength = arrayString.length(), delimiterLength = delimiter.length();
        return arrayLength > delimiterLength ?
                arrayString.delete(arrayLength - delimiterLength, arrayLength).toString() :
                arrayString.toString();
    }

    /**
     * Получение строчного представления исключения.
     * @author Namespace Stedd
     * @param exception выбрасываемое исключение
     * @return строчное представление исключения
     */
    public static String toExceptionString(Exception exception) {
        return '\n' + exception.getMessage() + '\n' + toArrayString(exception.getStackTrace(), "\n\t");
    }

    /**
     * Подписывание объекта.
     * @author Namespace Stedd
     * @param title подпись объекта
     * @param object подписываемый объект
     * @return подписанный объект
     */
    public static String signObject(String title, Object object) {
        return signObject(title, object, false);
    }

    /**
     * Подписывание объекта.
     * @author Namespace Stedd
     * @param object подписываемый объект
     * @return подписанный объект
     */
    public String sign(Object object) {
        return signObject(this.string, object, false);
    }

    /**
     * Подписывание объекта.
     * @author Namespace Stedd
     * @param withNewLine допускание подписи с новой строки
     * @param title подпись объекта
     * @param object подписываемый объект
     * @return подписанный объект
     */
    public static String signObject(boolean withNewLine, String title, Object object) {
        return signObject(withNewLine, title, object, false);
    }

    /**
     * Подписывание объекта.
     * @author Namespace Stedd
     * @param withNewLine допускание подписи с новой строки
     * @param object подписываемый объект
     * @return подписанный объект
     */
    public String sign(boolean withNewLine, Object object) {
        return signObject(withNewLine, this.string, object, false);
    }

    /**
     * Подписывание объекта.
     * @author Namespace Stedd
     * @param title подпись объекта
     * @param object подписываемый объект
     * @param allowEmptySign допускание пустого объекта
     * @return подписанный объект
     */
    public static String signObject(String title, Object object, boolean allowEmptySign) {
        return signObject(false, title, object, allowEmptySign);
    }

    /**
     * Подписывание объекта.
     * @author Namespace Stedd
     * @param object подписываемый объект
     * @param allowEmptySign допускание пустого объекта
     * @return подписанный объект
     */
    public String sign(Object object, boolean allowEmptySign) {
        return signObject(false, this.string, object, allowEmptySign);
    }

    /**
     * Подписывание объекта.
     * @author Namespace Stedd
     * @param withNewLine допускание подписи с новой строки
     * @param title подпись объекта
     * @param object подписываемый объект
     * @param allowEmptySign допускание пустого объекта
     * @return подписанный объект
     */
    public static String signObject(boolean withNewLine, String title, Object object, boolean allowEmptySign) {
        String stringObject = parseString(object, null);
        if (allowEmptySign || notNullStatus(stringObject)) {
            return (withNewLine ? "\n" : "") + title + ": " + stringObject;
        }
        return "";
    }

    /**
     * Подписывание объекта.
     * @author Namespace Stedd
     * @param withNewLine допускание подписи с новой строки
     * @param object подписываемый объект
     * @param allowEmptySign допускание пустого объекта
     * @return подписанный объект
     */
    public String sign(boolean withNewLine, Object object, boolean allowEmptySign) {
        String stringObject = parseString(object, null);
        if (allowEmptySign || notNullStatus(stringObject)) {
            return (withNewLine ? "\n" : "") + this.string + ": " + stringObject;
        }
        return "";
    }

    /**
     * Удаление последних символов в строке.
     * @author Namespace Stedd
     * @param string строка
     * @param length количество удаляемых в конце символов
     * @return строка без последних символов
     */
    public static String deleteLastChars(String string, int length) {
        // TODO: Conv IsEm
        return string != null && string.length() >= length ? string.substring(0, string.length() - length) : "";
    }

    /**
     * Удаление последних символов в текущей строке.
     * @author Namespace Stedd
     * @param length количество удаляемых в конце символов
     * @return расширенное представление строки
     */
    public ExoString deleteLastChars(int length) {
        this.string = deleteLastChars(this.string, length);
        return this;
    }

}
