package namespace.stedd.data.type.number;

import java.math.BigInteger;

/**
 * Диапазон значений целых чисел.
 * @author Namespace Stedd
 */
public abstract class Range<T> {

    /**
     * Минимальное значение.
     */
    protected T min;

    /**
     * Показатель включённости нижней границы в диапазон.
     */
    protected boolean minIncluded;

    /**
     * Максимальное значение.
     */
    protected T max;

    /**
     * Показатель включённости верхней границы в диапазон.
     */
    protected boolean maxIncluded;

    /**
     * Создание неограниченного диапазона.
     * @author Namespace Stedd
     */
    public Range() {
        this.min = null;
        this.minIncluded = true;
        this.max = null;
        this.maxIncluded = true;
    }

    /**
     * Создание ограниченного с одной стороны диапазона.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип границы
     */
    public Range(T value, Type type) {
        switch (type) {
            case MIN -> {
                this.min = value;
                this.minIncluded = true;
                this.max = null;
                this.maxIncluded = true;
            }
            case MAX -> {
                this.min = null;
                this.minIncluded = true;
                this.max = value;
                this.maxIncluded = true;
            }
        }
    }

    /**
     * Создание ограниченного с одной из сторон диапазона значений.
     * @author Namespace Stedd
     * @param value значение ограничения
     * @param type тип ограничения
     * @param isIncluded показатель включённости границы
     */
    public Range(T value, Type type, boolean isIncluded) {
        switch (type) {
            case MIN -> {
                this.min = value;
                this.minIncluded = isIncluded;
                this.max = null;
                this.maxIncluded = true;
            }
            case MAX -> {
                this.min = null;
                this.minIncluded = true;
                this.max = value;
                this.maxIncluded = isIncluded;
            }
        }
    }

    /**
     * Создание ограниченного с двух сторон диапазона.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     */
    public Range(T min, T max) {
        if (this.isSwapNecessary(min, max)) {
            this.min = max;
            this.max = min;
        }
        else {
            this.min = min;
            this.max = max;
        }
        this.minIncluded = true;
        this.maxIncluded = true;
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     */
    public Range(T min, boolean minIncluded, T max, boolean maxIncluded) {
        if (this.isSwapNecessary(min, max)) {
            this.min = max;
            this.max = min;
        }
        else {
            this.min = min;
            this.max = max;
        }
        this.minIncluded = minIncluded;
        this.maxIncluded = maxIncluded;
    }

    /**
     * Создание пустого диапазона значений.
     * @author Namespace Stedd
     * @return диапазон значений
     * @param <T> универсальный параметр типа
     */
    public static <T> Range<T> create() {
        return new Range<>() {

            @Override
            public BigInteger bigLength() {
                return BigInteger.ZERO;
            }

            @Override
            public T tLength() {
                return null;
            }

            @Override
            public T tMin() {
                return null;
            }

            @Override
            public T tMax() {
                return null;
            }

            @Override
            public boolean isSwapNecessary(T min, T max) {
                return false;
            }

            @Override
            public T decrement(T value) {
                return value;
            }

            @Override
            public T decrementStep() {
                return null;
            }

            @Override
            public T increment(T value) {
                return value;
            }

            @Override
            public T incrementStep() {
                return null;
            }
        };
    }

    /**
     * Создание ограниченного снизу диапазона значений.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @return диапазон значений
     * @param <T> универсальный параметр типа
     */
    public static <T> Range<T> fromMin(T min) {
        return fromMin(min, true);
    }

    /**
     * Создание ограниченного снизу диапазона значений.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     * @param <T> универсальный параметр типа
     */
    public static <T> Range<T> fromMin(T min, boolean isIncluded) {
        return new Range<>(min, Type.MIN, isIncluded) {

            @Override
            public BigInteger bigLength() {
                return BigInteger.ZERO;
            }

            @Override
            public T tLength() {
                return null;
            }

            @Override
            public T tMin() {
                return null;
            }

            @Override
            public T tMax() {
                return null;
            }

            @Override
            public boolean isSwapNecessary(T min, T max) {
                return false;
            }

            @Override
            public T decrement(T value) {
                return value;
            }

            @Override
            public T decrementStep() {
                return null;
            }

            @Override
            public T increment(T value) {
                return value;
            }

            @Override
            public T incrementStep() {
                return null;
            }
        };
    }

    /**
     * Создание ограниченного сверху диапазона значений.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @return диапазон значений
     * @param <T> универсальный параметр типа
     */
    public static <T> Range<T> toMax(T max) {
        return toMax(max, true);
    }

    /**
     * Создание ограниченного сверху диапазона значений.
     * @author Namespace Stedd
     * @param max максимальное значение
     * @param isIncluded показатель включённости границы
     * @return диапазон значений
     * @param <T> универсальный параметр типа
     */
    public static <T> Range<T> toMax(T max, boolean isIncluded) {
        return new Range<>(max, Type.MAX, isIncluded) {

            @Override
            public BigInteger bigLength() {
                return BigInteger.ZERO;
            }

            @Override
            public T tLength() {
                return null;
            }

            @Override
            public T tMin() {
                return null;
            }

            @Override
            public T tMax() {
                return null;
            }

            @Override
            public boolean isSwapNecessary(T min, T max) {
                return false;
            }

            @Override
            public T decrement(T value) {
                return value;
            }

            @Override
            public T decrementStep() {
                return null;
            }

            @Override
            public T increment(T value) {
                return value;
            }

            @Override
            public T incrementStep() {
                return null;
            }
        };
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return диапазон значений
     * @param <T> универсальный параметр типа
     */
    public static <T> Range<T> create(T min, T max) {
        return create(min, true, max, true);
    }

    /**
     * Создание ограниченного с двух из сторон диапазона значений.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param minIncluded показатель включённости нижней границы в диапазон
     * @param max максимальное значение
     * @param maxIncluded показатель включённости верхней границы в диапазон
     * @return диапазон значений
     * @param <T> универсальный параметр типа
     */
    public static <T> Range<T> create(T min, boolean minIncluded, T max, boolean maxIncluded) {
        return new Range<>(min, minIncluded, max, maxIncluded) {

            @Override
            public BigInteger bigLength() {
                return BigInteger.ZERO;
            }

            @Override
            public T tLength() {
                return null;
            }

            @Override
            public T tMin() {
                return null;
            }

            @Override
            public T tMax() {
                return null;
            }

            @Override
            public boolean isSwapNecessary(T min, T max) {
                return false;
            }

            @Override
            public T decrement(T value) {
                return value;
            }

            @Override
            public T decrementStep() {
                return null;
            }

            @Override
            public T increment(T value) {
                return value;
            }

            @Override
            public T incrementStep() {
                return null;
            }
        };
    }

    /**
     * Получение проверенного минимального значения.
     * @author Namespace Stedd
     * @return проверенное минимальное значение
     */
    public T min() {
        T min = this.getMin(this.tMin());
        return this.minIncluded ? min : this.increment(min);
    }

    /**
     * Получение минимального значения диапазона.
     * @author Namespace Stedd
     * @return минимальное значение диапазона
     */
    public T getMin() {
        return this.min;
    }

    /**
     * Получение минимального значения диапазона.
     * @author Namespace Stedd
     * @param ifNull минимальное значение при отсутствии ограничения
     * @return минимальное значение диапазона
     */
    public T getMin(T ifNull) {
        return this.min != null ? this.min : ifNull;
    }

    /**
     * Обновление минимального значения диапазона.
     * @author Namespace Stedd
     * @param min минимальное значение диапазона
     */
    public void setMin(T min) {
        if (this.isSwapNecessary(min, this.max)) {
            this.min = this.max;
            this.max = min;
        }
        else {
            this.min = min;
        }
    }

    /**
     * Получение проверенного максимального значения.
     * @author Namespace Stedd
     * @return проверенное максимальное значение
     */
    public T max() {
        T max = this.getMax(this.tMax());
        return this.maxIncluded ? max : this.decrement(max);
    }

    /**
     * Получение максимального значения диапазона.
     * @author Namespace Stedd
     * @return максимальное значение диапазона
     */
    public T getMax() {
        return this.max;
    }

    /**
     * Получение максимального значения диапазона.
     * @author Namespace Stedd
     * @param ifNull максимальное значение при отсутствии ограничения
     * @return максимальное значение диапазона
     */
    public T getMax(T ifNull) {
        return this.max != null ? this.max : ifNull;
    }

    /**
     * Обновление максимального значения диапазона.
     * @author Namespace Stedd
     * @param max максимальное значение диапазона
     */
    public void setMax(T max) {
        if (this.isSwapNecessary(this.min, max)) {
            this.max = this.min;
            this.min = max;
        }
        else {
            this.max = max;
        }
    }

    /**
     * Получение длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return длина ограниченного диапазона
     */
    public long length() {
        // TODO: Нужно ли данное условие?
        // TODO: Или оставить возможность отрицательности?
        long length = this.bigLength().longValue();
        return length < 0 ? 0 : length;
    }

    /**
     * Получение большой длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return большая длина ограниченного диапазона
     */
    public abstract BigInteger bigLength();

    /**
     * Получение типизированной длины ограниченного диапазона.
     * @author Namespace Stedd
     * @return типизированная длина ограниченного диапазона
     */
    public abstract T tLength();

    /**
     * Получение типизированного минимального значения.
     * @author Namespace Stedd
     * @return типизированное минимальное значение
     */
    public abstract T tMin();

    /**
     * Получение типизированного максимального значения.
     * @author Namespace Stedd
     * @return типизированное максимальное значение
     */
    public abstract T tMax();

    /**
     * Получение необходимости смены порядка чисел местами.
     * @author Namespace Stedd
     * @param min минимальное значение
     * @param max максимальное значение
     * @return необходимость смены порядка чисел местами
     */
    public abstract boolean isSwapNecessary(T min, T max);

    /**
     * Декрементирование значения.
     * @author Namespace Stedd
     * @param value уменьшаемое значение
     * @return декрементированное значение
     */
    public abstract T decrement(T value);

    /**
     * Получение шага декрементирования.
     * @author Namespace Stedd
     * @return шаг декрементирования
     */
    public abstract T decrementStep();

    /**
     * Инкрементирование значения.
     * @author Namespace Stedd
     * @param value увеличиваемое значение
     * @return инкрементированное значение
     */
    public abstract T increment(T value);

    /**
     * Получение шага инкрементирования.
     * @author Namespace Stedd
     * @return шаг инкрементирования
     */
    public abstract T incrementStep();

    /**
     * Преобразование ограниченного диапазона в строку.
     * @author Namespace Stedd
     * @return строчный ограниченный диапазон
     */
    @Override
    public String toString() {
        return "Диапазон от " + this.getMin(this.tMin()) + " до " + this.getMax(this.tMax());
    }

    /**
     * Перечисление типов ограничения диапазона.
     * @author Namespace Stedd
     */
    public enum Type {

        /**
         * Минимальное значение.
         */
        MIN,

        /**
         * Максимальное значение.
         */
        MAX,

        ;

    }

}
