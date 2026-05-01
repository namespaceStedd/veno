package namespace.stedd.data.type;

/**
 * Представление расширенных перечислений.
 * @author Namespace Stedd
 */
public class Enumeration {

    /**
     * Преобразование строчного значения в элемент перечисления.
     * @author Namespace Stedd
     * @param stringValue строчное значение
     * @param enumeration перечисление
     * @return подходящий элемент перечисления
     * @param <E> тип постоянной перечисления
     */
    public static <E extends Enum<E>> E parse(String stringValue, E[] enumeration) {
        for (E element : enumeration) {
            if (element.name().equals(stringValue)) {
                return element;
            }
        }
        return null;
    }

    /**
     * Преобразование строчного значения в элемент перечисления.
     * @author Namespace Stedd
     * @param stringValue строчное значение
     * @param enumeration перечисление
     * @param ifNull перечисление по умолчанию в случае, если из строчного значения ничего не нашлось
     * @return подходящий элемент перечисления
     * @param <E> тип постоянной перечисления
     */
    public static <E extends Enum<E>> E parse(String stringValue, E[] enumeration, E ifNull) {
        E element = parse(stringValue, enumeration);
        return element != null ? element : ifNull;
    }

}
