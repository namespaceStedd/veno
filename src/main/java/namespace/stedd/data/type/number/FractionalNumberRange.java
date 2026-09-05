package namespace.stedd.data.type.number;

import namespace.stedd.data.adapter.Notify;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Диапазон значений некоторого дробно-числового типа данных.
 * @author Namespace Stedd
 */
public abstract class FractionalNumberRange<T extends Number> extends NumberRange<T> {

    /**
     * Минимальное значение повышенной точности.
     */
    protected BigDecimal min;

    /**
     * Максимальное значение повышенной точности.
     */
    protected BigDecimal max;

    /**
     * Создание пустого диапазона значений некоторого дробно-числового типа данных.
     * @author Namespace Stedd
     */
    public FractionalNumberRange() {
        super();
        this.min = null;
        this.max = null;
    }

    /**
     * Создание ограниченного с одной из сторон диапазона некоторого дробно-числового типа данных.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     */
    public FractionalNumberRange(T value, Type type) {
        super(value, type);
        switch (type) {
            case MIN -> {
                this.min = BigDecimal.valueOf(value.doubleValue());
                this.max = null;
            }
            case MAX -> {
                this.min = null;
                this.max = BigDecimal.valueOf(value.doubleValue());
            }
        }
    }

    /**
     * Создание ограниченного с одной из сторон диапазона некоторого дробно-числового типа данных.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public FractionalNumberRange(T value, Type type, boolean isIncluded) {
        super(value, type, isIncluded);
        switch (type) {
            case MIN -> {
                this.min = BigDecimal.valueOf(value.doubleValue());
                this.max = null;
            }
            case MAX -> {
                this.min = null;
                this.max = BigDecimal.valueOf(value.doubleValue());
            }
        }
    }

    /**
     * Создание ограниченного с двух из сторон диапазона некоторого дробно-числового типа данных.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public FractionalNumberRange(T min, T max) {
        super(min, max);
        this.min = BigDecimal.valueOf(min.doubleValue());
        this.max = BigDecimal.valueOf(max.doubleValue());
    }

    /**
     * Создание ограниченного с двух из сторон диапазона некоторого дробно-числового типа данных.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public FractionalNumberRange(T min, boolean minIncluded, T max, boolean maxIncluded) {
        super(min, minIncluded, max, maxIncluded);
        this.min = BigDecimal.valueOf(min.doubleValue());
        this.max = BigDecimal.valueOf(max.doubleValue());
    }

    /**
     * Получение минимального значения повышенной точности.
     * @author Namespace Stedd
     * @param ifNull минимальное значение при отсутствии ограничения
     * @return минимальное значение повышенной точности
     */
    public BigDecimal getMin(BigDecimal ifNull) {
        return this.min != null ? this.min : ifNull;
    }

    /**
     * Обновление минимального значения.
     * @author Namespace Stedd
     * @param min минимальное значение
     */
    public void setMin(T min) {
        BigDecimal bigMin = BigDecimal.valueOf(min.doubleValue());
        if (this.isSwapNecessary(bigMin, this.max)) {
            super.min = super.max;
            this.min = this.max;
            super.max = min;
            this.max = bigMin;
        }
        else {
            super.min = min;
            this.min = bigMin;
        }
    }

    /**
     * Получение проверенного минимального значения повышенной точности.
     * @author Namespace Stedd
     * @return проверенное минимальное значение повышенной точности
     */
    public BigDecimal bigMin() {
        BigDecimal min = this.getMin(this.tBigMin());
        return this.minIncluded ? min : this.bigIncrement(min);
    }

    /**
     * Получение максимального значения повышенной точности.
     * @author Namespace Stedd
     * @param ifNull максимальное значение при отсутствии ограничения
     * @return максимальное значение повышенной точности
     */
    public BigDecimal getMax(BigDecimal ifNull) {
        return this.max != null ? this.max : ifNull;
    }

    /**
     * Обновление максимального значения.
     * @author Namespace Stedd
     * @param max максимальное значение
     */
    public void setMax(T max) {
        BigDecimal bigMax = BigDecimal.valueOf(max.doubleValue());
        if (this.isSwapNecessary(this.min, bigMax)) {
            super.max = super.min;
            this.max = this.min;
            super.min = max;
            this.min = bigMax;
        }
        else {
            super.max = max;
            this.max = bigMax;
        }
    }

    /**
     * Получение проверенного максимального значения повышенной точности.
     * @author Namespace Stedd
     * @return проверенное максимальное значение повышенной точности
     */
    public BigDecimal bigMax() {
        BigDecimal max = this.getMax(this.tBigMax());
        return this.maxIncluded ? max : this.bigDecrement(max);
    }

    /**
     * Получение длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return длина ограниченного диапазона
     */
    @Override
    @Notify("Данный метод работает корректно только при использовании конструктора с BigDecimal")
    public BigInteger bigLength() {
        double max = this.max().doubleValue(),
                min = this.min().doubleValue(),
                addition = max == min ? 0 : 1;
        return this.bigMax()
                .subtract(this.bigMin())
                .add(BigDecimal.valueOf(addition))
                .toBigInteger();
    }

    /**
     * Получение полной длины ограниченного диапазона, включая дробную часть.
     * @author Namespace Stedd
     * @return полная длина ограниченного диапазона, включая дробную часть
     */
    @Notify("Данный метод работает корректно только при использовании конструктора с BigDecimal")
    public BigInteger fullBigLength() {
        // Получение минимальных и максимальных значений
        BigDecimal min = this.bigMin(),
                max = this.bigMax();
        // Подсчёт значений
        BigInteger counter = BigInteger.valueOf(1);
        // Подсчёт по диапазонам со сравнением Comparable<T>
        while (min.compareTo(max) < 0) {
            counter = counter.add(BigInteger.valueOf(1));
            min = min.add(BigDecimal.valueOf(Double.MIN_VALUE));
        }
        // Возвращение подсчёта
        return counter;
    }

    /**
     * Получение типизированного минимального значения повышенной точности.
     * @author Namespace Stedd
     * @return типизированное минимальное значение повышенной точности
     */
    public BigDecimal tBigMin() {
        return BigDecimal.valueOf(0).subtract(BigDecimal.valueOf(Double.MAX_VALUE));
    }

    /**
     * Получение типизированного максимального значения повышенной точности.
     * @author Namespace Stedd
     * @return типизированное максимальное значение повышенной точности
     */
    public BigDecimal tBigMax() {
        return BigDecimal.valueOf(Double.MAX_VALUE);
    }

    /**
     * Получение необходимости смены порядка чисел местами.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param max максимальное значение повышенной точности
     * @return необходимость смены порядка чисел местами
     */
    public boolean isSwapNecessary(BigDecimal min, BigDecimal max) {
        return min != null && max != null && max.doubleValue() < min.doubleValue();
    }

    /**
     * Декрементирование значения повышенной точности.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение повышенной точности
     */
    public BigDecimal bigDecrement(Double value) {
        return this.bigDecrement(BigDecimal.valueOf(value));
    }

    /**
     * Декрементирование значения повышенной точности.
     * @author Namespace Stedd
     * @param value уменьшаемое значение повышенной точности
     * @return декрементированное значение повышенной точности
     */
    public BigDecimal bigDecrement(BigDecimal value) {
        return value != null ?
                value.subtract(BigDecimal.valueOf(Double.MIN_VALUE)) :
                null;
    }

    /**
     * Инкрементирование значения повышенной точности.
     * @author Namespace Stedd
     * @param value увеличиваемое значение повышенной точности
     * @return инкрементированное значение повышенной точности
     */
    public BigDecimal bigIncrement(Double value) {
        return this.bigIncrement(BigDecimal.valueOf(value));
    }

    /**
     * Инкрементирование значения повышенной точности.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение повышенной точности
     */
    public BigDecimal bigIncrement(BigDecimal value) {
        return value != null ?
                value.add(BigDecimal.valueOf(Double.MIN_VALUE)) :
                null;
    }

}
