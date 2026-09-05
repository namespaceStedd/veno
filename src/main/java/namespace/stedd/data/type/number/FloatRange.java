package namespace.stedd.data.type.number;

import java.math.BigDecimal;

/**
 * Диапазон значений дробных чисел.
 * @author Namespace Stedd
 */
public class FloatRange extends FractionalNumberRange<Float> {

    /**
     * Создание пустого диапазона значений дробных чисел.
     * @author Namespace Stedd
     */
    public FloatRange() {
        super();
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     */
    public FloatRange(Float value, Type type) {
        super(value, type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param value значение ограничения повышенной точности
     * @param type тип ограничения
     */
    public FloatRange(BigDecimal value, Type type) {
        super(value.floatValue(), type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public FloatRange(Float value, Type type, boolean isIncluded) {
        super(value, type, isIncluded);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param value значение ограничения повышенной точности
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public FloatRange(BigDecimal value, Type type, boolean isIncluded) {
        super(value.floatValue(), type, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public FloatRange(Float min, Float max) {
        super(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param max максимальное значение повышенной точности
     */
    public FloatRange(BigDecimal min, BigDecimal max) {
        super(min.floatValue(), max.floatValue());
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public FloatRange(Float min, boolean minIncluded, Float max, boolean maxIncluded) {
        super(min, minIncluded, max, maxIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение повышенной точности
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public FloatRange(BigDecimal min, boolean minIncluded, BigDecimal max, boolean maxIncluded) {
        super(min.floatValue(), minIncluded, max.floatValue(), maxIncluded);
    }

    /**
     * Создание пустого диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @return диапазон значений
     */
    public static FloatRange create() {
        return new FloatRange();
    }

    /**
     * Создание ограниченного снизу диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @return диапазон значений
     */
    public static FloatRange fromMin(Float min) {
        return new FloatRange(min, Type.MIN);
    }

    /**
     * Создание ограниченного снизу диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @return диапазон значений
     */
    public static FloatRange fromMin(BigDecimal min) {
        return new FloatRange(min, Type.MIN);
    }

    /**
     * Создание ограниченного снизу диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static FloatRange fromMin(Float min, boolean isIncluded) {
        return new FloatRange(min, Type.MIN, isIncluded);
    }

    /**
     * Создание ограниченного снизу диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static FloatRange fromMin(BigDecimal min, boolean isIncluded) {
        return new FloatRange(min, Type.MIN, isIncluded);
    }

    /**
     * Создание ограниченного сверху диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static FloatRange toMax(Float max) {
        return new FloatRange(max, Type.MAX);
    }

    /**
     * Создание ограниченного сверху диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param max максимальное значение повышенной точности
     * @return диапазон значений
     */
    public static FloatRange toMax(BigDecimal max) {
        return new FloatRange(max, Type.MAX);
    }

    /**
     * Создание ограниченного сверху диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static FloatRange toMax(Float max, boolean isIncluded) {
        return new FloatRange(max, Type.MAX, isIncluded);
    }

    /**
     * Создание ограниченного сверху диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param max максимальное значение повышенной точности
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static FloatRange toMax(BigDecimal max, boolean isIncluded) {
        return new FloatRange(max, Type.MAX, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static FloatRange create(Float min, Float max) {
        return new FloatRange(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param max максимальное значение повышенной точности
     * @return диапазон значений
     */
    public static FloatRange create(BigDecimal min, BigDecimal max) {
        return new FloatRange(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     */
    public static FloatRange create(Float min, boolean minIncluded, Float max, boolean maxIncluded) {
        return new FloatRange(min, minIncluded, max, maxIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений дробных чисел.
     * @author Namespace Stedd
     * @param min минимальное значение повышенной точности
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение повышенной точности
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     */
    public static FloatRange create(BigDecimal min, boolean minIncluded, BigDecimal max, boolean maxIncluded) {
        return new FloatRange(min, minIncluded, max, maxIncluded);
    }

    /**
     * Получение проверенного минимального значения.
     * @author Namespace Stedd
     * @return проверенное минимальное значение
     */
    @Override
    public Float min() {
        return this.bigMin().floatValue();
    }

    /**
     * Получение проверенного максимального значения.
     * @author Namespace Stedd
     * @return проверенное максимальное значение
     */
    @Override
    public Float max() {
        return this.bigMax().floatValue();
    }

    /**
     * Получение типизированной длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return типизированная длина ограниченного диапазона
     */
    @Override
    public Float tLength() {
        return this.bigLength().floatValue();
    }

    /**
     * Получение типизированного минимального значения.
     * @author Namespace Stedd
     * @return типизированное минимальное значение
     */
    @Override
    public Float tMin() {
        return -Float.MAX_VALUE;
    }

    /**
     * Получение типизированного максимального значения.
     * @author Namespace Stedd
     * @return типизированное максимальное значение
     */
    @Override
    public Float tMax() {
        return Float.MAX_VALUE;
    }

    /**
     * Декрементирование значения.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение
     */
    @Override
    public Float decrement(Float value) {
        return value != null ?
                BigDecimal.valueOf(value).subtract(BigDecimal.valueOf(Float.MIN_VALUE)).floatValue() :
                null;
    }

    /**
     * Получение шага декрементирования.
     * @author Namespace Stedd
     * @return шаг декрементирования
     */
    @Override
    public Float decrementStep() {
        return Float.MIN_VALUE;
    }

    /**
     * Инкрементирование значения.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение
     */
    @Override
    public Float increment(Float value) {
        return value != null ?
                BigDecimal.valueOf(value).add(BigDecimal.valueOf(Float.MIN_VALUE)).floatValue() :
                null;
    }

    /**
     * Получение шага инкрементирования.
     * @author Namespace Stedd
     * @return шаг инкрементирования
     */
    @Override
    public Float incrementStep() {
        return Float.MIN_VALUE;
    }

}
