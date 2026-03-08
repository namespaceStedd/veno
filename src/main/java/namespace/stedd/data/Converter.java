package namespace.stedd.data;

/**
 * Преобразование величин из одного типа данных в другой.
 * @author Namespace Stedd
 */
public class Converter {

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
     * Преобразование объекта в строку с проверкой на null.
     * @author Namespace Stedd
     * @param stringable подвергающийся острингнению объект
     * @param ifNull значение при пустом объекте
     * @return строчное значение для записи в Базу данных
     */
    public static String parseString(Object stringable, String ifNull) {
        return stringable != null ? String.valueOf(stringable) : ifNull;
    }

    /**
     * Преобразование объекта в большое целое число с проверкой на null.
     * @author Namespace Stedd
     * @param longable подвергающийся большеоцелоочислению объект
     * @param ifNull значение при пустом объекте
     * @return большеоцелочисленное значение
     */
    public static Long parseLong(Object longable, long ifNull) {
        String integerableString = parseString(longable, String.valueOf(ifNull));
        return notNullStatus(integerableString) ? Long.parseLong(integerableString) : ifNull;
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
     * Переписывает строку BIN в Байт.
     * @author Namespace Stedd
     * @param binaryString исходная бинарная строка
     * @return полученный Байт
     */
    public static byte binaryStringToByte(String binaryString) {
        return (byte) Integer.parseInt(binaryString, 2);
    }

    /**
     * Переписывает строку HEX в Байт.
     * @author Namespace Stedd
     * @param hexString исходная строка HEX
     * @return полученный Байт
     */
    public static byte hexStringToByte(String hexString) {
        return (byte) Integer.parseInt(hexString, 16);
    }

}
