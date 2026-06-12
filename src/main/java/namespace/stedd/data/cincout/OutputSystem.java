package namespace.stedd.data.cincout;

import namespace.stedd.data.cincout.logging.Logging;
import namespace.stedd.data.type.ExoString;
import org.apache.logging.log4j.Logger;

/**
 * Система вывода информации.
 * @author Namespace Stedd
 */
public interface OutputSystem {

    /**
     * Вывод обычной информации.
     * @author Namespace Stedd
     * @param message сообщение
     */
    void write(String message);

    /**
     * Вывод предупреждающей информации.
     * @author Namespace Stedd
     * @param message сообщение
     */
    void warn(String message);

    /**
     * Вывод исключительной информации.
     * @author Namespace Stedd
     * @param message сообщение
     */
    void trap(String message);

    /**
     * Вывод исключительной информации.
     * @author Namespace Stedd
     * @param exception исключение
     */
    default void except(Exception exception) {
        this.trap(ExoString.toExceptionString(exception));
    }

    /**
     * Пустая система вывода информации.
     */
    OutputSystem EMPTY = new OutputSystem() {

        /**
         * Вывод обычной информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void write(String message) {

        }

        /**
         * Вывод предупреждающей информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void warn(String message) {

        }

        /**
         * Вывод исключительной информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void trap(String message) {

        }

    };

    /**
     * Система вывода информации по умолчанию.
     */
    OutputSystem DEFAULT = new OutputSystem() {

        /**
         * Вывод обычной информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void write(String message) {
            System.out.println(message);
        }

        /**
         * Вывод предупреждающей информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void warn(String message) {
            System.out.println(message);
        }

        /**
         * Вывод исключительной информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void trap(String message) {
            System.err.println(message);
        }

    };

    /**
     * Система вывода информации в предопределённую консоль.
     */
    OutputSystem LOG = new OutputSystem() {

        /**
         * Журнал по умолчанию.
         */
        private static final Logger log = Logging.getDefault(OutputSystem.class);

        /**
         * Вывод обычной информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void write(String message) {
            log.info(message);
        }

        /**
         * Вывод предупреждающей информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void warn(String message) {
            log.warn(message);
        }

        /**
         * Вывод исключительной информации.
         * @author Namespace Stedd
         * @param message сообщение
         */
        @Override
        public void trap(String message) {
            log.error(message);
        }

        /**
         * Вывод исключительной информации.
         * @author Namespace Stedd
         * @param exception исключение
         */
        @Override
        public void except(Exception exception) {
            log.error(exception);
        }

    };

}
