package namespace.stedd.data.adapter;

/**
 * Правило конвертирования одного типа в другой.
 * @author Namespace Stedd
 * @param <T1> исходный параметр типа
 * @param <T2> конечный параметр типа
 */
public interface TypeConverterRule<T1, T2> {

    /**
     * Преобразование одного типа в другой.
     * @author Namespace Stedd
     * @param t1 первый тип
     * @return второй тип
     */
    T2 convert(T1 t1);

}
