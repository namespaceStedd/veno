package namespace.stedd.data.cincout;

import namespace.stedd.data.cincout.logging.Logging;
import namespace.stedd.data.type.ExoString;
import org.apache.logging.log4j.Logger;

/**
 * Система вывода информации (улучшенная).
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
     * Вывод обычной информации.
     * @author Namespace Stedd
     * @param message сообщение
     * @param args аргументы сообщения
     */
    default void write(String message, Object... args) {
        this.write(withArgs(message, args));
    }

    /**
     * Вывод предупреждающей информации.
     * @author Namespace Stedd
     * @param message сообщение
     */
    void warn(String message);

    /**
     * Вывод предупреждающей информации.
     * @author Namespace Stedd
     * @param message сообщение
     * @param args аргументы сообщения
     */
    default void warn(String message, Object... args) {
        this.warn(withArgs(message, args));
    }

    /**
     * Вывод исключительной информации.
     * @author Namespace Stedd
     * @param message сообщение
     */
    void trap(String message);

    /**
     * Вывод исключительной информации.
     * @author Namespace Stedd
     * @param message сообщение
     * @param args аргументы сообщения
     */
    default void trap(String message, Object... args) {
        this.trap(withArgs(message, args));
    }

    /**
     * Вывод исключительной информации.
     * @author Namespace Stedd
     * @param exception исключение
     */
    default void except(Exception exception) {
        this.trap(ExoString.toExceptionString(exception));
    }

    /**
     * Вывод исключительной информации.
     * @author Namespace Stedd
     * @param exception исключение
     * @param args аргументы сообщения
     */
    default void except(Exception exception, Object... args) {
        this.trap(withArgs(ExoString.toExceptionString(exception), args));
    }

    /**
     * Формирование сообщения с аргументами.
     * @author Namespace Stedd
     * @param message сообщение
     * @param args аргументы сообщения
     * @return сообщение с аргументами
     */
    static String withArgs(String message, Object... args) {
        // TODO: Combine
        for (Object arg : args) {
            message = message.replaceFirst("\\{}", arg.toString());
        }
        return message;
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
    OutputSystem LOG = logOf(OutputSystem.class);

    /**
     * Получение системы вывода информации в Журнал по классу.
     * @author Namespace Stedd
     * @param callingClass название класса Журнала
     * @return система вывода информации в Журнал
     */
    static OutputSystem logOf(Class<?> callingClass) {
        return new OutputSystem() {

            /**
             * Журнал по умолчанию.
             */
            private final Logger log = Logging.getDefault(callingClass);

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

}
