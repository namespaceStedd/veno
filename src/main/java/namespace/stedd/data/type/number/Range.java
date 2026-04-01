package namespace.stedd.data.type.number;

/**
 * Диапазон значений целых чисел.
 * @author Namespace Stedd
 */
public class Range {

    private Double min;   // Минимальное значение
    private Double max;   // Максимальное значение

    /**
     * Создание неограниченного диапазона.
     * @author Namespace Stedd
     */
    public Range() {
    }

    /**
     * Создание ограниченного с одной стороны диапазона.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип границы
     */
    public Range(double value, RangeType type) {
        switch (type) {
            case MIN -> this.min = value;
            case MAX -> this.max = value;
            case null -> { }
        }
    }

    /**
     * Создание ограниченного с двух сторон диапазона.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Создание ограниченного с двух сторон диапазона.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return ограниченный по факту диапазон
     */
    public static Range create(Double min, Double max) {
        if (min == null && max == null) {
            return new Range();
        }
        else if (min == null) {
            return new Range(max, RangeType.MAX);
        }
        else if (max == null) {
            return new Range(min, RangeType.MIN);
        }
        else {
            return new Range(min, max);
        }
    }

    /**
     * Получение минимального значения диапазона.
     * @author Namespace Stedd
     * @return минимальное значение диапазона
     */
    public Double getMin() {
        return this.min;
    }

    /**
     * Получение минимального значения диапазона.
     * @author Namespace Stedd
     * @param ifNull если текущее значение NULL
     * @return минимальное значение диапазона
     */
    public double getMin(double ifNull) {
        return this.min != null ? this.min : ifNull;
    }

    /**
     * Обновление минимального значения диапазона.
     * @author Namespace Stedd
     * @param min минимальное значение диапазона
     */
    public void setMin(Double min) {
        this.min = min;
    }

    /**
     * Получение максимального значения диапазона.
     * @author Namespace Stedd
     * @return максимальное значение диапазона
     */
    public Double getMax() {
        return this.max;
    }

    /**
     * Получение максимального значения диапазона.
     * @author Namespace Stedd
     * @param ifNull если текущее значение NULL
     * @return максимальное значение диапазона
     */
    public double getMax(double ifNull) {
        return this.max != null ? this.max : ifNull;
    }

    /**
     * Обновление максимального значения диапазона.
     * @author Namespace Stedd
     * @param max максимальное значение диапазона
     */
    public void setMax(Double max) {
        this.max = max;
    }
}
