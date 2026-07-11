package namespace.stedd.data.regex.type;

/**
 * Перечисление границ текста RegEx.
 * @author Namespace Stedd
 */
public enum TextBound {

    /*
     * Метасимвол	Назначение
     * ^	начало строки
     * $	конец строки
     * \b	граница слова
     * \B	не граница слова
     * \A	начало ввода
     * \G	конец предыдущего совпадения
     * \Z	конец ввода (до \n, как $)
     * \z	конец ввода (абсолютный конец строки)
     */

    /**
     * Начало строки.
     */
    STRING_BEGINNING("^"),

    /**
     * Конец строки.
     */
    STRING_ENDING("$"),

    /**
     * Граница слова.
     */
    WORD_BOUND("\\b"),

    /**
     * Не граница слова.
     */
    NOT_WORD_BOUND("\\B"),

    /**
     * Начало ввода.
     */
    INPUT_BEGINNING("\\A"),

    /**
     * Конец предыдущего совпадения.
     */
    LAST_MATCHING_ENDING("\\G"),

    /**
     * Конец ввода (до \n, как $).
     */
    INPUT_ENDING("\\Z"),

    /**
     * Конец ввода (абсолютный конец строки).
     */
    INPUT_ENDING_2("\\z"),

    ;

    /**
     * Символ RegEx.
     */
    private final String regexChar;

    /**
     * Создание границы текста RegEx.
     * @author Namespace Stedd
     * @param regexChar символ RegEx
     */
    TextBound(String regexChar) {
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
