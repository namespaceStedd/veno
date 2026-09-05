package namespace.stedd.data.type.number;

/**
 * Диапазон значений больших целых чисел.
 * @author Namespace Stedd
 */
public class LongRange extends NumberRange<Long> {

    /**
     * Создание пустого диапазона значений больших целых чисел.
     * @author Namespace Stedd
     */
    public LongRange() {
        super();
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     */
    public LongRange(Long value, Type type) {
        super(value, type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public LongRange(Long value, Type type, boolean isIncluded) {
        super(value, type, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public LongRange(Long min, Long max) {
        super(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public LongRange(Long min, boolean minIncluded, Long max, boolean maxIncluded) {
        super(min, minIncluded, max, maxIncluded);
    }

    /**
     * Создание пустого диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @return диапазон значений
     */
    public static LongRange create() {
        return new LongRange();
    }

    /**
     * Создание ограниченного снизу диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @return диапазон значений
     */
    public static LongRange fromMin(Long min) {
        return new LongRange(min, Type.MIN);
    }

    /**
     * Создание ограниченного снизу диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static LongRange fromMin(Long min, boolean isIncluded) {
        return new LongRange(min, Type.MIN, isIncluded);
    }

    /**
     * Создание ограниченного сверху диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static LongRange toMax(Long max) {
        return new LongRange(max, Type.MAX);
    }

    /**
     * Создание ограниченного сверху диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static LongRange toMax(Long max, boolean isIncluded) {
        return new LongRange(max, Type.MAX, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static LongRange create(Long min, Long max) {
        return new LongRange(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений больших целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     */
    public static LongRange create(Long min, boolean minIncluded, Long max, boolean maxIncluded) {
        return new LongRange(min, minIncluded, max, maxIncluded);
    }

    /**
     * Получение типизированной длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return типизированная длина ограниченного диапазона
     */
    @Override
    public Long tLength() {
        return this.bigLength().longValue();
    }

    /**
     * Получение типизированного минимального значения.
     * @author Namespace Stedd
     * @return типизированное минимальное значение
     */
    @Override
    public Long tMin() {
        return Long.MIN_VALUE;
    }

    /**
     * Получение типизированного максимального значения.
     * @author Namespace Stedd
     * @return типизированное максимальное значение
     */
    @Override
    public Long tMax() {
        return Long.MAX_VALUE;
    }

    /**
     * Декрементирование значения.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение
     */
    @Override
    public Long decrement(Long value) {
        return value != null ? (long) (value - this.decrementStep()) : null;
    }

    /**
     * Получение шага декрементирования.
     * @author Namespace Stedd
     * @return шаг декрементирования
     */
    @Override
    public Long decrementStep() {
        return (long) 1;
    }

    /**
     * Инкрементирование значения.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение
     */
    @Override
    public Long increment(Long value) {
        return value != null ? (long) (value + this.incrementStep()) : null;
    }

    /**
     * Получение шага инкрементирования.
     * @author Namespace Stedd
     * @return шаг инкрементирования
     */
    @Override
    public Long incrementStep() {
        return (long) 1;
    }

}
