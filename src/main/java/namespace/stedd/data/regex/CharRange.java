package namespace.stedd.data.regex;

import namespace.stedd.data.lang.Letter;
import namespace.stedd.data.type.number.Range;

import java.math.BigInteger;

/**
 * Диапазон символов.
 * @author Namespace Stedd
 */
public class CharRange extends Range<Character> {

    @Deprecated(since = "1.7", forRemoval = true)
    private char firstChar;   // Первый символ
    @Deprecated(since = "1.7", forRemoval = true)
    private char lastChar;   // Последний символ

    /**
     * Создание диапазона символов по умолчанию.
     * @author Namespace Stedd
     */
    public CharRange() {
//        this.firstChar = '0';
//        this.lastChar = '9';
        super();
    }

    /**
     * Создание диапазона числовых символов.
     * @author Namespace Stedd
     * @param a минимальная цифра
     * @param b максимальная цифра
     */
    public CharRange(int a, int b) {
        super((char) a, (char) b);
        int min = Math.min(a, b),
                max = Math.max(a, b);

        // Если оба числа не укладываются в максимальную цифру
        if (min > 9) {
//            this.firstChar = '9';
//            this.lastChar = '9';
//            super('9', '9');
            super.min = '9';
            super.max = '9';
            return;
        }

        // Если оба числа не укладываются в минимальную цифру
        if (max < 0) {
//            this.firstChar = '0';
//            this.lastChar = '0';
            super.min = '0';
            super.max = '0';
            return;
        }

        // Если минимальное число не укладывается в минимальную цифру
//        this.firstChar = min < 0 ?
//                '0' :
//                (char) (min + '0');
        super.min = min < 0 ?
                '0' :
                (char) (min + '0');

        // Если максимальное число не укладывается в максимальную цифру
//        this.lastChar = max > 9 ?
//                '9' :
//                (char) (max + '0');
        super.max = max > 9 ?
                '9' :
                (char) (max + '0');
    }

    /**
     * Создание диапазона буквенных символов.
     * @author Namespace Stedd
     * @param firstLetter первая буква
     * @param lastLetter последняя буква
     * @param isCapital показатель принадлежности буквы к заглавной
     */
    public CharRange(Letter firstLetter, Letter lastLetter, boolean isCapital) {
        super();
        if (firstLetter.ordinal() > lastLetter.ordinal()) {
            Letter spinOffLetter = firstLetter;
            firstLetter = lastLetter;
            lastLetter = spinOffLetter;
        }
//        this.firstChar = isCapital ?
//                firstLetter.getCapitalLetter() :
//                firstLetter.getSmallLetter();
//        this.lastChar = isCapital ?
//                lastLetter.getCapitalLetter() :
//                lastLetter.getSmallLetter();
        super.min = isCapital ?
                firstLetter.getCapitalLetter() :
                firstLetter.getSmallLetter();
        super.max = isCapital ?
                lastLetter.getCapitalLetter() :
                lastLetter.getSmallLetter();
    }

    /**
     * Создание диапазона числовых символов.
     * @author Namespace Stedd
     * @param a минимальная цифра
     * @param b максимальная цифра
     * @return диапазон символов
     */
    public static CharRange of(int a, int b) {
        return new CharRange(a, b);
    }

    /**
     * Создание диапазона числовых символов.
     * @author Namespace Stedd
     * @param firstLetter первая буква
     * @param lastLetter последняя буква
     * @param isCapital показатель принадлежности буквы к заглавной
     * @return диапазон символов
     */
    public static CharRange of(Letter firstLetter, Letter lastLetter, boolean isCapital) {
        return new CharRange(firstLetter, lastLetter, isCapital);
    }

    /**
     * Получение длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return длина ограниченного диапазона
     */
    @Override
    public BigInteger bigLength() {
        long max = this.max(),
                min = this.min(),
                addition = max < min ? 0 : 1;
        return BigInteger.valueOf(max)
                .subtract(BigInteger.valueOf(min))
                .add(BigInteger.valueOf(addition));
    }

    /**
     * Получение типизированной длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return типизированная длина ограниченного диапазона
     */
    @Override
    public Character tLength() {
        return (char) this.bigLength().longValue();
    }

    /**
     * Получение типизированного минимального значения.
     * @author Namespace Stedd
     * @return типизированное минимальное значение
     */
    @Override
    public Character tMin() {
        return Character.MIN_VALUE;
    }

    /**
     * Получение типизированного максимального значения.
     * @author Namespace Stedd
     * @return типизированное максимальное значение
     */
    @Override
    public Character tMax() {
        return Character.MAX_VALUE;
    }

    /**
     * Получение необходимости смены порядка чисел местами.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return необходимость смены порядка чисел местами
     */
    @Override
    public boolean isSwapNecessary(Character min, Character max) {
        return min != null && max != null && max < min;
    }

    /**
     * Декрементирование значения.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение
     */
    @Override
    public Character decrement(Character value) {
        return (value != null ? (char) (value - this.decrementStep()) : null);
    }

    /**
     * Получение шага декрементирования.
     * @author Namespace Stedd
     * @return шаг декрементирования
     */
    @Override
    public Character decrementStep() {
        return 1;
    }

    /**
     * Инкрементирование значения.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение
     */
    @Override
    public Character increment(Character value) {
        return value != null ? (char) (value + this.incrementStep()) : null;
    }

    /**
     * Получение шага инкрементирования.
     * @author Namespace Stedd
     * @return шаг инкрементирования
     */
    @Override
    public Character incrementStep() {
        return null;
    }

    /**
     * Преобразование диапазона символов в строку.
     * @author Namespace Stedd
     * @return строчный диапазон символов
     */
    @Override
    public String toString() {
//        return this.firstChar + "-" + this.lastChar;
        return this.min + "-" + this.max;
    }

}
