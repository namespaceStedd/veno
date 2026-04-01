package namespace.stedd.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import namespace.stedd.data.type.ExoNumber;
import namespace.stedd.data.type.ExoString;

/**
 * Преобразование величин из одного типа данных в другой.
 * @author Namespace Stedd
 */
public class Converter {

    public static final Gson json = new GsonBuilder()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .create();   // JSON-преобразователь по умолчанию

    public static final GsonBuilder customJson = new GsonBuilder();   // JSON-конструктор


    /**
     * Проверка строки на NOT NULL.
     * @author Namespace Stedd
     * @param string проверяемая строка
     * @return статус NOT NULL
     */
    public static boolean notNullStatus(String string) {
        return ExoString.notNullStatus(string);
    }

    /**
     * Проверка объектов на NOT NULL равенство.
     * @author Namespace Stedd
     * @param firstObject первый сравниваемый объект
     * @param secondObject второй сравниваемый объект
     * @return NOT NULL равенство
     * @param <T> универсальный параметр типа
     */
    public static <T> boolean notNullEquals(T firstObject, T secondObject) {
        return notNullEquals(firstObject, secondObject, true);
    }

    /**
     * Проверка объектов на NOT NULL равенство.
     * @author Namespace Stedd
     * @param firstObject первый сравниваемый объект
     * @param secondObject второй сравниваемый объект
     * @param acceptNullEquals допущение равенства при обоих NULL объектах
     * @return NOT NULL равенство
     * @param <T> универсальный параметр типа
     */
    public static <T> boolean notNullEquals(T firstObject, T secondObject, boolean acceptNullEquals) {
        return acceptNullEquals && firstObject == null && secondObject == null ||   // Проверка возможности равенства NULL
                firstObject != null && firstObject.equals(secondObject);
    }

    /**
     * Преобразование объекта в строку с проверкой на null.
     * @author Namespace Stedd
     * @param stringable подвергающийся острингнению объект
     * @param ifNull значение при пустом объекте
     * @return строчное значение для записи в Базу данных
     */
    public static String parseString(Object stringable, String ifNull) {
        return ExoString.parseString(stringable, ifNull);
    }

    /**
     * Преобразование объекта в большое целое число с проверкой на null.
     * @author Namespace Stedd
     * @param longable подвергающийся большеоцелоочислению объект
     * @param ifNull значение при пустом объекте
     * @return большеоцелочисленное значение
     */
    public static long parseLong(Object longable, long ifNull) {
        return ExoNumber.parseLong(longable, ifNull);
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
        return ExoString.toArrayString(array, delimiter);
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
