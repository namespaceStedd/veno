package namespace.stedd.data.type.bytecode;

import namespace.stedd.data.type.ExoByte;

/**
 * Циклический избыточный код.
 * @author Namespace Stedd
 */
public class CyclicRedundancyCheck {

    /**
     * Подсчет контрольной суммы CRC-16-CCITT.
     * @author Namespace Stedd
     * @param bytes данные подсчёта
     */
    public static byte[] crc16Ccitt(byte... bytes) {
        // Предустановки
        CrcType crcType = CrcType.CRC16CCITT;
        int preset = crcType.getPreset();
        int polynomial = crcType.getPolynomial();
        int multiplier = crcType.getMultiplier();
        // Предустановки
        int crc = preset;
        // Перебор
        for (byte bytee : bytes) {
            crc ^= bytee << 0x08;
            for (int j = 0; j < 8; j++) {
                if ((crc & multiplier) != 0) {
                    crc = (crc << 1) ^ polynomial;
                }
                else {
                    crc = crc << 1;
                }
            }
        }
        // Возврат
        return ExoByte.parseByteArray(crc & 0xffff, 2);
    }

    /**
     * Подсчет контрольной суммы CRC-16-ISO-IEC-14443-3-B.
     * @author Namespace Stedd
     * @param bytes данные подсчёта
     */
    public static byte[] crc16Iso14443(byte... bytes) {
        // Предустановки
        CrcType crcType = CrcType.CRC16ISO14443;
        int crc = crcType.getPreset();
        int polynomial = crcType.getPolynomial();
        int multiplier = crcType.getMultiplier();
        // Предустановки
        for (byte bytee : bytes) {
            crc ^= bytee & 0xff;
            for (int j = 0; j < 8; j++) {
                if ((crc & multiplier) != 0) {
                    crc = (crc >>> 1) ^ polynomial;
                }
                else {
                    crc = crc >>> 1;
                }
            }
        }
        // Возврат
        return ExoByte.parseByteArray(~crc & 0xffff, 2);
    }

    /**
     * Подсчет контрольной суммы CRC-16-MODBUS.
     * @author Namespace Stedd
     * @param bytes данные подсчёта
     */
    public static byte[] crc16Modbus(byte... bytes) {
        // Предустановки
        CrcType crcType = CrcType.CRC16MODBUS;
        int crc = crcType.getPreset();
        int polynomial = crcType.getPolynomial();
        int multiplier = crcType.getMultiplier();
        // Предустановки
        for (byte bytee : bytes) {
            crc ^= bytee & 0xff;
            for (int j = 0; j < 8; j++) {
                if ((crc & multiplier) != 0) {
                    crc = (crc >>> 1) ^ polynomial;
                }
                else {
                    crc = crc >>> 1;
                }
            }
        }
        // Возврат
        return ExoByte.parseByteArray(crc & 0xffff, 2);
    }

}
