package namespace.stedd.data.type;

import namespace.stedd.data.Converter;
import namespace.stedd.data.type.string.AlignPosition;

import java.util.ArrayList;
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

    /**
     * Проверка содержания любой из указанных подстрок в текущей строке.
     * @author Namespace Stedd
     * @param substrings подстроки
     * @return результат содержания в текущей строке
     */
    public boolean contains(String... substrings) {
        return stringContains(this.string, substrings);
    }

    /**
     * Проверка содержания любой из указанных подстрок в текущей строке.
     * @author Namespace Stedd
     * @param string строка
     * @param substrings подстроки
     * @return результат содержания в текущей строке
     */
    public static boolean stringContains(String string, String... substrings) {
        for (String substring : substrings) {
            if (string.contains(substring)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Выравнивание строки по указанной позиции.
     * @author Namespace Stedd
     * @param string выравниваемая строка
     * @param alignPosition позиция выравнивания
     * @param maxLength максимальная длина строки
     * @param minIndentation минимальный отступ строки
     * @return выравненная строка
     */
    public static String align(String string, AlignPosition alignPosition, int maxLength, int minIndentation) {
        // Позитивирование переменных
        maxLength = Math.max(1, maxLength);
        minIndentation = Math.max(0, minIndentation);
        int maxClearLength = Math.max(1, maxLength - 2 * minIndentation);
        // Список выравненных частей строки
        List<String> aligned = new ArrayList<>();
        // Объявление текущей части строки
        StringBuilder currentStringLine = new StringBuilder();
        // Разделение по словам
        String[] words = string.split(" ");
        // Для каждого едкого словца из строки
        for (int i = 0, currentLength = currentStringLine.length();
             i < words.length;
             i++, currentLength = currentStringLine.length()) {
            // Текущее слово
            String word = words[i];
            // Если к текущей строке добавить текущее слово с пробелом (+1) и длина будет меньше чистой максимальной, при этом всём слова уже были добавлены
            if (currentLength + word.length() + 1 > maxClearLength && currentLength > 0) {
                // Определяем текущую часть строки с отступами и добавляем в список
                aligned.add(createPart(currentStringLine.toString(), alignPosition, maxLength, minIndentation));
                // Обнуляем текущую часть строки
                currentStringLine = new StringBuilder();
            }
            // Если текущее слово длиннее максимальной длины – придётся делать обрезание...
            while (word.length() > maxClearLength) {
                // Определение текущей части слова
                String wordPart = word.substring(0, maxClearLength);
                // Определяем текущую часть строки с отступами и добавляем в список
                aligned.add(createPart(wordPart, alignPosition, maxLength, minIndentation));
                // Обнуляем текущую часть слова
                word = word.substring(maxClearLength);
            }
            // Добавляем к текущей части строки слово
            currentStringLine.append(currentStringLine.isEmpty() ? "" : " ").append(word);
        }
        // Если остались недосказанные слова
        if (!currentStringLine.isEmpty()) {
            // Определяем текущую часть строки с отступами и добавляем в список
            aligned.add(createPart(currentStringLine.toString(), alignPosition, maxLength, minIndentation));
        }
        // Преобразование в строчный список элементов с разделителем-переносом
        return Converter.toListString(aligned, "\n");
    }

    /**
     * Создание полноценной части перенесённой строки.
     * @author Namespace Stedd
     * @param stringPart текущая часть строки
     * @param alignPosition позиция выравнивания
     * @param maxLength максимальная длина строки
     * @param minIndentation минимальный отступ строки
     * @return полноценная часть перенесённой строки
     */
    private static String createPart(String stringPart, AlignPosition alignPosition, int maxLength, int minIndentation) {
        // Расчёт отступов с двух сторон
        int bothCenterIndentation = Math.max(0, maxLength - stringPart.length()), beganSpaces = switch (alignPosition) {
            case LEFT -> minIndentation;
            case CENTER -> bothCenterIndentation / 2 + bothCenterIndentation % 2;
            case RIGHT -> 0;
        }, endingSpaces = switch (alignPosition) {
            case LEFT -> 0;
            case CENTER -> bothCenterIndentation / 2;
            case RIGHT -> minIndentation;
        };
        // Складываем части текущей части строки
        return " ".repeat(beganSpaces)   // Начальный отступ
                + stringPart   // Текущая часть строки
                + " ".repeat(endingSpaces)   // Конечный отступ
                ;
    }

    /**
     * Разделение пар ключ-значение по разным краям.
     * @author Namespace Stedd
     * @param key ключ
     * @param value значение
     * @param maxLength максимальная длина строки
     * @param minIndentation минимальный отступ строки с двух сторон
     * @return выравненная строка
     */
    public static String alignToEdges(String key, String value, int maxLength, int minIndentation) {
        // Начальные установки
        maxLength = Math.max(1, maxLength);
        minIndentation = Math.max(0, minIndentation);
        // Выравненные части строки
        List<String> aligned = new ArrayList<>();
        // Разнесённые по колонкам пара ключ-значение
        String[] cornedKeys = align(key, AlignPosition.LEFT, maxLength / 2, minIndentation).split("\n");
        String[] cornedValues = align(value, AlignPosition.RIGHT, maxLength / 2, minIndentation).split("\n");
        for (int i = 0; i < cornedKeys.length || i < cornedValues.length; i++) {
            String cornedKey = i < cornedKeys.length ? cornedKeys[i] : " ".repeat(minIndentation + 1);
            String cornedValue = i < cornedValues.length ? cornedValues[i] : " ".repeat(minIndentation + 1);
            int lengthBetween = Math.max(0, maxLength - cornedKey.length() - cornedValue.length());
            aligned.add(cornedKey + " ".repeat(lengthBetween) + cornedValue);
        }
        return Converter.toListString(aligned, "\n");
    }

}
