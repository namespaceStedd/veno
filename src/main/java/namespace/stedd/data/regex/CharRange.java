package namespace.stedd.data.regex;

import namespace.stedd.data.lang.Letter;

/**
 * Диапазон символов.
 * @author Namespace Stedd
 */
public class CharRange {

    private final char firstChar;   // Первый символ
    private final char lastChar;   // Последний символ

    /**
     * Создание диапазона символов по умолчанию.
     * @author Namespace Stedd
     */
    public CharRange() {
        this.firstChar = '0';
        this.lastChar = '9';
    }

    /**
     * Создание диапазона числовых символов.
     * @author Namespace Stedd
     * @param a минимальная цифра
     * @param b максимальная цифра
     */
    public CharRange(int a, int b) {
        int min = Math.min(a, b),
                max = Math.max(a, b);

        // Если оба числа не укладываются в максимальную цифру
        if (min > 9) {
            this.firstChar = '9';
            this.lastChar = '9';
            return;
        }

        // Если оба числа не укладываются в минимальную цифру
        if (max < 0) {
            this.firstChar = '0';
            this.lastChar = '0';
            return;
        }

        // Если минимальное число не укладывается в минимальную цифру
        this.firstChar = min < 0 ?
                '0' :
                (char) (min + '0');

        // Если максимальное число не укладывается в максимальную цифру
        this.lastChar = max > 9 ?
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
        if (firstLetter.ordinal() > lastLetter.ordinal()) {
            Letter spinOffLetter = firstLetter;
            firstLetter = lastLetter;
            lastLetter = spinOffLetter;
        }
        this.firstChar = isCapital ?
                firstLetter.getCapitalLetter() :
                firstLetter.getSmallLetter();
        this.lastChar = isCapital ?
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
     * Преобразование диапазона символов в строку.
     * @author Namespace Stedd
     * @return строчный диапазон символов
     */
    @Override
    public String toString() {
        return this.firstChar + "-" + this.lastChar;
    }

}
