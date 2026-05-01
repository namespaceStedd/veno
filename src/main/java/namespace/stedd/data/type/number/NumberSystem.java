package namespace.stedd.data.type.number;

import namespace.stedd.data.lang.Alphabet;
import namespace.stedd.data.lang.AlphabetRule;

/**
 * Управление системами счисления.
 * @author Namespace Stedd
 */
public class NumberSystem {

    /**
     * Получение всех возможных цифр десятичной системы счисления.
     * @author Namespace Stedd
     * @return все возможные цифры
     */
    public static char[] getAllDecimalDigits() {
        char[] digits = new char[10];
        for (int i = 0; i < 10; i++) {
            digits[i] = (char) (i + '0');
        }
        return digits;
    }

    /**
     * Получение алфавита указанной системы счисления.
     * @author Namespace Stedd
     * @param numberSystem система счисления
     * @return алфавит системы счисления
     */
    public static char[] getAlphabet(int numberSystem) {
        if (numberSystem <= 0) {
            return new char[0];
        }
        char[] digits = getAllDecimalDigits();
        Alphabet latin = Alphabet.Latin;
        numberSystem = java.lang.Math.min(numberSystem, digits.length + latin.getAlphabetLength());
        if (digits.length < numberSystem) {
            return latin.getFirstLetters(numberSystem - digits.length, AlphabetRule.LowerCaseOnly, digits);
        }
        char[] alphabet = new char[numberSystem];
        System.arraycopy(digits, 0, alphabet, 0, numberSystem);
        return alphabet;
    }

}
