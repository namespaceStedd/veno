package namespace.stedd.data.type.number;

import namespace.stedd.data.type.ExoCollection;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Математический центр вычислений.
 * @author Namespace Stedd
 */
public class Math {

    /**
     * Округление числа по правилам математики с указанной точностью.
     * @author Namespace Stedd
     * @param number округляемое число
     * @param accuracy точность округления
     * @return округлённое число
     */
    public static double round(double number, int accuracy) {
        if (accuracy < 0) {
            accuracy = 0;
        }
        return java.lang.Math.round(number * java.lang.Math.pow(10, accuracy)) / java.lang.Math.pow(10, accuracy);
    }

    /**
     * Получение степени числа по его основанию.
     * @author Namespace Stedd
     * @param number число
     * @param basis основание степени
     * @return степень числа
     */
    public static Number degreeOf(double number, double basis) {
        if (basis == 1) {
            if (number == 1) {
                // TODO: добавить неопределённость
            }
        }
        if (number <= 0 || basis <= 0 || basis == 1) {
            // TODO: добавить неопределённость
            // TODO: добавить тип числа, где будет и неопределённость, и комплексность, и пр. структуры
            return null;
        }
        double degree = 0;
        // Вычисление целой части степени
        for (double leftover = number; leftover >= basis; degree++, leftover /= basis) {
            // System.out.println(number);
        }
        // System.out.println(number);
        for (int i = 0; i < 8; i++) {
            double fraction = java.lang.Math.pow(10, -(i + 1));
            for (int digit = 0; digit <= 9; digit++) {
                double pow = degree + digit * fraction;
                if (java.lang.Math.pow(basis, pow) > number) {
                    degree += (digit - 1) * fraction;
                    break;
                }
            }
        }
        return degree;
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(byte... data) {
        return getDataPercents(0, data);
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param accuracy точность процентилей
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(int accuracy, byte... data) {
        return getDataPercents(accuracy, ExoCollection.toDoubleArray(data));
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(short... data) {
        return getDataPercents(0, data);
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param accuracy точность процентилей
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(int accuracy, short... data) {
        return getDataPercents(accuracy, ExoCollection.toDoubleArray(data));
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(int... data) {
        return getDataPercents(0, data);
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param accuracy точность процентилей
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(int accuracy, int... data) {
        return getDataPercents(accuracy, ExoCollection.toDoubleArray(data));
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(long... data) {
        return getDataPercents(0, data);
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param accuracy точность процентилей
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(int accuracy, long... data) {
        return getDataPercents(accuracy, ExoCollection.toDoubleArray(data));
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(float... data) {
        return getDataPercents(0, data);
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param accuracy точность процентилей
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(int accuracy, float... data) {
        return getDataPercents(accuracy, ExoCollection.toDoubleArray(data));
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(double... data) {
        return getDataPercents(0, data);
    }

    /**
     * Получение процентного соотношения данных к общей сумме выборки.
     * @author Namespace Stedd
     * @param accuracy точность процентилей
     * @param data данные выборки
     * @return процентные соотношения данных
     */
    public static double[] getDataPercents(int accuracy, double... data) {
        // Правка неотрицательности точности
        if (accuracy < 0) {
            accuracy = 0;
        }

        // Поиск индекса максимального числа, чтобы избавить это число от лишних значений
        int maxNumberIndex = maxNumberIndex(data);

        // Поиск минимального числа и сдвиг всех элементов на его абсолютное значение в случае, если оно отрицательное
        double minimalNumber = data[minNumberIndex(data)];
        BigDecimal[] bigData = summarize(minimalNumber < 0 ? java.lang.Math.abs(minimalNumber) : 0, data);

        // Определение массива процентов
        double[] percents = new double[bigData.length];

        // Определение сумм: основная и сумма без максимального числа
        BigDecimal sum = BigDecimal.ZERO;
        double noMaxPercentSum = 0;
        for (BigDecimal number : bigData) {
            sum = sum.add(number);
        }

        // Нахождение соотношений чисел, кроме максимального
        for (int i = 0; i < percents.length; i++) {
            if (i != maxNumberIndex) {
                double percent = round(100 * bigData[i].divide(sum, 2 + accuracy, RoundingMode.HALF_UP).doubleValue(), accuracy);
                percents[i] = percent;
                noMaxPercentSum += percent;
            }
        }

        // Определение последнего процента числа
        percents[maxNumberIndex] = round(100 - noMaxPercentSum, accuracy);

        // Возвращение процентов
        return percents;
    }

    /**
     * Просуммировать каждое значение массива на указанное слагаемое.
     * @author Namespace Stedd
     * @param summand слагаемое
     * @param array массив
     * @return массив просуммированных слагаемых
     */
    public static BigDecimal[] summarize(double summand, double... array) {
        BigDecimal[] summarizedArray = new BigDecimal[array.length];
        for (int i = 0; i < summarizedArray.length; i++) {
            summarizedArray[i] = BigDecimal.valueOf(array[i]).add(BigDecimal.valueOf(summand));
        }
        return summarizedArray;
    }

    /**
     * Получение индекса минимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив байт
     * @return индекс минимального элемента
     */
    public static int minNumberIndex(byte... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            byte number = numbers[i];
            if (number < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Получение индекса минимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив малых целых чисел
     * @return индекс минимального элемента
     */
    public static int minNumberIndex(short... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            short number = numbers[i];
            if (number < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Получение индекса минимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив целых чисел
     * @return индекс минимального элемента
     */
    public static int minNumberIndex(int... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Получение индекса минимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив больших целых чисел
     * @return индекс минимального элемента
     */
    public static int minNumberIndex(long... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if (number < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Получение индекса минимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив дробных чисел
     * @return индекс минимального элемента
     */
    public static int minNumberIndex(float... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            float number = numbers[i];
            if (number < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Получение индекса минимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив дробных чисел двойной точности
     * @return индекс минимального элемента
     */
    public static int minNumberIndex(double... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int minIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            if (number < numbers[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Получение индекса максимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив байт
     * @return индекс максимального элемента
     */
    public static int maxNumberIndex(byte... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            byte number = numbers[i];
            if (number > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Получение индекса максимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив малых целых чисел
     * @return индекс максимального элемента
     */
    public static int maxNumberIndex(short... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            short number = numbers[i];
            if (number > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Получение индекса максимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив целых чисел
     * @return индекс максимального элемента
     */
    public static int maxNumberIndex(int... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Получение индекса максимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив больших целых чисел
     * @return индекс максимального элемента
     */
    public static int maxNumberIndex(long... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if (number > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Получение индекса максимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив дробных чисел
     * @return индекс максимального элемента
     */
    public static int maxNumberIndex(float... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            float number = numbers[i];
            if (number > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Получение индекса максимального числа в массиве.
     * @author Namespace Stedd
     * @param numbers массив дробных чисел двойной точности
     * @return индекс максимального элемента
     */
    public static int maxNumberIndex(double... numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            double number = numbers[i];
            if (number > numbers[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Подсчёт суммы элементов массива.
     * @author Namespace Stedd
     * @param numbers массив байт
     * @return сумма элементов массива
     */
    public static double sum(byte... numbers) {
        return sum(ExoCollection.toDoubleArray(numbers));
    }

    /**
     * Подсчёт суммы элементов массива.
     * @author Namespace Stedd
     * @param numbers массив малых целых чисел
     * @return сумма элементов массива
     */
    public static double sum(short... numbers) {
        return sum(ExoCollection.toDoubleArray(numbers));
    }

    /**
     * Подсчёт суммы элементов массива.
     * @author Namespace Stedd
     * @param numbers массив целых чисел
     * @return сумма элементов массива
     */
    public static double sum(int... numbers) {
        return sum(ExoCollection.toDoubleArray(numbers));
    }

    /**
     * Подсчёт суммы элементов массива.
     * @author Namespace Stedd
     * @param numbers массив больших целых чисел
     * @return сумма элементов массива
     */
    public static double sum(long... numbers) {
        return sum(ExoCollection.toDoubleArray(numbers));
    }

    /**
     * Подсчёт суммы элементов массива.
     * @author Namespace Stedd
     * @param numbers массив дробных чисел
     * @return сумма элементов массива
     */
    public static double sum(float... numbers) {
        return sum(ExoCollection.toDoubleArray(numbers));
    }

    /**
     * Подсчёт суммы элементов массива.
     * @author Namespace Stedd
     * @param numbers массив дробных чисел двойной точности
     * @return сумма элементов массива
     */
    public static double sum(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

}
