package namespace.stedd.data.lang;

import namespace.stedd.data.lang.pack.LatinLetter;
import namespace.stedd.data.lang.pack.RussianLetter;

import static namespace.stedd.data.lang.AlphabetRule.*;

/**
 * Перечисление поддерживаемых алфавитов.
 * @author Namespace Stedd
 */
public enum Alphabet {

    Russian(RussianLetter.values()),   // Русский алфавит
    Latin(LatinLetter.values()),   // Латинский алфавит
    ;

    private final Letter[] letters;   // Буквы алфавита

    /**
     * Создание поддерживаемого алфавита.
     * @author Namespace Stedd
     * @param letters буквы алфавита
     */
    Alphabet(Letter... letters) {
        this.letters = letters;
    }

    /**
     * Получение размера алфавита.
     * @author Namespace Stedd
     * @return размер алфавита
     */
    public int getAlphabetLength() {
        return this.letters.length;
    }

    /**
     * Получение всех символов алфавита.
     * @author Namespace Stedd
     * @return полный алфавит
     */
    public char[] getAlphabet() {
        return this.getAlphabet(ForwardOrder);
    }

    /**
     * Получение всех символов алфавита.
     * @author Namespace Stedd
     * @param rule порядок отображения алфавита
     * @return полный алфавит
     */
    public char[] getAlphabet(AlphabetRule rule) {
        return switch (rule) {
            case ForwardOrder -> {
                char[] chars = new char[2 * this.letters.length];
                for (int i = 0; i < this.letters.length; i++) {
                    chars[2 * i] = this.letters[i].getCapitalLetter();
                    chars[2 * i + 1] = this.letters[i].getSmallLetter();
                }
                yield chars;
            }
            case ReverseOrder -> {
                char[] chars = new char[2 * this.letters.length];
                for (int i = 0; i < this.letters.length; i++) {
                    chars[2 * i] = this.letters[this.letters.length - 1 - i].getCapitalLetter();
                    chars[2 * i + 1] = this.letters[this.letters.length - 1 - i].getSmallLetter();
                }
                yield chars;
            }
            case SplitLetterCases -> {
                char[] chars = new char[2 * this.letters.length];
                for (int i = 0; i < this.letters.length; i++) {
                    chars[i] = this.letters[i].getCapitalLetter();
                    chars[i + this.letters.length] = this.letters[i].getSmallLetter();
                }
                yield chars;
            }
            case UpperCaseOnly -> {
                char[] chars = new char[this.letters.length];
                for (int i = 0; i < this.letters.length; i++) {
                    chars[i] = this.letters[i].getCapitalLetter();
                }
                yield chars;
            }
            case LowerCaseOnly -> {
                char[] chars = new char[this.letters.length];
                for (int i = 0; i < this.letters.length; i++) {
                    chars[i] = this.letters[i].getSmallLetter();
                }
                yield chars;
            }
        };
    }

    /**
     * Получение всех символов алфавита.
     * @author Namespace Stedd
     * @param rule порядок отображения алфавита
     * @return полный алфавит
     */
    public char[] getAlternativeAlphabet(AlphabetRule rule) {
        int coefficient = rule.equals(UpperCaseOnly, LowerCaseOnly) ? 1 : 2;
        char[] alphabet = new char[coefficient * this.letters.length];
        for (int i = 0; i < this.letters.length; i++) {
            int index = rule.equals(ReverseOrder) ? this.letters.length - 1 - i : i;
            alphabet[(rule.equals(SplitLetterCases) ? 1 : coefficient) * i] = rule.equals(LowerCaseOnly) ?
                    this.letters[index].getSmallLetter() :
                    this.letters[index].getCapitalLetter();
            switch (rule) {
                case ForwardOrder, ReverseOrder -> alphabet[2 * i + 1] = this.letters[index].getSmallLetter();
                case SplitLetterCases -> alphabet[i + this.letters.length] = this.letters[index].getSmallLetter();
            }
        }
        return alphabet;
    }

    /**
     * Получение первых символов алфавита.
     * @author Namespace Stedd
     * @param length количество первых символов
     * @return начальные символы алфавита
     */
    public char[] getFirstLetters(int length) {
        return this.getFirstLetters(length, ForwardOrder);
    }

    /**
     * Получение первых символов алфавита.
     * @author Namespace Stedd
     * @param length количество первых символов
     * @param beginningChars начальные символы
     * @return начальные символы алфавита
     */
    public char[] getFirstLetters(int length, char... beginningChars) {
        return this.getFirstLetters(length, ForwardOrder, beginningChars);
    }

    /**
     * Получение первых символов алфавита.
     * @author Namespace Stedd
     * @param length количество первых символов
     * @param rule порядок отображения алфавита
     * @param beginningChars начальные символы
     * @return начальные символы алфавита
     */
    public char[] getFirstLetters(int length, AlphabetRule rule, char... beginningChars) {
        length = Math.min(Math.max(length, 0), this.letters.length);
        char[] firstLetters = new char[length + beginningChars.length];
        System.arraycopy(beginningChars, 0, firstLetters, 0, beginningChars.length);
        char[] alphabet = this.getAlphabet(rule);
        System.arraycopy(alphabet, 0, firstLetters, beginningChars.length, length);
        return firstLetters;
    }

    /**
     * Преобразование алфавита в строку.
     * @author Namespace Stedd
     * @return строчный алфавит
     */
    @Override
    public String toString() {
        return String.valueOf(this.getAlphabet());
    }

}
