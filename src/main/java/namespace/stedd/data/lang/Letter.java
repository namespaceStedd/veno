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

}
