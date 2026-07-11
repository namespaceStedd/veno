package namespace.stedd.data.regex.type;

/**
 * Перечисление типов символов RegEx.
 * @author Namespace Stedd
 */
public enum CharType {

    /*
     * Метасимвол	Назначение
     * \d	цифровой символ
     * \D	нецифровой символ
     * \s	символ пробела
     * \S	непробельный символ
     * \w	буквенно-цифровой символ или знак подчёркивания
     * \W	любой символ, кроме буквенного, цифрового или знака подчёркивания
     * .	любой символ
     */

    /**
     * Цифровой символ.
     */
    DIGIT("\\d"),

    /**
     * Нецифровой символ.
     */
    NOT_DIGIT("\\D"),

    /**
     * Символ пробела.
     */
    SPACE("\\s"),

    /**
     * Непробельный символ.
     */
    NOT_SPACE("\\S"),

    /**
     * Буквенно-цифровой символ или знак подчёркивания.
     */
    WORD_OR_DIGIT_OR_UNDERLINING("\\w"),

    /**
     * Любой символ, кроме буквенного, цифрового или знака подчёркивания.
     */
    NOT_WORD_AND_NOT_DIGIT_AND_NOT_UNDERLINING("\\W"),

    /**
     * Любой символ.
     */
    ANY_CHAR("."),

    ;

    /**
     * Символ RegEx.
     */
    private final String regexChar;

    /**
     * Создание типа символов RegEx.
     * @author Namespace Stedd
     * @param regexChar символ RegEx
     */
    CharType(String regexChar) {
        this.regexChar = regexChar;
    }

    /**
     * Получение символа RegEx.
     * @author Namespace Stedd
     * @return символ RegEx
     */
    public String getRegexChar() {
        return this.regexChar;
    }

}
