package namespace.stedd.data.type.bytecode;

import namespace.stedd.data.type.ExoByte;

/**
 * Перечисление типов циклических избыточных кодов.
 * @author Namespace Stedd
 */
public enum CrcType {
    CRC16CCITT(0xffff, 0x1021, 0x8000),   // CRC для X.25, HDLC, XMODEM, Bluetooth, SD и пр.
    CRC16ISO14443(0xffff, 0x8408, 0x0001),   // CRC для RFID на базе ISO-IEC-14443-3-B
    CRC16MODBUS(0xffff, 0xa001, 0x0001),   // CRC для Modbus
    ;

    private final int preset;   // Предустановленная контрольная сумма
    private final int polynomial;   // Многочлен контрольной суммы
    private final int multiplier;   // Множитель контрольной суммы

    /**
     * Создание типа циклического избыточного кода.
     * @author Namespace Stedd
     * @param preset предустановленная контрольная сумма
     * @param polynomial многочлен контрольной суммы
     * @param multiplier множитель контрольной суммы
     */
    CrcType(int preset, int polynomial, int multiplier) {
        this.preset = preset;
        this.polynomial = polynomial;
        this.multiplier = multiplier;
    }

    /**
     * Получение предустановленной контрольной суммы.
     * @author Namespace Stedd
     * @return предустановленная контрольная сумма
     */
    public int getPreset() {
        return this.preset;
    }

    /**
     * Получение многочлена контрольной суммы.
     * @author Namespace Stedd
     * @return многочлен контрольной суммы
     */
    public int getPolynomial() {
        return this.polynomial;
    }

    /**
     * Получение множителя контрольной суммы.
     * @author Namespace Stedd
     * @return множитель контрольной суммы
     */
    public int getMultiplier() {
        return this.multiplier;
    }

    /**
     * Подсчет контрольной суммы.
     * @author Namespace Stedd
     * @param bytes данные подсчёта
     */
    public byte[] calculateFor(byte... bytes) {
        return switch (this) {
            case CRC16CCITT -> CyclicRedundancyCheck.crc16Ccitt(bytes);
            case CRC16ISO14443 -> CyclicRedundancyCheck.crc16Iso14443(bytes);
            case CRC16MODBUS -> CyclicRedundancyCheck.crc16Modbus(bytes);
        };
    }

    /**
     * Подсчет контрольной суммы.
     * @author Namespace Stedd
     * @param reverse необходимость записать контрольную сумму в обратном порядке
     * @param bytes данные подсчёта
     */
    public byte[] calculate(boolean reverse, byte... bytes) {
        byte[] crc = this.calculateFor(bytes);
        return reverse ? ExoByte.reverseArray(crc) : crc;
    }

}
