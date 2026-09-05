package namespace.stedd.data.type.number;

import java.math.BigInteger;

/**
 * Диапазон значений некоторого числового типа данных.
 * @author Namespace Stedd
 */
public abstract class NumberRange<T extends Number> extends Range<T> {

    /**
     * Создание пустого диапазона значений некоторого числового типа данных.
     * @author Namespace Stedd
     */
    public NumberRange() {
        super();
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений некоторого числового типа данных.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     */
    public NumberRange(T value, Type type) {
        super(value, type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений некоторого числового типа данных.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public NumberRange(T value, Type type, boolean isIncluded) {
        super(value, type, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений некоторого числового типа данных.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public NumberRange(T min, T max) {
        super(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений некоторого числового типа данных.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public NumberRange(T min, boolean minIncluded, T max, boolean maxIncluded) {
        super(min, minIncluded, max, maxIncluded);
    }

    /**
     * Получение длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return длина ограниченного диапазона
     */
    @Override
    public BigInteger bigLength() {
        long max = this.max().longValue(),
                min = this.min().longValue(),
                addition = max < min ? 0 : 1;
        return BigInteger.valueOf(max)
                .subtract(BigInteger.valueOf(min))
                .add(BigInteger.valueOf(addition));
    }

    /**
     * Получение необходимости смены порядка чисел местами.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return необходимость смены порядка чисел местами
     */
    @Override
    public boolean isSwapNecessary(T min, T max) {
        return min != null && max != null && max.doubleValue() < min.doubleValue();
    }

    /**
     * Преобразование ограниченного диапазона в строку.
     * @author Namespace Stedd
     * @return строчный ограниченный диапазон
     */
    @Override
    public String toString() {
        return (this.minIncluded ? "[" : "(") +
                this.getMin(this.tMin()) +
                "; " +
                this.getMax(this.tMax()) +
                (this.maxIncluded ? "]" : ")");
    }

}
