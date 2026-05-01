package namespace.stedd.data.cincout;

/**
 * Система вывода информации.
 * @author Namespace Stedd
 */
public interface OutputSystem {
    void write(String message);   // Вывод информации
    void trap(String message);   // Вывод исключительной информации

    /**
     * Пустая система вывода информации.
     */
    OutputSystem EMPTY = new OutputSystem() {

        /**
         * Вывод пустой информации.
         * @author Namespace Stedd
         * @param message выводимое сообщение
         */
        @Override
        public void write(String message) {

        }

        /**
         * Вывод исключительной информации.
         * @author Namespace Stedd
         * @param message выводимое исключение
         */
        @Override
        public void trap(String message) {

        }
    };
}
