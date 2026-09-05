package namespace.stedd.data.lang;

import namespace.stedd.data.lang.pack.LatinLetter;
import namespace.stedd.data.lang.pack.RussianLetter;
import namespace.stedd.data.type.ExoNumber;

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
     * Получение случайной буквы из нескольких алфавитов.
     * @author Namespace Stedd
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return случайная буква
     */
    public static Letter randomAlphabetLetter(Alphabet... alphabets) {
        if (alphabets.length == 0) {
            alphabets = Alphabet.values();
        }
        int alphabet = ExoNumber.random.nextInt(alphabets.length);
        return alphabets[alphabet].randomAlphabetLetter();
    }

    /**
     * Получение случайной буквы из нескольких алфавитов.
     * @author Namespace Stedd
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return случайная буква
     */
    public static char randomLetter(Alphabet... alphabets) {
        return randomLetter(true, true, alphabets);
    }

    /**
     * Получение случайной буквы из нескольких алфавитов.
     * @author Namespace Stedd
     * @param includeCapitalLetters включая заглавные буквы
     * @param includeSmallLetters включая строчные буквы
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return случайная буква
     */
    public static char randomLetter(boolean includeCapitalLetters, boolean includeSmallLetters, Alphabet... alphabets) {
        if (alphabets.length == 0) {
            alphabets = Alphabet.values();
            // return Character.MIN_VALUE;
        }
        int letter = ExoNumber.random.nextInt(alphabets.length);
        return alphabets[letter].randomLetter(includeCapitalLetters, includeSmallLetters);
    }

    /**
     * Получение случайной заглавной буквы из нескольких алфавитов.
     * @author Namespace Stedd
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return случайная заглавная буква
     */
    public static char randomCapitalLetter(Alphabet... alphabets) {
        return randomLetter(true, false, alphabets);
    }

    /**
     * Получение случайной строчной буквы из нескольких алфавитов.
     * @author Namespace Stedd
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return случайная строчная буква
     */
    public static char randomSmallLetter(Alphabet... alphabets) {
        return randomLetter(false, true, alphabets);
    }

    /**
     * Получение массива случайных букв из нескольких алфавитов.
     * @author Namespace Stedd
     * @param length количество букв
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return массив случайных букв
     */
    public static Letter[] randomAlphabetLetters(int length, Alphabet... alphabets) {
        Letter[] letters = new Letter[length];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = randomAlphabetLetter(alphabets);
        }
        return letters;
    }

    /**
     * Получение массива случайных букв из нескольких алфавитов.
     * @author Namespace Stedd
     * @param length количество букв
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return массив случайных букв
     */
    public static char[] randomLetters(int length, Alphabet... alphabets) {
        return randomLetters(length, true, true, alphabets);
    }

    /**
     * Получение массива случайных букв из нескольких алфавитов.
     * @author Namespace Stedd
     * @param length количество букв
     * @param includeCapitalLetters включая заглавные буквы
     * @param includeSmallLetters включая строчные буквы
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return массив случайных букв
     */
    public static char[] randomLetters(int length, boolean includeCapitalLetters, boolean includeSmallLetters, Alphabet... alphabets) {
        char[] letters = new char[length];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = randomLetter(includeCapitalLetters, includeSmallLetters, alphabets);
        }
        return letters;
    }

    /**
     * Получение массива случайных букв из нескольких алфавитов.
     * @author Namespace Stedd
     * @param length количество букв
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return массив случайных букв
     */
    public static char[] randomCapitalLetters(int length, Alphabet... alphabets) {
        return randomLetters(length, true, false, alphabets);
    }

    /**
     * Получение массива случайных строчных букв из нескольких алфавитов.
     * @author Namespace Stedd
     * @param length количество букв
     * @param alphabets перечисление поддерживаемых алфавитов
     * @return массив случайных строчных букв
     */
    public static char[] randomSmallLetters(int length, Alphabet... alphabets) {
        return randomLetters(length, false, true, alphabets);
    }

    /**
     * Получение случайной буквы алфавита.
     * @author Namespace Stedd
     * @return случайная буква алфавита
     */
    public Letter randomAlphabetLetter() {
        if (this.letters.length == 0) {
            return Letter.EMPTY;
        }
        int random = ExoNumber.random.nextInt(this.letters.length);
        return this.letters[random];
    }

    /**
     * Получение случайной буквы алфавита.
     * @author Namespace Stedd
     * @return случайная буква алфавита
     */
    public char randomLetter() {
        return this.randomLetter(true, true);
    }

    /**
     * Получение случайной буквы алфавита.
     * @author Namespace Stedd
     * @param includeCapitalLetters включая заглавные буквы
     * @param includeSmallLetters включая строчные буквы
     * @return случайная буква алфавита
     */
    public char randomLetter(boolean includeCapitalLetters, boolean includeSmallLetters) {
        if (!includeCapitalLetters && !includeSmallLetters) {
            return '0';
        }
        Letter randomLetter = this.randomAlphabetLetter();
        if (includeCapitalLetters && includeSmallLetters) {
            return ExoNumber.random.nextBoolean() ?
                    randomLetter.getCapitalLetter() :
                    randomLetter.getSmallLetter();
        }
        else if (includeCapitalLetters) {
            return randomLetter.getCapitalLetter();
        }
        else {
            return randomLetter.getSmallLetter();
        }
    }

    /**
     * Получение случайной заглавной буквы алфавита.
     * @author Namespace Stedd
     * @return случайная заглавная буква алфавита
     */
    public char randomCapitalLetter() {
        return this.randomLetter(true, false);
    }

    /**
     * Получение случайной строчной буквы алфавита.
     * @author Namespace Stedd
     * @return случайная строчной буква алфавита
     */
    public char randomSmallLetter() {
        return this.randomLetter(false, true);
    }

    /**
     * Получение массива случайных букв алфавита.
     * @author Namespace Stedd
     * @param length количество букв
     * @return массив случайных букв алфавита
     */
    public Letter[] randomAlphabetLetters(int length) {
        Letter[] letters = new Letter[length];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = this.randomAlphabetLetter();
        }
        return letters;
    }

    /**
     * Получение массива случайных букв алфавита.
     * @author Namespace Stedd
     * @param length количество букв
     * @return массив случайных букв алфавита
     */
    public char[] randomLetters(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = this.randomLetter();
        }
        return chars;
    }

    /**
     * Получение массива случайных букв алфавита.
     * @author Namespace Stedd
     * @param length количество букв
     * @param includeCapitalLetters включая заглавные буквы
     * @param includeSmallLetters включая строчные буквы
     * @return массив случайных букв алфавита
     */
    public char[] randomLetters(int length, boolean includeCapitalLetters, boolean includeSmallLetters) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = this.randomLetter(includeCapitalLetters, includeSmallLetters);
        }
        return chars;
    }

    /**
     * Получение массива случайных заглавных букв алфавита.
     * @author Namespace Stedd
     * @param length количество букв
     * @return массив случайных заглавных букв алфавита
     */
    public char[] randomCapitalLetters(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = this.randomCapitalLetter();
        }
        return chars;
    }

    /**
     * Получение массива случайных строчных букв алфавита.
     * @author Namespace Stedd
     * @param length количество букв
     * @return массив случайных строчных букв алфавита
     */
    public char[] randomSmallLetters(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = this.randomSmallLetter();
        }
        return chars;
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
