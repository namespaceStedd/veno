package namespace.stedd.data.lang.pack;

import namespace.stedd.data.lang.Letter;

/**
 * Перечисление букв русского алфавита.
 * @author Namespace Stedd
 */
public enum RussianLetter implements Letter {

    Аа('А','а', (byte) 0x09),
    Бб('Б','б', (byte) 0x36),
    Вв('В','в', (byte) 0x07),
    Гг('Г','г', (byte) 0x18),
    Дд('Д','д', (byte) 0x0f),
    Ее('Е','е', (byte) 0x17),
    Ёё('Ё','ё', (byte) 0x35),
    Жж('Ж','ж', (byte) 0x33),
    Зз('З','з', (byte) 0x13),
    Ии('И','и', (byte) 0x05),
    Йй('Й','й', (byte) 0x14),
    Кк('К','к', (byte) 0x15),
    Лл('Л','л', (byte) 0x0e),
    Мм('М','м', (byte) 0x19),
    Нн('Н','н', (byte) 0x1c),
    Оо('О','о', (byte) 0x0d),
    Пп('П','п', (byte) 0x0a),
    Рр('Р','р', (byte) 0x0b),
    Сс('С','с', (byte) 0x06),
    Тт('Т','т', (byte) 0x11),
    Уу('У','у', (byte) 0x08),
    Фф('Ф','ф', (byte) 0x04),
    Хх('Х','х', (byte) 0x2f),
    Цц('Ц','ц', (byte) 0x1a),
    Чч('Ч','ч', (byte) 0x1b),
    Шш('Ш','ш', (byte) 0x0c),
    Щщ('Щ','щ', (byte) 0x12),
    Ъъ('Ъ','ъ', (byte) 0x30),
    Ыы('Ы','ы', (byte) 0x16),
    Ьь('Ь','ь', (byte) 0x10),
    Ээ('Э','э', (byte) 0x34),
    Юю('Ю','ю', (byte) 0x37),
    Яя('Я','я', (byte) 0x1d),
    ;

    private final char capitalLetter;   // Заглавная буква
    private final char smallLetter;   // Строчная буква
    private final byte hidKey;   // HID-код буквы

    /**
     * Создание русской буквы.
     * @author Namespace Stedd
     * @param capitalLetter заглавная буква
     * @param smallLetter строчная буква
     * @param hidKey HID-код буквы
     */
    RussianLetter(char capitalLetter, char smallLetter, byte hidKey) {
        this.capitalLetter = capitalLetter;
        this.smallLetter = smallLetter;
        this.hidKey = hidKey;
    }

    /**
     * Получение заглавной буквы.
     * @author Namespace Stedd
     * @return заглавная буква
     */
    @Override
    public char getCapitalLetter() {
        return this.capitalLetter;
    }

    /**
     * Получение строчной буквы.
     * @author Namespace Stedd
     * @return строчная буква
     */
    @Override
    public char getSmallLetter() {
        return this.smallLetter;
    }

    /**
     * Получение HID-кода буквы.
     * @author Namespace Stedd
     * @return HID-код буквы
     */
    @Override
    public byte getHidKey() {
        return this.hidKey;
    }

}
