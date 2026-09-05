package namespace.stedd.data.type.number;

/**
 * Диапазон значений малых целых чисел.
 * @author Namespace Stedd
 */
public class ShortRange extends NumberRange<Short> {

    /**
     * Создание пустого диапазона значений малых целых чисел.
     * @author Namespace Stedd
     */
    public ShortRange() {
        super();
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     */
    public ShortRange(Short value, Type type) {
        super(value, type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public ShortRange(Short value, Type type, boolean isIncluded) {
        super(value, type, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public ShortRange(Short min, Short max) {
        super(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public ShortRange(Short min, boolean minIncluded, Short max, boolean maxIncluded) {
        super(min, minIncluded, max, maxIncluded);
    }

    /**
     * Создание пустого диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @return диапазон значений
     */
    public static ShortRange create() {
        return new ShortRange();
    }

    /**
     * Создание ограниченного снизу диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @return диапазон значений
     */
    public static ShortRange fromMin(Short min) {
        return new ShortRange(min, Type.MIN);
    }

    /**
     * Создание ограниченного снизу диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static ShortRange fromMin(Short min, boolean isIncluded) {
        return new ShortRange(min, Type.MIN, isIncluded);
    }

    /**
     * Создание ограниченного сверху диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static ShortRange toMax(Short max) {
        return new ShortRange(max, Type.MAX);
    }

    /**
     * Создание ограниченного сверху диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static ShortRange toMax(Short max, boolean isIncluded) {
        return new ShortRange(max, Type.MAX, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static ShortRange create(Short min, Short max) {
        return new ShortRange(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений малых целых чисел.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     */
    public static ShortRange create(Short min, boolean minIncluded, Short max, boolean maxIncluded) {
        return new ShortRange(min, minIncluded, max, maxIncluded);
    }

    /**
     * Получение типизированной длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return типизированная длина ограниченного диапазона
     */
    @Override
    public Short tLength() {
        return this.bigLength().shortValue();
    }

    /**
     * Получение типизированного минимального значения.
     * @author Namespace Stedd
     * @return типизированное минимальное значение
     */
    @Override
    public Short tMin() {
        return Short.MIN_VALUE;
    }

    /**
     * Получение типизированного максимального значения.
     * @author Namespace Stedd
     * @return типизированное максимальное значение
     */
    @Override
    public Short tMax() {
        return Short.MAX_VALUE;
    }

    /**
     * Декрементирование значения.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение
     */
    @Override
    public Short decrement(Short value) {
        return value != null ? (short) (value - this.decrementStep()) : null;
    }

    /**
     * Получение шага декрементирования.
     * @author Namespace Stedd
     * @return шаг декрементирования
     */
    @Override
    public Short decrementStep() {
        return (short) 1;
    }

    /**
     * Инкрементирование значения.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение
     */
    @Override
    public Short increment(Short value) {
        return value != null ? (short) (value + this.incrementStep()) : null;
    }

    /**
     * Получение шага инкрементирования.
     * @author Namespace Stedd
     * @return шаг инкрементирования
     */
    @Override
    public Short incrementStep() {
        return (short) 1;
    }

}
