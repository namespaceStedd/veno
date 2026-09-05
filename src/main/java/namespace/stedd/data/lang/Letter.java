package namespace.stedd.data.lang;

/**
 * Интерфейс символьной единицы.
 * @author Namespace Stedd
 */
public interface Letter {

    /**
     * Получение заглавной буквы.
     * @author Namespace Stedd
     * @return заглавная буква
     */
    char getCapitalLetter();

    /**
     * Получение строчной буквы.
     * @author Namespace Stedd
     * @return строчная буква
     */
    char getSmallLetter();

    /**
     * Получение HID-кода буквы.
     * @author Namespace Stedd
     * @return HID-код буквы
     */
    byte getHidKey();

    /**
     * Получение порядкового номера буквы.
     * @author Namespace Stedd
     * @return порядковый номер буквы
     */
    int ordinal();

    /**
     * Получение случайной буквы алфавита.
     * @author Namespace Stedd
     * @param includeCapitalLetters включая заглавные буквы
     * @param includeSmallLetters включая строчные буквы
     * @return случайная буква алфавита
     */
    static char random(boolean includeCapitalLetters, boolean includeSmallLetters) {
        return '0';
    }

    /**
     * Пустая буква.
     */
    Letter EMPTY = new Letter() {

        /**
         * Получение заглавной буквы.
         * @author Namespace Stedd
         * @return заглавная буква
         */
        @Override
        public char getCapitalLetter() {
            return Character.MIN_VALUE;
        }

        /**
         * Получение строчной буквы.
         * @author Namespace Stedd
         * @return строчная буква
         */
        @Override
        public char getSmallLetter() {
            return Character.MIN_VALUE;
        }

        /**
         * Получение HID-кода буквы.
         * @author Namespace Stedd
         * @return HID-код буквы
         */
        @Override
        public byte getHidKey() {
            return -1;
        }

        /**
         * Получение порядкового номера буквы.
         * @author Namespace Stedd
         * @return порядковый номер буквы
         */
        @Override
        public int ordinal() {
            return -1;
        }

    };

}
