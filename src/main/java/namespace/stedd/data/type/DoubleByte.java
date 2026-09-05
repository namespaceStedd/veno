package namespace.stedd.data.type;

/**
 * Удвоенный байт с хранением двух регистров в одном типе данных.
 * @author Namespace Stedd
 */
public class DoubleByte {

    protected byte high;   // Верхний регистр
    protected byte low;   // Нижний регистр

    /**
     * Создание удвоенного байта.
     * @author Namespace Stedd
     * @param high верхний регистр
     * @param low нижний регистр
     */
    public DoubleByte(byte high, byte low) {
        this.high = high;
        this.low = low;
    }

    /**
     * Создание удвоенного байта.
     * @author Namespace Stedd
     * @param high верхний регистр
     * @param low нижний регистр
     * @return удвоенный байт
     */
    public static DoubleByte of(byte high, byte low) {
        return new DoubleByte(high, low);
    }

    /**
     * Создание массива удвоенных байт.
     * @author Namespace Stedd
     * @param bytes массив байт
     * @return массив удвоенных байт
     */
    public static DoubleByte[] of(byte... bytes) {
        if (bytes.length % 2 != 0) {
            bytes = ExoByte.mergeByteArrays(new byte[] { 0x00 }, bytes);
        }
        DoubleByte[] doubleBytes = new DoubleByte[bytes.length / 2];
        for (int i = 0; i < bytes.length; i += 2) {
            doubleBytes[i / 2] = DoubleByte.of(bytes[i], bytes[i + 1]);
        }
        return doubleBytes;
    }

    /**
     * Создание удвоенного байта.
     * @author Namespace Stedd
     * @param number целое число
     * @return удвоенный байт
     */
    public static DoubleByte of(long number) {
        byte low = (byte) (number % 256);
        return of((byte) ((number / 256) & 0xff), low);
    }

    /**
     * Получение регистров в виде массива байт.
     * @author Namespace Stedd
     * @return массив байт пары регистров
     */
    public byte[] getBytes() {
        return new byte[] { this.high, this.low };
    }

    /**
     * Получение верхнего регистра.
     * @author Namespace Stedd
     * @return верхний регистр
     */
    public byte high() {
        return this.high;
    }

    /**
     * Получение верхнего регистра.
     * @author Namespace Stedd
     * @return верхний регистр
     */
    public byte getHigh() {
        return this.high;
    }

    /**
     * Получение нижнего регистра.
     * @author Namespace Stedd
     * @return нижний регистр
     */
    public byte low() {
        return this.low;
    }

    /**
     * Получение нижнего регистра.
     * @author Namespace Stedd
     * @return нижний регистр
     */
    public byte getLow() {
        return this.low;
    }

    /**
     * Преобразование удвоенного байта в малое целое число.
     * @author Namespace Stedd
     * @return малый целочисленный удвоенный байт
     */
    public short toShort() {
        return (short) this.toInteger();
    }

    /**
     * Преобразование удвоенного байта в целое число.
     * @author Namespace Stedd
     * @return целочисленный удвоенный байт
     */
    public int toInteger() {
        return (this.high << 8 & 0xff00 | this.low & 0xff);
    }

    /**
     * Преобразование удвоенного байта в большое целое число.
     * @author Namespace Stedd
     * @return большой целочисленный удвоенный байт
     */
    public int toLong() {
        return this.toInteger();
    }

    /**
     * Преобразование удвоенного байта в строку.
     * @author Namespace Stedd
     * @return строчный удвоенный байт
     */
    @Override
    public String toString() {
        return ExoByte.bytesToHexString(this.high, this.low);
    }

}
