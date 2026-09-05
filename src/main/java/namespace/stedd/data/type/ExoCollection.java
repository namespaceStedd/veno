package namespace.stedd.data.type;

import namespace.stedd.data.Converter;
import namespace.stedd.data.adapter.TypeConverterRule;
import namespace.stedd.data.regex.CharRange;
import namespace.stedd.data.type.number.*;
import namespace.stedd.data.type.number.Math;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static namespace.stedd.data.type.ExoNumber.random;

/**
 * Расширенное представление коллекций.
 * @author Namespace Stedd
 */
public class ExoCollection {

    /**
     * Оборачивание массива примитивного логического типа.
     * @author Namespace Stedd
     * @param array массив примитивного логического типа
     * @return обёрнутый массив
     */
    public static Boolean[] wrap(boolean[] array) {
        Boolean[] booleans = new Boolean[array.length];
        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = array[i];
        }
        return booleans;
    }

    /**
     * Оборачивание массива примитивных символов.
     * @author Namespace Stedd
     * @param array массив примитивных символов
     * @return обёрнутый массив
     */
    public static Character[] wrap(char[] array) {
        Character[] chars = new Character[array.length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = array[i];
        }
        return chars;
    }

    /**
     * Оборачивание массива примитивных больших целых чисел.
     * @author Namespace Stedd
     * @param array массив примитивных больших целых чисел
     * @return обёрнутый массив
     */
    public static Long[] wrap(long[] array) {
        Long[] longs = new Long[array.length];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = array[i];
        }
        return longs;
    }

    /**
     * Оборачивание массива примитивных целых чисел.
     * @author Namespace Stedd
     * @param array массив примитивных целых чисел
     * @return обёрнутый массив
     */
    public static Integer[] wrap(int[] array) {
        Integer[] ints = new Integer[array.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = array[i];
        }
        return ints;
    }

    /**
     * Оборачивание массива примитивных малых целых чисел.
     * @author Namespace Stedd
     * @param array массив примитивных малых целых чисел
     * @return обёрнутый массив
     */
    public static Short[] wrap(short[] array) {
        Short[] shorts = new Short[array.length];
        for (int i = 0; i < shorts.length; i++) {
            shorts[i] = array[i];
        }
        return shorts;
    }

    /**
     * Оборачивание массива примитивных байт.
     * @author Namespace Stedd
     * @param array массив примитивных байт
     * @return обёрнутый массив
     */
    public static Byte[] wrap(byte[] array) {
        Byte[] bytes = new Byte[array.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = array[i];
        }
        return bytes;
    }

    /**
     * Оборачивание массива примитивных дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param array массив примитивных дробных чисел двойной точности
     * @return обёрнутый массив
     */
    public static Double[] wrap(double[] array) {
        Double[] doubles = new Double[array.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = array[i];
        }
        return doubles;
    }

    /**
     * Оборачивание массива примитивных дробных чисел.
     * @author Namespace Stedd
     * @param array массив примитивных дробных чисел
     * @return обёрнутый массив
     */
    public static Float[] wrap(float[] array) {
        Float[] floats = new Float[array.length];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = array[i];
        }
        return floats;
    }

    /**
     * Преобразование массива элементов одного типа в массив элементов другого типа.
     * @author Namespace Stedd
     * @param sourceArray массив элементов первого типа
     * @param e2 класс элементов конечного массива
     * @param rule правило конвертирования одного типа в другой
     * @return массив элементов второго типа
     * @param <E1> тип элементов исходного массива
     * @param <E2> тип элементов конечного массива
     */
    public static <E1, E2> E2[] convert(E1[] sourceArray, Class<E2> e2, TypeConverterRule<E1, E2> rule) {
        // noinspection unchecked
        E2[] newArray = (E2[]) Array.newInstance(e2, sourceArray.length);
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = rule.convert(sourceArray[i]);
        }
        return newArray;
    }

    /**
     * Преобразование списка в массив.
     * @author Namespace Stedd
     * @param list список объектов
     * @param t класс выходного объекта
     * @return массив
     * @param <T> универсальный параметр типа
     */
    public static <T> T[] toArray(List<T> list, Class<T> t) {
        // noinspection unchecked
        T[] array = (T[]) Array.newInstance(t, list.size());
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Преобразование массива байт в массив малых целых чисел.
     * @author Namespace Stedd
     * @param array массив байт
     * @return массив малых целых чисел
     */
    public static short[] toShortArray(byte... array) {
        short[] shorts = new short[array.length];
        for (int i = 0; i < shorts.length; i++) {
            shorts[i] = array[i];
        }
        return shorts;
    }

    /**
     * Преобразование массива байт в массив целых чисел.
     * @author Namespace Stedd
     * @param array массив байт
     * @return массив целых чисел
     */
    public static int[] toIntegerArray(byte... array) {
        int[] ints = new int[array.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = array[i];
        }
        return ints;
    }

    /**
     * Преобразование массива малых целых чисел в массив целых чисел.
     * @author Namespace Stedd
     * @param array массив малых целых чисел
     * @return массив целых чисел
     */
    public static int[] toIntegerArray(short... array) {
        int[] ints = new int[array.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = array[i];
        }
        return ints;
    }

    /**
     * Преобразование массива байт в массив больших целых чисел.
     * @author Namespace Stedd
     * @param array массив байт
     * @return массив больших целых чисел
     */
    public static long[] toLongArray(byte... array) {
        long[] longs = new long[array.length];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = array[i];
        }
        return longs;
    }

    /**
     * Преобразование массива малых целых чисел в массив больших целых чисел.
     * @author Namespace Stedd
     * @param array массив малых целых чисел
     * @return массив больших целых чисел
     */
    public static long[] toLongArray(short... array) {
        long[] longs = new long[array.length];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = array[i];
        }
        return longs;
    }

    /**
     * Преобразование массива целых чисел в массив больших целых чисел.
     * @author Namespace Stedd
     * @param array массив целых чисел
     * @return массив больших целых чисел
     */
    public static long[] toLongArray(int... array) {
        long[] longs = new long[array.length];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = array[i];
        }
        return longs;
    }

    /**
     * Преобразование массива байт в массив дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param array массив байт
     * @return массив дробных чисел двойной точности
     */
    public static double[] toDoubleArray(byte... array) {
        double[] doubles = new double[array.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = array[i];
        }
        return doubles;
    }

    /**
     * Преобразование массива малых целых чисел в массив дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param array массив малых целых чисел
     * @return массив дробных чисел двойной точности
     */
    public static double[] toDoubleArray(short... array) {
        double[] doubles = new double[array.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = array[i];
        }
        return doubles;
    }

    /**
     * Преобразование массива целых чисел в массив дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param array массив целых чисел
     * @return массив дробных чисел двойной точности
     */
    public static double[] toDoubleArray(int... array) {
        double[] doubles = new double[array.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = array[i];
        }
        return doubles;
    }

    /**
     * Преобразование массива больших целых чисел в массив дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param array массив больших целых чисел
     * @return массив дробных чисел двойной точности
     */
    public static double[] toDoubleArray(long... array) {
        double[] doubles = new double[array.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = array[i];
        }
        return doubles;
    }

    /**
     * Преобразование массива дробных чисел в массив дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param array массив дробных чисел
     * @return массив дробных чисел двойной точности
     */
    public static double[] toDoubleArray(float... array) {
        double[] doubles = new double[array.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = array[i];
        }
        return doubles;
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
     * Преобразование массива логического типа данных в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив логического типа данных
     * @param delimiter разделитель
     * @return строчный массив
     */
    public static String toArrayString(boolean[] array, String delimiter) {
        Boolean[] booleans = wrap(array);
        return ExoString.toArrayString(booleans, delimiter);
    }

    /**
     * Преобразование массива символов в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив символов
     * @param delimiter разделитель
     * @return строчный массив
     */
    public static String toArrayString(char[] array, String delimiter) {
        Character[] chars = wrap(array);
        return ExoString.toArrayString(chars, delimiter);
    }

    /**
     * Преобразование массива больших целых чисел в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив больших целых чисел
     * @param delimiter разделитель
     * @return строчный массив
     */
    public static String toArrayString(long[] array, String delimiter) {
        Long[] longs = wrap(array);
        return ExoString.toArrayString(longs, delimiter);
    }

    /**
     * Преобразование массива целых чисел в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив целых чисел
     * @param delimiter разделитель
     * @return строчный массив
     */
    public static String toArrayString(int[] array, String delimiter) {
        Integer[] ints = wrap(array);
        return ExoString.toArrayString(ints, delimiter);
    }

    /**
     * Преобразование массива малых целых чисел в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив малых целых чисел
     * @param delimiter разделитель
     * @return строчный массив
     */
    public static String toArrayString(short[] array, String delimiter) {
        Short[] shorts = wrap(array);
        return ExoString.toArrayString(shorts, delimiter);
    }

    /**
     * Преобразование массива байт в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив байт
     * @param delimiter разделитель
     * @return строчный массив
     */
    public static String toArrayString(byte[] array, String delimiter) {
        Byte[] bytes = wrap(array);
        return ExoString.toArrayString(bytes, delimiter);
    }

    /**
     * Преобразование массива дробных чисел двойной точности в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив дробных чисел двойной точности
     * @param delimiter разделитель
     * @return строчный массив
     */
    public static String toArrayString(double[] array, String delimiter) {
        Double[] doubles = wrap(array);
        return ExoString.toArrayString(doubles, delimiter);
    }

    /**
     * Преобразование массива дробных чисел в строку с разделителем.
     * @author Namespace Stedd
     * @param array массив дробных чисел
     * @param delimiter разделитель
     * @return строчный массив
     */
    public static String toArrayString(float[] array, String delimiter) {
        Float[] floats = wrap(array);
        return ExoString.toArrayString(floats, delimiter);
    }

    /**
     * Преобразование списка элементов одного типа в список элементов другого типа.
     * @author Namespace Stedd
     * @param sourceList список элементов первого типа
     * @param rule правило конвертирования одного типа в другой
     * @return список элементов второго типа
     * @param <E1> тип элементов исходного списка
     * @param <E2> тип элементов конечного списка
     */
    public static <E1, E2> List<E2> convert(List<E1> sourceList, TypeConverterRule<E1, E2> rule) {
        List<E2> newList = new ArrayList<>();
        for (E1 e1 : sourceList) {
            newList.add(rule.convert(e1));
        }
        return newList;
    }

    /**
     * Объединение массивов логического типа данных в один.
     * @author Namespace Stedd
     * @param firstArray первый массив логического типа данных
     * @param secondArray второй массив логического типа данных
     * @return объединённый массив логического типа данных
     */
    public static boolean[] mergeArrays(boolean[] firstArray, boolean... secondArray) {
        boolean[] superArray = new boolean[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов символов в один.
     * @author Namespace Stedd
     * @param firstArray первый массив символов
     * @param secondArray второй массив символов
     * @return объединённый массив символов
     */
    public static char[] mergeArrays(char[] firstArray, char... secondArray) {
        char[] superArray = new char[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов байт в один.
     * @author Namespace Stedd
     * @param firstArray первый массив байт
     * @param secondArray второй массив байт
     * @return объединённый массив байт
     */
    public static byte[] mergeArrays(byte[] firstArray, byte... secondArray) {
        byte[] superArray = new byte[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов малых целых чисел в один.
     * @author Namespace Stedd
     * @param firstArray первый массив малых целых чисел
     * @param secondArray второй массив малых целых чисел
     * @return объединённый массив малых целых чисел
     */
    public static short[] mergeArrays(short[] firstArray, short... secondArray) {
        short[] superArray = new short[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов целых чисел в один.
     * @author Namespace Stedd
     * @param firstArray первый массив целых чисел
     * @param secondArray второй массив целых чисел
     * @return объединённый массив целых чисел
     */
    public static int[] mergeArrays(int[] firstArray, int... secondArray) {
        int[] superArray = new int[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов больших целых чисел в один.
     * @author Namespace Stedd
     * @param firstArray первый массив больших целых чисел
     * @param secondArray второй массив больших целых чисел
     * @return объединённый массив больших целых чисел
     */
    public static long[] mergeArrays(long[] firstArray, long... secondArray) {
        long[] superArray = new long[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов дробных чисел в один.
     * @author Namespace Stedd
     * @param firstArray первый массив дробных чисел
     * @param secondArray второй массив дробных чисел
     * @return объединённый массив дробных чисел
     */
    public static float[] mergeArrays(float[] firstArray, float... secondArray) {
        float[] superArray = new float[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов дробных чисел двойной точности в один.
     * @author Namespace Stedd
     * @param firstArray первый массив дробных чисел двойной точности
     * @param secondArray второй массив дробных чисел двойной точности
     * @return объединённый массив дробных чисел двойной точности
     */
    public static double[] mergeArrays(double[] firstArray, double... secondArray) {
        double[] superArray = new double[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов объектов в один.
     * @author Namespace Stedd
     * @param firstArray первый массив объектов
     * @param secondArray второй массив объектов
     * @return объединённый массив объектов
     * @param <T> универсальный параметр типа
     */
    @SafeVarargs
    public static <T> T[] mergeArrays(T[] firstArray, T... secondArray) {
        Class<?> tClass = firstArray.length > 0 ? firstArray[0].getClass() :
                secondArray.length > 0 ? secondArray[0].getClass() :
                        null;
        if (tClass == null) {
            return firstArray;
        }
        // noinspection unchecked
        T[] superArray = (T[]) Array.newInstance(tClass, firstArray.length + secondArray.length);
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Объединение массивов в один.
     * @author Namespace Stedd
     * @param firstArray первый массив
     * @param secondArray второй массив
     * @param t класс выходного обхекта
     * @return объединённый массив
     * @param <T> универсальный параметр типа
     */
    public static <T> T[] mergeArrays(T[] firstArray, T[] secondArray, Class<T> t) {
        // noinspection unchecked
        T[] superArray = (T[]) Array.newInstance(t, firstArray.length + secondArray.length);
        System.arraycopy(firstArray, 0, superArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, superArray, firstArray.length, secondArray.length);
        return superArray;
    }

    /**
     * Создание массива случайных логических типов данных указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @return массив случайных логических типов данных
     */
    public static boolean[] generateBooleanArray(int length) {
        boolean[] bools = new boolean[length];
        for (int i = 0; i < bools.length; i++) {
            bools[i] = random.nextBoolean();
        }
        return bools;
    }

    /**
     * Создание массива случайных символов указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @return массив случайных символов
     */
    public static char[] generateCharArray(int length) {
        return generateCharArray(Character.MIN_VALUE, Character.MAX_VALUE, length);
    }

    /**
     * Создание массива случайных символов указанной длины.
     * @author Namespace Stedd
     * @param from начальный символ
     * @param to конечный символ
     * @param length длина массива
     * @return массив случайных символов
     */
    public static char[] generateCharArray(int from, int to, int length) {
        return generateCharArray((char) from, (char) to, length);
    }

    /**
     * Создание массива случайных символов указанной длины.
     * @author Namespace Stedd
     * @param from начальный символ
     * @param to конечный символ
     * @param length длина массива
     * @return массив случайных символов
     */
    public static char[] generateCharArray(char from, char to, int length) {
//        if (from > to) {
//            char temp = from;
//            from = to;
//            to = temp;
//        }
        char[] chars = new char[length];
        if (from == to) {
            Arrays.fill(chars, from);
            return chars;
        }
        else if (to < from) {
            return chars;
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (random.nextInt(to - from) + from);
        }
        return chars;
    }

    /**
     * Создание массива случайных символов указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param length длина массива
     * @return массив случайных символов
     */
    public static char[] generateCharArray(CharRange range, int length) {
        return generateCharArray(range.min(), range.max(), length);
    }

    /**
     * Создание массива случайных байт указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static byte[] generateByteArray(int length) {
        return generateByteArray(Byte.MIN_VALUE, Byte.MAX_VALUE, length);
    }

    /**
     * Создание массива случайных байт указанной длины.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static byte[] generateByteArray(byte min, byte max, int length) {
        byte[] bytes = new byte[length];
        if (max == min) {
            Arrays.fill(bytes, min);
            return bytes;
        }
        else if (max < min) {
            return bytes;
        }
        if (max < Byte.MAX_VALUE) {
            max++;
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) random.nextInt(min, max);
        }
        return bytes;
    }

    /**
     * Создание массива случайных байт указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static byte[] generateByteArray(ByteRange range, int length) {
        return generateByteArray(range.min(), range.max(), length);
    }

    /**
     * Создание массива случайных малых целых чисел указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static short[] generateShortArray(int length) {
        return generateShortArray(Short.MIN_VALUE, Short.MAX_VALUE, length);
    }

    /**
     * Создание массива случайных малых целых чисел указанной длины.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static short[] generateShortArray(short min, short max, int length) {
        short[] shorts = new short[length];
        if (max == min) {
            Arrays.fill(shorts, min);
            return shorts;
        }
        else if (max < min) {
            return shorts;
        }
        if (max < Short.MAX_VALUE) {
            max++;
        }
        for (int i = 0; i < shorts.length; i++) {
            shorts[i] = (short) random.nextInt(min, max);
        }
        return shorts;
    }

    /**
     * Создание массива случайных малых целых чисел указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static short[] generateShortArray(ShortRange range, int length) {
        return generateShortArray(range.min(), range.max(), length);
    }

    /**
     * Создание массива случайных целых чисел указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static int[] generateIntegerArray(int length) {
        return generateIntegerArray(Integer.MIN_VALUE, Integer.MAX_VALUE, length);
    }

    /**
     * Создание массива случайных целых чисел указанной длины.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static int[] generateIntegerArray(int min, int max, int length) {
        int[] ints = new int[length];
        if (max == min) {
            Arrays.fill(ints, min);
            return ints;
        }
        else if (max < min) {
            return ints;
        }
        if (max < Integer.MAX_VALUE) {
            max++;
        }
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(min, max);
        }
        return ints;
    }

    /**
     * Создание массива случайных целых чисел указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static int[] generateIntegerArray(IntRange range, int length) {
        return generateIntegerArray(range.min(), range.max(), length);
    }

    /**
     * Создание массива случайных больших целых чисел указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static long[] generateLongArray(int length) {
        return generateLongArray(Long.MIN_VALUE, Long.MAX_VALUE, length);
    }

    /**
     * Создание массива случайных больших целых чисел указанной длины.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static long[] generateLongArray(long min, long max, int length) {
        long[] longs = new long[length];
        if (max == min) {
            Arrays.fill(longs, min);
            return longs;
        }
        else if (max < min) {
            return longs;
        }
        if (max < Long.MAX_VALUE) {
            max++;
        }
        for (int i = 0; i < longs.length; i++) {
            longs[i] = random.nextLong(min, max);
        }
        return longs;
    }

    /**
     * Создание массива случайных больших целых чисел указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static long[] generateLongArray(LongRange range, int length) {
        return generateLongArray(range.min(), range.max(), length);
    }

    /**
     * Создание массива случайных дробных чисел указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static float[] generateFloatArray(int length) {
        return generateFloatArray(-Float.MAX_VALUE, Float.MAX_VALUE, length);
    }

    /**
     * Создание массива случайных дробных чисел указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @param accuracy точность округления
     * @return массив случайных чисел
     */
    public static float[] generateFloatArray(int accuracy, int length) {
        return generateFloatArray(-Float.MAX_VALUE, Float.MAX_VALUE, accuracy, length);
    }

    /**
     * Создание массива случайных дробных чисел указанной длины.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static float[] generateFloatArray(float min, float max, int length) {
        return generateFloatArray(FloatRange.create(min, max), length);
    }

    /**
     * Создание массива случайных дробных чисел указанной длины.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @param accuracy точность округления
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static float[] generateFloatArray(float min, float max, int accuracy, int length) {
        return generateFloatArray(FloatRange.create(min, max), accuracy, length);
    }

    /**
     * Создание массива случайных дробных чисел указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static float[] generateFloatArray(FloatRange range, int length) {
        return generateFloatArray(range, -1, length);
    }

    /**
     * Создание массива случайных дробных чисел указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param accuracy точность округления
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static float[] generateFloatArray(FloatRange range, int accuracy, int length) {
        float[] floats = new float[length];
        BigDecimal min = range.bigMin(),
                max = range.bigMax();
        if (max.compareTo(min) == 0) {
            Arrays.fill(floats, max.floatValue());
            return floats;
        }
        if (max.compareTo(min) < 0) {
            return floats;
        }
        if (max.compareTo(BigDecimal.valueOf(Float.MAX_VALUE)) < 0) {
            max = max.add(BigDecimal.valueOf(Float.MIN_VALUE));
        }
        for (int i = 0; i < floats.length; i++) {
            floats[i] = Math.round(random.nextFloat(min.floatValue(), max.floatValue()), accuracy);
        }
        return floats;
    }

    /**
     * Создание массива случайных дробных чисел двойной точности указанной длины.
     * @author Namespace Stedd
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static double[] generateDoubleArray(int length) {
        return generateDoubleArray(-Double.MAX_VALUE, Double.MAX_VALUE, length);
    }

    /**
     * Создание массива случайных дробных чисел двойной точности указанной длины.
     * @author Namespace Stedd
     * @param accuracy точность округления
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static double[] generateDoubleArray(int accuracy, int length) {
        return generateDoubleArray(-Double.MAX_VALUE, Double.MAX_VALUE, accuracy, length);
    }

    /**
     * Создание массива случайных дробных чисел двойной точности указанной длины.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static double[] generateDoubleArray(double min, double max, int length) {
        return generateDoubleArray(DoubleRange.create(min, max), length);
    }

    /**
     * Создание массива случайных дробных чисел двойной точности указанной длины.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @param accuracy точность округления
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static double[] generateDoubleArray(double min, double max, int accuracy, int length) {
        return generateDoubleArray(DoubleRange.create(min, true, max, true), accuracy, length);
    }

    /**
     * Создание массива случайных дробных чисел двойной точности указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static double[] generateDoubleArray(DoubleRange range, int length) {
        return generateDoubleArray(range, -1, length);
    }

    /**
     * Создание массива случайных дробных чисел двойной точности указанной длины.
     * @author Namespace Stedd
     * @param range диапазон значений
     * @param accuracy точность округления
     * @param length длина массива
     * @return массив случайных чисел
     */
    public static double[] generateDoubleArray(DoubleRange range, int accuracy, int length) {
        double[] doubles = new double[length];
        BigDecimal min = range.bigMin(),
                max = range.bigMax();
        if (max.compareTo(min) == 0) {
            Arrays.fill(doubles, max.doubleValue());
            return doubles;
        }
        if (max.compareTo(min) < 0) {
            return doubles;
        }
        if (max.compareTo(BigDecimal.valueOf(Double.MAX_VALUE)) < 0) {
            max = max.add(BigDecimal.valueOf(Double.MIN_VALUE));
        }
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Math.round(random.nextDouble(min.doubleValue(), max.doubleValue()), accuracy);
        }
        return doubles;
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param array массив данных
     * @return массив данных указанной длины
     */
    public static boolean[] leadToLength(int length, boolean... array) {
        if (array.length < length) {
            return mergeArrays(array, ExoBoolean.repeat(false, length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param array массив данных
     * @return массив данных указанной длины
     */
    public static char[] leadToLength(int length, char... array) {
        if (array.length < length) {
            return mergeArrays(array, ExoString.repeat(' ', length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param array массив данных
     * @return массив данных указанной длины
     */
    public static byte[] leadToLength(int length, byte... array) {
        if (array.length < length) {
            return mergeArrays(array, ExoNumber.repeat((byte) 0, length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param array массив данных
     * @return массив данных указанной длины
     */
    public static short[] leadToLength(int length, short... array) {
        if (array.length < length) {
            return mergeArrays(array, ExoNumber.repeat((short) 0, length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param array массив данных
     * @return массив данных указанной длины
     */
    public static int[] leadToLength(int length, int... array) {
        if (array.length < length) {
            return mergeArrays(array, ExoNumber.repeat(0, length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param array массив данных
     * @return массив данных указанной длины
     */
    public static long[] leadToLength(int length, long... array) {
        if (array.length < length) {
            return mergeArrays(array, ExoNumber.repeat(0L, length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param array массив данных
     * @return массив данных указанной длины
     */
    public static float[] leadToLength(int length, float... array) {
        if (array.length < length) {
            return mergeArrays(array, ExoNumber.repeat(0.f, length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param array массив данных
     * @return массив данных указанной длины
     */
    public static double[] leadToLength(int length, double... array) {
        if (array.length < length) {
            return mergeArrays(array, ExoNumber.repeat(0., length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Приведение массива к указанной длине.
     * @author Namespace Stedd
     * @param length длина массива
     * @param defaultValue значение по умолчанию
     * @param array массив данных
     * @return массив данных указанной длины
     * @param <T> универсальный параметр типа
     */
    @SafeVarargs
    public static <T> T[] leadToLength(int length, T defaultValue, T... array) {
        if (array.length < length) {
            return mergeArrays(array, repeat(defaultValue, length - array.length));
        }
        else if (array.length > length) {
            return Arrays.copyOfRange(array, 0, length);
        }
        else {
            return array;
        }
    }

    /**
     * Повторение объекта указанное количество раз.
     * @author Namespace Stedd
     * @param t повторяемый объект
     * @param times количество повторений
     * @return массив объектов повторённых значений
     * @param <T> универсальный параметр типа
     */
    public static <T> T[] repeat(T t, int times) {
        times = java.lang.Math.clamp(times, 0, Integer.MAX_VALUE);
        // noinspection unchecked
        T[] data = (T[]) (Array.newInstance(t.getClass(), times));
        for (int i = 0; i < times; i++) {
            data[i] = t;
        }
        return data;
    }

    /**
     * Преобразование массива в список.
     * @author Namespace Stedd
     * @param array массив
     * @return список
     * @param <T> универсальный параметр типа
     */
    @SafeVarargs
    public static <T> List<T> toList(T... array) {
        List<T> list = (List<T>) new ArrayList<T>();
        list.addAll(Arrays.asList(array));
        return list;
    }

    /**
     * Преобразование массива логического типа данных в список.
     * @author Namespace Stedd
     * @param array массив логического типа данных
     * @return список
     */
    public static List<Boolean> toList(boolean... array) {
        Boolean[] booleans = wrap(array);
        return toList(booleans);
    }

    /**
     * Преобразование массива символов в список.
     * @author Namespace Stedd
     * @param array массив символов
     * @return список
     */
    public static List<Character> toList(char... array) {
        Character[] chars = wrap(array);
        return toList(chars);
    }

    /**
     * Преобразование массива больших целых чисел в список.
     * @author Namespace Stedd
     * @param array массив больших целых чисел
     * @return список
     */
    public static List<Long> toList(long... array) {
        Long[] longs = wrap(array);
        return toList(longs);
    }

    /**
     * Преобразование массива целых чисел в список.
     * @author Namespace Stedd
     * @param array массив целых чисел
     * @return список
     */
    public static List<Integer> toList(int... array) {
        Integer[] ints = wrap(array);
        return toList(ints);
    }

    /**
     * Преобразование массива малых целых чисел в список.
     * @author Namespace Stedd
     * @param array массив малых целых чисел
     * @return список
     */
    public static List<Short> toList(short... array) {
        Short[] shorts = wrap(array);
        return toList(shorts);
    }

    /**
     * Преобразование массива байт в список.
     * @author Namespace Stedd
     * @param array массив байт
     * @return список
     */
    public static List<Byte> toList(byte... array) {
        Byte[] bytes = wrap(array);
        return toList(bytes);
    }

    /**
     * Преобразование массива дробных чисел двойной точности в список.
     * @author Namespace Stedd
     * @param array массив дробных чисел двойной точности
     * @return список
     */
    public static List<Double> toList(double... array) {
        Double[] doubles = wrap(array);
        return toList(doubles);
    }

    /**
     * Преобразование массива дробных чисел в список.
     * @author Namespace Stedd
     * @param array массив дробных чисел
     * @return список
     */
    public static List<Float> toList(float... array) {
        Float[] floats = wrap(array);
        return toList(floats);
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
        return ExoString.toListString(list, delimiter);
    }

    /**
     * Преобразование карты в строку с разделителем.
     * @author Namespace Stedd
     * @param map карта
     * @param delimiter разделитель
     * @return строчное представление списка
     * @param <K> универсальный типовой ключ
     * @param <V> универсальное типовое значение
     */
    public static <K, V> String toMapString(Map<K, V> map, String delimiter) {
        return toMapString(map, delimiter, "\n");
    }

    /**
     * Преобразование карты в строку с разделителем.
     * @author Namespace Stedd
     * @param map карта
     * @param keyValueDelimiter разделитель пары "ключ-значение"
     * @param pairDelimiter разделитель пар
     * @return строчное представление списка
     * @param <K> универсальный типовой ключ
     * @param <V> универсальное типовое значение
     */
    public static <K, V> String toMapString(Map<K, V> map, String keyValueDelimiter, String pairDelimiter) {
        StringBuilder string = new StringBuilder();
        for (K k : map.keySet()) {
            string.append(k.toString()).append(keyValueDelimiter).append(map.get(k)).append(pairDelimiter);
        }
        return (!string.isEmpty() ? string.substring(0, string.length() - pairDelimiter.length()) : string).toString();
    }

    /**
     * Преобразование массива в JSON-массив.
     * @author Namespace Stedd
     * @param array массив
     * @return массив JSON-объектов
     * @param <T> универсальный параметр типа
     */
    @SafeVarargs
    public static <T> String toJsonArray(T... array) {
        return Converter.json.toJson(array);
    }

}
