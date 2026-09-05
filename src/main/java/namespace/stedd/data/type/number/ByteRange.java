package namespace.stedd.data.type.number;

/**
 * Диапазон значений байт.
 * @author Namespace Stedd
 */
public class ByteRange extends NumberRange<Byte> {

    /**
     * Создание пустого диапазона значений байт.
     * @author Namespace Stedd
     */
    public ByteRange() {
        super();
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений байт.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     */
    public ByteRange(Byte value, Type type) {
        super(value, type);
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений байт.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public ByteRange(Byte value, Type type, boolean isIncluded) {
        super(value, type, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений байт.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public ByteRange(Byte min, Byte max) {
        super(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений байт.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public ByteRange(Byte min, boolean minIncluded, Byte max, boolean maxIncluded) {
        super(min, minIncluded, max, maxIncluded);
    }

    /**
     * Создание пустого диапазона значений байт.
     * @author Namespace Stedd
     * @return диапазон значений
     */
    public static ByteRange create() {
        return new ByteRange();
    }

    /**
     * Создание ограниченного снизу диапазона значений байт.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @return диапазон значений
     */
    public static ByteRange fromMin(Byte min) {
        return new ByteRange(min, Type.MIN);
    }

    /**
     * Создание ограниченного снизу диапазона значений байт.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static ByteRange fromMin(Byte min, boolean isIncluded) {
        return new ByteRange(min, Type.MIN, isIncluded);
    }

    /**
     * Создание ограниченного сверху диапазона значений байт.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static ByteRange toMax(Byte max) {
        return new ByteRange(max, Type.MAX);
    }

    /**
     * Создание ограниченного сверху диапазона значений байт.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     */
    public static ByteRange toMax(Byte max, boolean isIncluded) {
        return new ByteRange(max, Type.MAX, isIncluded);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений байт.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return диапазон значений
     */
    public static ByteRange create(Byte min, Byte max) {
        return new ByteRange(min, max);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений байт.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     */
    public static ByteRange create(Byte min, boolean minIncluded, Byte max, boolean maxIncluded) {
        return new ByteRange(min, minIncluded, max, maxIncluded);
    }

    /**
     * Получение типизированной длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return типизированная длина ограниченного диапазона
     */
    @Override
    public Byte tLength() {
        return this.bigLength().byteValue();
    }

    /**
     * Получение типизированного минимального значения.
     * @author Namespace Stedd
     * @return типизированное минимальное значение
     */
    @Override
    public Byte tMin() {
        return Byte.MIN_VALUE;
    }

    /**
     * Получение типизированного максимального значения.
     * @author Namespace Stedd
     * @return типизированное максимальное значение
     */
    @Override
    public Byte tMax() {
        return Byte.MAX_VALUE;
    }

    /**
     * Декрементирование значения.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение
     */
    @Override
    public Byte decrement(Byte value) {
        return value != null ? (byte) (value - this.decrementStep()) : null;
    }

    /**
     * Получение шага декрементирования.
     * @author Namespace Stedd
     * @return шаг декрементирования
     */
    @Override
    public Byte decrementStep() {
        return (byte) 1;
    }

    /**
     * Инкрементирование значения.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение
     */
    @Override
    public Byte increment(Byte value) {
        return value != null ? (byte) (value + this.incrementStep()) : null;
    }

    /**
     * Получение шага инкрементирования.
     * @author Namespace Stedd
     * @return шаг инкрементирования
     */
    @Override
    public Byte incrementStep() {
        return (byte) 1;
    }

}
