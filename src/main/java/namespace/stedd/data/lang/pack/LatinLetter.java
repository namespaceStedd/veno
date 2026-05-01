package namespace.stedd.data.lang.pack;

import namespace.stedd.data.lang.Letter;

/**
 * Перечисление букв латинского алфавита.
 * @author Namespace Stedd
 */
public enum LatinLetter implements Letter {

    Aa('A','a', (byte) 0x04),
    Bb('B','b', (byte) 0x05),
    Cc('C','c', (byte) 0x06),
    Dd('D','d', (byte) 0x07),
    Ee('E','e', (byte) 0x08),
    Ff('F','f', (byte) 0x09),
    Gg('G','g', (byte) 0x0a),
    Hh('H','h', (byte) 0x0b),
    Ii('I','i', (byte) 0x0c),
    Jj('J','j', (byte) 0x0d),
    Kk('K','k', (byte) 0x0e),
    Ll('L','l', (byte) 0x0f),
    Mm('M','m', (byte) 0x10),
    Nn('N','n', (byte) 0x11),
    Oo('O','o', (byte) 0x12),
    Pp('P','p', (byte) 0x13),
    Qq('Q','q', (byte) 0x14),
    Rr('R','r', (byte) 0x15),
    Ss('S','s', (byte) 0x16),
    Tt('T','t', (byte) 0x17),
    Uu('U','u', (byte) 0x18),
    Vv('V','v', (byte) 0x19),
    Ww('W','w', (byte) 0x1a),
    Xx('X','x', (byte) 0x1b),
    Yy('Y','y', (byte) 0x1c),
    Zz('Z','z', (byte) 0x1d),
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
    LatinLetter(char capitalLetter, char smallLetter, byte hidKey) {
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
