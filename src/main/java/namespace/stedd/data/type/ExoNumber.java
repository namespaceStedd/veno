package namespace.stedd.data.type;

import namespace.stedd.data.type.number.Range;

/**
 * Расширенное представление числа.
 * @author Namespace Stedd
 */
public class ExoNumber extends Number {

    private Double number;   // Представляемое число
    private Range range;   // Диапазон возможных значений числа

    /**
     * Создание несуществующего представляемого числа.
     * @author Namespace Stedd
     */
    public ExoNumber() {
        this.number = null;
    }

    /**
     * Создание представляемого числа.
     * @author Namespace Stedd
     * @param number представляемое число
     */
    public ExoNumber(double number) {
        this.number = number;
    }

    /**
     * Создание представляемого числа.
     * @author Namespace Stedd
     * @param number представляемое число
     * @return расширенное представление числа
     */
    public static ExoNumber create(double number) {
        return new ExoNumber(number);
    }

    /**
     * Получение представляемого числа.
     * @author Namespace Stedd
     * @return представляемое число
     */
    public Double getNumber() {
        return this.number;
    }

    /**
     * Получение представляемого числа.
     * @author Namespace Stedd
     * @param ifNull если текущее значение NULL
     * @return представляемое число
     */
    public double getNumber(double ifNull) {
        return this.number != null ? this.number : ifNull;
    }

    /**
     * Обновление представляемого числа.
     * @author Namespace Stedd
     * @param number представляемое число
     */
    public void setNumber(Double number) {
        this.number = number;
    }

    /**
     * Преобразование объекта в малое целое число с проверкой на NULL.
     * @author Namespace Stedd
     * @param shortable подвергающийся малоочислению объект
     * @param ifNull значение при пустом объекте
     * @return малое целое число
     */
    public static short parseShort(Object shortable, short ifNull) {
        return parseShort(shortable, Short.valueOf(ifNull));
    }

    /**
     * Преобразование объекта в малое целое число с проверкой на NULL.
     * @author Namespace Stedd
     * @param shortable подвергающийся малоочислению объект
     * @param ifNull значение при пустом объекте
     * @return малое целое число
     */
    public static Short parseShort(Object shortable, Short ifNull) {
        String shortableString = ExoString.parseString(shortable, ExoString.parseString(ifNull, null));
        return ExoString.notNullStatus(shortableString) ? Short.parseShort(shortableString.split("\\.")[0]) : ifNull;
    }

    /**
     * Преобразование объекта в целое число с проверкой на NULL.
     * @author Namespace Stedd
     * @param integerable подвергающийся целоочислению объект
     * @param ifNull значение при пустом объекте
     * @return целое число
     */
    public static int parseInteger(Object integerable, int ifNull) {
        return parseInteger(integerable, Integer.valueOf(ifNull));
    }

    /**
     * Преобразование объекта в целое число с проверкой на NULL.
     * @author Namespace Stedd
     * @param integerable подвергающийся целоочислению объект
     * @param ifNull значение при пустом объекте
     * @return целое число
     */
    public static Integer parseInteger(Object integerable, Integer ifNull) {
        String integerableString = ExoString.parseString(integerable, ExoString.parseString(ifNull, null));
        return ExoString.notNullStatus(integerableString) ? Integer.parseInt(integerableString.split("\\.")[0]) : ifNull;
    }

    /**
     * Returns the value of the specified number as an {@code int}.
     *
     * @return  the numeric value represented by this object after conversion
     *          to type {@code int}.
     */
    @Override
    public int intValue() {
        return (int) this.longValue();
    }

    /**
     * Преобразование объекта в большое целое число с проверкой на NULL.
     * @author Namespace Stedd
     * @param longable подвергающийся большеоцелоочислению объект
     * @param ifNull значение при пустом объекте
     * @return большое целое число
     */
    public static long parseLong(Object longable, long ifNull) {
        return parseLong(longable, Long.valueOf(ifNull));
    }

    /**
     * Преобразование объекта в большое целое число с проверкой на NULL.
     * @author Namespace Stedd
     * @param longable подвергающийся большеоцелоочислению объект
     * @param ifNull значение при пустом объекте
     * @return большое целое число
     */
    public static Long parseLong(Object longable, Long ifNull) {
        String longableString = ExoString.parseString(longable, ExoString.parseString(ifNull, null));
        return ExoString.notNullStatus(longableString) ? Long.parseLong(longableString) : ifNull;
    }

    /**
     * Преобразование Строкового числа в Большое Целое число.
     * @author Namespace Stedd
     * @param number Строковое число
     * @return Большое Целое число
     */
    public static long getLong(String number) {
        return number.contains("-") ? withMinimum(number) : withMaximum(number);
    }

    /**
     * Returns the value of the specified number as a {@code long}.
     *
     * @return  the numeric value represented by this object after conversion
     *          to type {@code long}.
     */
    @Override
    public long longValue() {
        return getLong(ExoString.parseString(this.number, "0").split("\\.")[0]);
    }

    /**
     * Returns the value of the specified number as a {@code float}.
     *
     * @return  the numeric value represented by this object after conversion
     *          to type {@code float}.
     */
    @Override
    public float floatValue() {
        return (float) this.doubleValue();
    }

    /**
     * Преобразование объекта в числовое значение с проверкой на NULL.
     * @author Namespace Stedd
     * @param numerable подвергающийся очислению объект
     * @param ifNull значение при пустом объекте
     * @return числовое значение
     */
    public static double parseNumber(Object numerable, double ifNull) {
        return parseNumber(numerable, Double.valueOf(ifNull));
    }

    /**
     * Преобразование объекта в числовое значение с проверкой на NULL.
     * @author Namespace Stedd
     * @param numerable подвергающийся очислению объект
     * @param ifNull значение при пустом объекте
     * @return числовое значение
     */
    public static Double parseNumber(Object numerable, Double ifNull) {
        String numerableString = ExoString.parseString(numerable, ExoString.parseString(ifNull, null));
        return ExoString.notNullStatus(numerableString) ? Double.parseDouble(numerableString) : ifNull;
    }

    /**
     * Returns the value of the specified number as a {@code double}.
     *
     * @return  the numeric value represented by this object after conversion
     *          to type {@code double}.
     */
    @Override
    public double doubleValue() {
        return parseNumber(this.number, 0);
    }

    /**
     * Преобразование Большого Целого числа с учётом выхода за его нижние границы.
     * @author Namespace Stedd
     * @param longString Строковое Большое Целое число
     * @return корректное Большое Целое число
     */
    private static long withMinimum(String longString) {
        long min = Long.MIN_VALUE;
        String minLong = Long.toString(min);
        // Если введён только минус, то возвращаем 0 TODO: подумать насчёт парсера
        if (longString.length() < 2 && longString.startsWith("-")) {
            return 0;
        }
        // Если количество цифр меньше количества цифр в максимальном значении Большого Целого числа, то парсим реальное введённое число
        else if (longString.length() < minLong.length()) {
            return parseLong(longString, 0);
        }
        // Если количество цифр больше количества цифр в максимальном значении Большого Целого числа, то отправляем максимальное число
        else if (longString.length() > minLong.length()) {
            return min;
        }
        // Если количество цифр у введённого и максимального значения равны, то проверяем каждую цифру по отдельности
        else {
            for (int i = 0; i < longString.length(); i++) {
                char inputtedChar = longString.charAt(i);
                if (inputtedChar == '-') {
                    continue;
                }
                int inputted = Integer.parseInt(inputtedChar + "");
                int minimized = Integer.parseInt(minLong.charAt(i) + "");
                if (inputted > minimized) {
                    return min;
                }
            }
            return parseLong(longString, 0);
        }
    }

    /**
     * Преобразование Большого Целого числа с учётом выхода за его верхние границы.
     * @author Namespace Stedd
     * @param longString Строковое Большое Целое число
     * @return корректное Большое Целое число
     */
    private static long withMaximum(String longString) {
        long max = Long.MAX_VALUE;
        String maxLong = Long.toString(max);
        // Если количество цифр меньше количества цифр в максимальном значении Большого Целого числа, то парсим реальное введённое число
        if (longString.length() < maxLong.length()) {
            return parseLong(longString, 0);
        }
        // Если количество цифр больше количества цифр в максимальном значении Большого Целого числа, то отправляем максимальное число
        else if (longString.length() > maxLong.length()) {
            return max;
        }
        // Если количество цифр у введённого и максимального значения равны, то проверяем каждую цифру по отдельности
        else {
            for (int i = 0; i < longString.length(); i++) {
                int inputted = Integer.parseInt(longString.charAt(i) + "");
                int maximized = Integer.parseInt(maxLong.charAt(i) + "");
                if (inputted > maximized) {
                    return max;
                }
            }
            return parseLong(longString, 0);
        }
    }

}
