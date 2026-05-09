package namespace.stedd.data.type;

import namespace.stedd.data.type.number.Math;

/**
 * Расширенное представление байта.
 * @author Namespace Stedd
 */
public class ExoByte extends Number {

    private Byte bytee;   // Представляемый байт

    /**
     * Создание несуществующего представляемого байта.
     * @author Namespace Stedd
     */
    public ExoByte() {
        this.bytee = null;
    }

    /**
     * Создание представляемого байта.
     * @author Namespace Stedd
     * @param bytee представляемый байт
     */
    public ExoByte(byte bytee) {
        this.bytee = bytee;
    }

    /**
     * Создание представляемого байта.
     * @author Namespace Stedd
     * @param bytee представляемый байт
     * @return расширенное представление байта
     */
    public static ExoByte create(byte bytee) {
        return new ExoByte(bytee);
    }

    /**
     * Получение представляемого байта.
     * @author Namespace Stedd
     * @return представляемый байт
     */
    public Byte getByte() {
        return this.bytee;
    }

    /**
     * Получение представляемого байта.
     * @author Namespace Stedd
     * @param ifNull если текущее значение NULL
     * @return представляемый байт
     */
    public double getByte(byte ifNull) {
        return this.bytee != null ? this.bytee : ifNull;
    }

    /**
     * Обновление представляемого байта.
     * @author Namespace Stedd
     * @param bytee представляемый байт
     */
    public void setByte(Byte bytee) {
        this.bytee = bytee;
    }

    /**
     * Преобразование объекта в байт-числовое значение с проверкой на NULL.
     * @author Namespace Stedd
     * @param byteable подвергающийся байтоочислению объект
     * @param ifNull значение при пустом объекте
     * @return байт-числовое значение
     */
    public static byte parseByte(Object byteable, byte ifNull) {
        return parseByte(byteable, Byte.valueOf(ifNull));
    }

    /**
     * Преобразование объекта в байт-числовое значение с проверкой на NULL.
     * @author Namespace Stedd
     * @param byteable подвергающийся байтоочислению объект
     * @param ifNull значение при пустом объекте
     * @return байт-числовое значение
     */
    public static Byte parseByte(Object byteable, Byte ifNull) {
        String byteableString = ExoString.parseString(byteable, ExoString.parseString(ifNull, null));
        return ExoString.notNullStatus(byteableString) ? Byte.parseByte(byteableString.split("\\.")[0]) : ifNull;
    }

    /**
     * Returns the value of the specified number as an {@code int}.
     *
     * @return  the numeric value represented by this object after conversion
     *          to type {@code int}.
     */
    @Override
    public int intValue() {
        return (int) this.longValue();
    }

    /**
     * Получение большого целого числа из массива байт.
     * @author Namespace Stedd
     * @param bytes массив байт
     * @return большое целое число
     */
    public static long parseLong(byte... bytes) {
        long integer = 0;
        int lastByte = bytes.length - 1;
        for (int i = lastByte; i >= 0; i--) {
            int pow = lastByte - i;
            integer += (long) ((bytes[i] & 0xFF) * java.lang.Math.pow(256, pow));
        }
        return integer;
    }

    /**
     * Returns the value of the specified number as a {@code long}.
     *
     * @return  the numeric value represented by this object after conversion
     *          to type {@code long}.
     */
    @Override
    public long longValue() {
        return this.bytee;
    }

    /**
     * Returns the value of the specified number as a {@code float}.
     *
     * @return  the numeric value represented by this object after conversion
     *          to type {@code float}.
     */
    @Override
    public float floatValue() {
        return (float) this.doubleValue();
    }

    /**
     * Returns the value of the specified number as a {@code double}.
     *
     * @return  the numeric value represented by this object after conversion
     *          to type {@code double}.
     */
    @Override
    public double doubleValue() {
        return this.bytee;
    }

    /**
     * Преобразование большого целого числа в массив байт.
     * @author Namespace Stedd
     * @param integer большое целое число
     * @return массив байт
     */
    public static byte[] parseByteArray(long integer) {
        int digits = (int) java.lang.Math.floor(Math.getNumberDegree(java.lang.Math.abs(integer), 256).doubleValue());
        byte[] bytes = new byte[digits + 1];
        for (; integer != 0 && digits >= 0; integer /= 256, digits--) {
            bytes[digits] = (byte) (integer % 256);
        }
        return bytes;
    }

    /**
     * Преобразование большого целого числа в массив байт.
     * @author Namespace Stedd
     * @param integer большое целое число
     * @param minBytesLength минимально возможное число байт
     * @return массив байт
     */
    public static byte[] parseByteArray(long integer, int minBytesLength) {
        byte[] bytes = parseByteArray(integer);
        return bytes.length < minBytesLength ? mergeByteArrays(repeat(minBytesLength - bytes.length, (byte) 0x00), bytes) : bytes;
    }

    /**
     * Преобразование большого целого числа в массив байт.
     * @author Namespace Stedd
     * @param integer большое целое число
     * @param reverse необходимость изменить порядок массива на противоположный
     * @return массив байт
     */
    public static byte[] parseByteArray(long integer, boolean reverse) {
        return parseByteArray(integer, 0, reverse);
    }

    /**
     * Преобразование большого целого числа в массив байт.
     * @author Namespace Stedd
     * @param integer большое целое число
     * @param minBytesLength минимально возможное число байт
     * @param reverse необходимость изменить порядок массива на противоположный
     * @return массив байт
     */
    public static byte[] parseByteArray(long integer, int minBytesLength, boolean reverse) {
        byte[] bytes = parseByteArray(integer, minBytesLength);
        return reverse ? reverseArray(bytes) : bytes;
    }

    /**
     * Преобразование массива в обратный.
     * @author Namespace Stedd
     * @param array исходный массив
     * @return обратный массив
     */
    public static byte[] reverseArray(byte... array) {
        byte[] reverseArray = new byte[array.length];
        for (int i = 0, j = array.length - 1; i < reverseArray.length; i++, j--) {
            reverseArray[i] = array[j];
        }
        return reverseArray;
    }

    /**
     * Преобразование массива байт в бинарную строку.
     * @author Namespace Stedd
     * @param bytes массив байт
     * @return полученная бинарная строка
     */
    public static String bytesToBinaryString(byte... bytes) {
        return bytesToBinaryString("", bytes);
    }

    /**
     * Преобразование массива байт в бинарную строку.
     * @author Namespace Stedd
     * @param delimiter разделитель байт в бинарной строке
     * @param bytes массив байт
     * @return полученная бинарная строка
     */
    public static String bytesToBinaryString(String delimiter, byte... bytes) {
        StringBuilder binaryString = new StringBuilder();
        for (byte bytee : bytes) {
            binaryString.append(String.format("%8s", Integer.toBinaryString(bytee & 0xff)).replace(' ', '0')).append(delimiter);
        }
        int startDeletePosition = java.lang.Math.max(binaryString.length() - delimiter.length(), 0),
                endDeletePosition = java.lang.Math.max(binaryString.length(), 0);
        return binaryString.delete(startDeletePosition, endDeletePosition).toString();
    }

    /**
     * Преобразование бинарной строки в байт.
     * @author Namespace Stedd
     * @param binaryString бинарная строка
     * @return полученный байт
     */
    public static byte binaryStringToByte(String binaryString) {
        return binaryStringToByte("", binaryString, (byte) 0);
    }

    /**
     * Преобразование бинарной строки в байт.
     * @author Namespace Stedd
     * @param delimiter разделитель байт в бинарной строке
     * @param binaryString бинарная строка
     * @return полученный байт
     */
    public static byte binaryStringToByte(String delimiter, String binaryString) {
        return binaryStringToByte(delimiter, binaryString, (byte) 0);
    }

    /**
     * Преобразование бинарной строки в байт.
     * @author Namespace Stedd
     * @param binaryString бинарная строка
     * @param ifEmpty байт по умолчанию при пустом массиве
     * @return полученный байт
     */
    public static byte binaryStringToByte(String binaryString, byte ifEmpty) {
        return binaryStringToByte("", binaryString, ifEmpty);
    }

    /**
     * Преобразование бинарной строки в байт.
     * @author Namespace Stedd
     * @param delimiter разделитель байт в бинарной строке
     * @param binaryString бинарная строка
     * @param ifEmpty байт по умолчанию при пустом массиве
     * @return полученный байт
     */
    public static byte binaryStringToByte(String delimiter, String binaryString, byte ifEmpty) {
        byte[] bytes = binaryStringToBytes(delimiter, binaryString);
        return bytes.length < 1 ? ifEmpty : bytes[bytes.length - 1];
    }

    /**
     * Преобразование бинарной строки в массив байт.
     * @author Namespace Stedd
     * @param binaryString бинарная строка
     * @return полученный массив байт
     */
    public static byte[] binaryStringToBytes(String binaryString) {
        return binaryStringToBytes("", binaryString);
    }

    /**
     * Преобразование бинарной строки в массив байт.
     * @author Namespace Stedd
     * @param delimiter разделитель байт в бинарной строке
     * @param binaryString бинарная строка
     * @return полученный массив байт
     */
    public static byte[] binaryStringToBytes(String delimiter, String binaryString) {
        binaryString = binaryString.replaceAll(delimiter, "");
        int remainder = binaryString.length() % 8;
        if (remainder % 2 != 0) {
            binaryString = "0".repeat(8 - remainder) + binaryString;
        }
        byte[] bytes = new byte[binaryString.length() / 8];
        for (int i = 0; i < binaryString.length(); i += 8) {
            bytes[i / 8] = (byte) Integer.parseInt(binaryString.substring(i, i + 8), 2);
        }
        return bytes;
    }

    /**
     * Преобразование массива байт в строку HEX.
     * @author Namespace Stedd
     * @param bytes массив байт
     * @return полученная строка HEX
     */
    public static String bytesToHexString(byte... bytes) {
        return bytesToHexString("", bytes);
    }

    /**
     * Преобразование массива байт в строку HEX.
     * @author Namespace Stedd
     * @param delimiter разделитель байт в HEX-строке
     * @param bytes массив байт
     * @return полученная строка HEX
     */
    public static String bytesToHexString(String delimiter, byte... bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte bytee : bytes) {
            hexString.append(String.format("%02x", bytee & 0xff)).append(delimiter);
        }
        int startDeletePosition = java.lang.Math.max(hexString.length() - delimiter.length(), 0),
                endDeletePosition = java.lang.Math.max(hexString.length(), 0);
        return hexString.delete(startDeletePosition, endDeletePosition).toString();
    }

    /**
     * Преобразование строки HEX в байт.
     * @author Namespace Stedd
     * @param hexString строка HEX
     * @return полученный байт
     */
    public static byte hexStringToByte(String hexString) {
        return hexStringToByte("", hexString, (byte) 0);
    }

    /**
     * Преобразование строки HEX в байт.
     * @author Namespace Stedd
     * @param delimiter разделитель байт в HEX-строке
     * @param hexString строка HEX
     * @return полученный байт
     */
    public static byte hexStringToByte(String delimiter, String hexString) {
        return hexStringToByte(delimiter, hexString, (byte) 0);
    }

    /**
     * Преобразование строки HEX в байт.
     * @author Namespace Stedd
     * @param hexString строка HEX
     * @param ifEmpty байт по умолчанию при пустом массиве
     * @return полученный байт
     */
    public static byte hexStringToByte(String hexString, byte ifEmpty) {
        return hexStringToByte("", hexString, ifEmpty);
    }

    /**
     * Преобразование строки HEX в байт.
     * @author Namespace Stedd
     * @param delimiter разделитель байт в HEX-строке
     * @param hexString строка HEX
     * @param ifEmpty байт по умолчанию при пустом массиве
     * @return полученный байт
     */
    public static byte hexStringToByte(String delimiter, String hexString, byte ifEmpty) {
        byte[] bytes = hexStringToBytes(delimiter, hexString);
        return bytes.length < 1 ? ifEmpty : bytes[bytes.length - 1];
    }

    /**
     * Преобразование строки HEX в массив байт.
     * @author Namespace Stedd
     * @param hexString строка HEX
     * @return полученный массив байт
     */
    public static byte[] hexStringToBytes(String hexString) {
        return hexStringToBytes("", hexString);
    }

    /**
     * Преобразование строки HEX в массив байт.
     * @author Namespace Stedd
     * @param delimiter разделитель байт в HEX-строке
     * @param hexString строка HEX
     * @return полученный массив байт
     */
    public static byte[] hexStringToBytes(String delimiter, String hexString) {
        hexString = hexString.replaceAll(delimiter, "");
        if (hexString.length() % 2 != 0) {
            hexString = "0" + hexString;
        }
        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            bytes[i / 2] = (byte) Integer.parseInt(hexString.charAt(i) + "" + hexString.charAt(i + 1), 16);
        }
        return bytes;
    }

    /**
     * Объединение массивов байт в один.
     * @author Namespace Stedd
     * @param original исходный массив байт
     * @param joining присоединяющийся массив байт
     * @return единый массив байт
     */
    public static byte[] mergeByteArrays(byte[] original, byte... joining) {
        byte[] proletarians = new byte[original.length + joining.length];
        System.arraycopy(original, 0, proletarians, 0, original.length);
        System.arraycopy(joining, 0, proletarians, original.length, joining.length);
        return proletarians;
    }

    /**
     * Повторение массива байт указанное число раз.
     * @author Namespace Stedd
     * @param times количество раз
     * @param bytes исходный массив байт
     * @return повторённый массив байт
     */
    public static byte[] repeat(int times, byte... bytes) {
        byte[] repeated = new byte[0];
        for (int i = 0; i < times; i++) {
            repeated = mergeByteArrays(repeated, bytes);
        }
        return repeated;
    }

}
