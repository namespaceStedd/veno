package namespace.stedd.data.type;

import namespace.stedd.data.type.number.Range;

import java.util.Random;

/**
 * Расширенное представление числа.
 * @author Namespace Stedd
 */
public class ExoNumber extends Number {

    protected Double number;   // Представляемое число
    protected Range range;   // Диапазон возможных значений числа

    /**
     * Генератор псевдослучайных чисел.
     */
    public static final Random random = new Random();

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
     * Получение малого целого числа по двум байтам.
     * @author Namespace Stedd
     * @param high верхний байт
     * @param low нижний байт
     * @return малое целое число
     */
    public static short toShort(byte high, byte low) {
        return (short) ((high << 8 & 0xff00) + (low & 0xff));
    }

    /**
     * Получение массива байт по малому целому числу.
     * @author Namespace Stedd
     * @param number малое целое число
     * @return массив байт
     */
    public static byte[] toByteArray(short number) {
        return new byte[] {
                (byte) (number >> 8 & 0xff),
                (byte) (number & 0xff)
        };
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
     * Получение целого числа по массиву байт.
     * @author Namespace Stedd
     * @param bytes массив байт
     * @return целое число
     */
    public static int toInteger(byte... bytes) {
        int shifter = Math.min(4, bytes.length) - 1;
        int number = 0;
        for (int i = bytes.length - 1, j = 0; i >= 0 && j < 4; i--, j++) {
            int coefficient = 8 * (shifter - i);
            number += (bytes[i] << coefficient) & (0xff << coefficient);
        }
        return number;
    }

    /**
     * Получение массива байт по целому числу.
     * @author Namespace Stedd
     * @param number целое число
     * @return массив байт
     */
    public static byte[] toByteArray(int number) {
        byte[] intBytes = new byte[4];
        for (int i = 0; i < intBytes.length; i++) {
            intBytes[intBytes.length - i - 1] = (byte) ((number >> (8 * i)) & 0xff);
        }
        return intBytes;
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
     * Получение большого целого числа по массиву байт.
     * @author Namespace Stedd
     * @param bytes массив байт
     * @return большое целое число
     */
    public static long toLong(byte... bytes) {
        int shifter = Math.min(8, bytes.length) - 1;
        long number = 0;
        for (int i = bytes.length - 1, j = 0; i >= 0 && j < 8; i--, j++) {
            int coefficient = 8 * (shifter - i);
            number += ((long) bytes[i] << coefficient) & (0xffL << coefficient);
        }
        return number;
    }

    /**
     * Получение массива байт по большому целому числу.
     * @author Namespace Stedd
     * @param number большое целое число
     * @return массив байт
     */
    public static byte[] toByteArray(long number) {
        byte[] longBytes = new byte[8];
        for (int i = 0; i < longBytes.length; i++) {
            longBytes[longBytes.length - i - 1] = (byte) ((number >> (8 * i)) & 0xff);
        }
        return longBytes;
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

    /**
     * Приближение указанного числа к ближайшему из вариантов.
     * @author Namespace Stedd
     * @param number байт
     * @param variants варианты приближения
     * @return ближайшее приблизительное число
     */
    public static byte approach(byte number, byte... variants) {
        return (byte) approach(number, ExoCollection.toDoubleArray(variants));
    }

    /**
     * Приближение указанного числа к ближайшему из вариантов.
     * @author Namespace Stedd
     * @param number малое целое число
     * @param variants варианты приближения
     * @return ближайшее приблизительное число
     */
    public static short approach(short number, short... variants) {
        return (short) approach(number, ExoCollection.toDoubleArray(variants));
    }

    /**
     * Приближение указанного числа к ближайшему из вариантов.
     * @author Namespace Stedd
     * @param number целое число
     * @param variants варианты приближения
     * @return ближайшее приблизительное число
     */
    public static int approach(int number, int... variants) {
        return (int) approach(number, ExoCollection.toDoubleArray(variants));
    }

    /**
     * Приближение указанного числа к ближайшему из вариантов.
     * @author Namespace Stedd
     * @param number большое целое число
     * @param variants варианты приближения
     * @return ближайшее приблизительное число
     */
    public static long approach(long number, long... variants) {
        return (long) approach(number, ExoCollection.toDoubleArray(variants));
    }

    /**
     * Приближение указанного числа к ближайшему из вариантов.
     * @author Namespace Stedd
     * @param number дробное число
     * @param variants варианты приближения
     * @return ближайшее приблизительное число
     */
    public static float approach(float number, float... variants) {
        return (float) approach(number, ExoCollection.toDoubleArray(variants));
    }

    /**
     * Приближение указанного числа к ближайшему из вариантов.
     * @author Namespace Stedd
     * @param number дробное число двойной точности
     * @param variants варианты приближения
     * @return ближайшее приблизительное число
     */
    public static double approach(double number, double... variants) {
        if (variants.length == 0) {
            return number;
        }
        double approach = variants[0];
        for (int i = 1; i < variants.length; i++) {
            if (Math.abs(number - variants[i]) < Math.abs(number - approach)) {
                approach = variants[i];
            }
        }
        return approach;
    }

    /**
     * Повторение числа указанное количество раз.
     * @author Namespace Stedd
     * @param number повторяемый байт
     * @param times количество повторений
     * @return массив байт повторённых значений
     */
    public static byte[] repeat(byte number, int times) {
        times = Math.clamp(times, 0, Integer.MAX_VALUE);
        byte[] data = new byte[times];
        for (int i = 0; i < times; i++) {
            data[i] = number;
        }
        return data;
    }

    /**
     * Повторение числа указанное количество раз.
     * @author Namespace Stedd
     * @param number повторяемое малое целое число
     * @param times количество повторений
     * @return массив малых целых чисел повторённых значений
     */
    public static short[] repeat(short number, int times) {
        times = Math.clamp(times, 0, Integer.MAX_VALUE);
        short[] data = new short[times];
        for (int i = 0; i < times; i++) {
            data[i] = number;
        }
        return data;
    }

    /**
     * Повторение числа указанное количество раз.
     * @author Namespace Stedd
     * @param number повторяемое целое число
     * @param times количество повторений
     * @return массив целых чисел повторённых значений
     */
    public static int[] repeat(int number, int times) {
        times = Math.clamp(times, 0, Integer.MAX_VALUE);
        int[] data = new int[times];
        for (int i = 0; i < times; i++) {
            data[i] = number;
        }
        return data;
    }

    /**
     * Повторение числа указанное количество раз.
     * @author Namespace Stedd
     * @param number повторяемое большое целое число
     * @param times количество повторений
     * @return массив больших целых чисел повторённых значений
     */
    public static long[] repeat(long number, int times) {
        times = Math.clamp(times, 0, Integer.MAX_VALUE);
        long[] data = new long[times];
        for (int i = 0; i < times; i++) {
            data[i] = number;
        }
        return data;
    }

    /**
     * Повторение числа указанное количество раз.
     * @author Namespace Stedd
     * @param number повторяемое дробное число
     * @param times количество повторений
     * @return массив дробных чисел повторённых значений
     */
    public static float[] repeat(float number, int times) {
        times = Math.clamp(times, 0, Integer.MAX_VALUE);
        float[] data = new float[times];
        for (int i = 0; i < times; i++) {
            data[i] = number;
        }
        return data;
    }

    /**
     * Повторение числа указанное количество раз.
     * @author Namespace Stedd
     * @param number повторяемое дробное число двойной точности
     * @param times количество повторений
     * @return массив дробных чисел двойной точности повторённых значений
     */
    public static double[] repeat(double number, int times) {
        times = Math.clamp(times, 0, Integer.MAX_VALUE);
        double[] data = new double[times];
        for (int i = 0; i < times; i++) {
            data[i] = number;
        }
        return data;
    }

    /**
     * Повторение текущего значения указанное количество раз.
     * @author Namespace Stedd
     * @param times количество повторений
     * @return массив байт повторённых значений
     */
    public double[] repeat(int times) {
        return repeat(this.getNumber(0), times);
    }

}
