package namespace.stedd.data.type.number;

/**
 * Диапазон значений целых чисел.
 * @author Namespace Stedd
 */
public class IntRange extends NumberRange<Integer> {

    /**
     * Создание пустого диапазона значений целых чисел.
     * @author Namespace Stedd
     */
    public IntRange() {
        super();
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     */
    public IntRange(Integer value, Type type) {
        super(value, type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public IntRange(Integer value, Type type, boolean isIncluded) {
        super(value, type, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public IntRange(Integer min, Integer max) {
        super(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public IntRange(Integer min, boolean minIncluded, Integer max, boolean maxIncluded) {
        super(min, minIncluded, max, maxIncluded);
    }

    /**
     * Создание пустого диапазона значений целых чисел.
     * @author Namespace Stedd
     * @return диапазон значений
     */
    public static IntRange create() {
        return new IntRange();
    }

    /**
     * Создание ограниченного снизу диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @return диапазон значений
     */
    public static IntRange fromMin(Integer min) {
        return new IntRange(min, Type.MIN);
    }

    /**
     * Создание ограниченного снизу диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static IntRange fromMin(Integer min, boolean isIncluded) {
        return new IntRange(min, Type.MIN, isIncluded);
    }

    /**
     * Создание ограниченного сверху диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static IntRange toMax(Integer max) {
        return new IntRange(max, Type.MAX);
    }

    /**
     * Создание ограниченного сверху диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static IntRange toMax(Integer max, boolean isIncluded) {
        return new IntRange(max, Type.MAX, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static IntRange create(Integer min, Integer max) {
        return new IntRange(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     */
    public static IntRange create(Integer min, boolean minIncluded, Integer max, boolean maxIncluded) {
        return new IntRange(min, minIncluded, max, maxIncluded);
    }

    /**
     * Получение типизированной длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return типизированная длина ограниченного диапазона
     */
    @Override
    public Integer tLength() {
        return this.bigLength().intValue();
    }

    /**
     * Получение типизированного минимального значения.
     * @author Namespace Stedd
     * @return типизированное минимальное значение
     */
    @Override
    public Integer tMin() {
        return Integer.MIN_VALUE;
    }

    /**
     * Получение типизированного максимального значения.
     * @author Namespace Stedd
     * @return типизированное максимальное значение
     */
    @Override
    public Integer tMax() {
        return Integer.MAX_VALUE;
    }

    /**
     * Декрементирование значения.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение
     */
    @Override
    public Integer decrement(Integer value) {
        return value != null ? value - this.decrementStep() : null;
    }

    /**
     * Получение шага декрементирования.
     * @author Namespace Stedd
     * @return шаг декрементирования
     */
    @Override
    public Integer decrementStep() {
        return 1;
    }

    /**
     * Инкрементирование значения.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение
     */
    @Override
    public Integer increment(Integer value) {
        return value != null ? value + this.incrementStep() : null;
    }

    /**
     * Получение шага инкрементирования.
     * @author Namespace Stedd
     * @return шаг инкрементирования
     */
    @Override
    public Integer incrementStep() {
        return 1;
    }

}
