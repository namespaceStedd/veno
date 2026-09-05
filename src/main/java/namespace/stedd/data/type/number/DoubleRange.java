package namespace.stedd.data.type.number;

import java.math.BigDecimal;

/**
 * Диапазон значений дробных чисел двойной точности.
 * @author Namespace Stedd
 */
public class DoubleRange extends FractionalNumberRange<Double> {

    /**
     * Создание пустого диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     */
    public DoubleRange() {
        super();
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     */
    public DoubleRange(Double value, Type type) {
        super(value, type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param value значение ограничения повышенной точности
     * @param type тип ограничения
     */
    public DoubleRange(BigDecimal value, Type type) {
        super(value.doubleValue(), type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public DoubleRange(Double value, Type type, boolean isIncluded) {
        super(value, type, isIncluded);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param value значение ограничения повышенной точности
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public DoubleRange(BigDecimal value, Type type, boolean isIncluded) {
        super(value.doubleValue(), type, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public DoubleRange(Double min, Double max) {
        super(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param max максимальное значение повышенной точности
     */
    public DoubleRange(BigDecimal min, BigDecimal max) {
        super(min.doubleValue(), max.doubleValue());
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public DoubleRange(Double min, boolean minIncluded, Double max, boolean maxIncluded) {
        super(min, minIncluded, max, maxIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение повышенной точности
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public DoubleRange(BigDecimal min, boolean minIncluded, BigDecimal max, boolean maxIncluded) {
        super(min.doubleValue(), minIncluded, max.doubleValue(), maxIncluded);
    }

    /**
     * Создание пустого диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @return диапазон значений
     */
    public static DoubleRange create() {
        return new DoubleRange();
    }

    /**
     * Создание ограниченного снизу диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @return диапазон значений
     */
    public static DoubleRange fromMin(Double min) {
        return new DoubleRange(min, Type.MIN);
    }

    /**
     * Создание ограниченного снизу диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @return диапазон значений
     */
    public static DoubleRange fromMin(BigDecimal min) {
        return new DoubleRange(min, Type.MIN);
    }

    /**
     * Создание ограниченного снизу диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static DoubleRange fromMin(Double min, boolean isIncluded) {
        return new DoubleRange(min, Type.MIN, isIncluded);
    }

    /**
     * Создание ограниченного снизу диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static DoubleRange fromMin(BigDecimal min, boolean isIncluded) {
        return new DoubleRange(min, Type.MIN, isIncluded);
    }

    /**
     * Создание ограниченного сверху диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static DoubleRange toMax(Double max) {
        return new DoubleRange(max, Type.MAX);
    }

    /**
     * Создание ограниченного сверху диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param max максимальное значение повышенной точности
     * @return диапазон значений
     */
    public static DoubleRange toMax(BigDecimal max) {
        return new DoubleRange(max, Type.MAX);
    }

    /**
     * Создание ограниченного сверху диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static DoubleRange toMax(Double max, boolean isIncluded) {
        return new DoubleRange(max, Type.MAX, isIncluded);
    }

    /**
     * Создание ограниченного сверху диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param max максимальное значение повышенной точности
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static DoubleRange toMax(BigDecimal max, boolean isIncluded) {
        return new DoubleRange(max, Type.MAX, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static DoubleRange create(Double min, Double max) {
        return new DoubleRange(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param max максимальное значение повышенной точности
     * @return диапазон значений
     */
    public static DoubleRange create(BigDecimal min, BigDecimal max) {
        return new DoubleRange(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     */
    public static DoubleRange create(Double min, boolean minIncluded, Double max, boolean maxIncluded) {
        return new DoubleRange(min, minIncluded, max, maxIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел двойной точности.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение повышенной точности
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     */
    public static DoubleRange create(BigDecimal min, boolean minIncluded, BigDecimal max, boolean maxIncluded) {
        return new DoubleRange(min, minIncluded, max, maxIncluded);
    }

    /**
     * Получение проверенного минимального значения.
     * @author Namespace Stedd
     * @return проверенное минимальное значение
     */
    @Override
    public Double min() {
        return this.bigMin().doubleValue();
    }

    /**
     * Получение проверенного максимального значения.
     * @author Namespace Stedd
     * @return проверенное максимальное значение
     */
    @Override
    public Double max() {
        return this.bigMax().doubleValue();
    }

    /**
     * Получение типизированной длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return типизированная длина ограниченного диапазона
     */
    @Override
    public Double tLength() {
        return this.bigLength().doubleValue();
    }

    /**
     * Получение типизированного минимального значения.
     * @author Namespace Stedd
     * @return типизированное минимальное значение
     */
    @Override
    public Double tMin() {
        return -Double.MAX_VALUE;
    }

    /**
     * Получение типизированного максимального значения.
     * @author Namespace Stedd
     * @return типизированное максимальное значение
     */
    @Override
    public Double tMax() {
        return Double.MAX_VALUE;
    }

    /**
     * Декрементирование значения.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение
     */
    @Override
    public Double decrement(Double value) {
        return value != null ?
                BigDecimal.valueOf(value).subtract(BigDecimal.valueOf(Double.MIN_VALUE)).doubleValue() :
                null;
    }

    /**
     * Получение шага декрементирования.
     * @author Namespace Stedd
     * @return шаг декрементирования
     */
    @Override
    public Double decrementStep() {
        return Double.MIN_VALUE;
    }

    /**
     * Инкрементирование значения.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение
     */
    @Override
    public Double increment(Double value) {
        return value != null ?
                BigDecimal.valueOf(value).add(BigDecimal.valueOf(Double.MIN_VALUE)).doubleValue() :
                null;
    }

    /**
     * Получение шага инкрементирования.
     * @author Namespace Stedd
     * @return шаг инкрементирования
     */
    @Override
    public Double incrementStep() {
        return Double.MIN_VALUE;
    }

}
