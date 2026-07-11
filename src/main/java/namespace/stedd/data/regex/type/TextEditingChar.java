package namespace.stedd.data.regex.type;

/**
 * Перечисление символов редактирования текста RegEx.
 * @author Namespace Stedd
 */
public enum TextEditingChar {

    /*
     * Метасимвол	Назначение
     * \t	символ табуляции
     * \n	символ новой строки
     * \r	символ возврата каретки
     * \f	переход на новую страницу
     * \u0085	символ следующей строки
     * \u2028	символ разделения строк
     * \u2029	символ разделения абзацев
     */

    /**
     * Символ табуляции.
     */
    TAB("\\t"),

    /**
     * Символ новой строки.
     */
    NEW_LINE("\\n"),

    /**
     * Символ возврата каретки.
     */
    CARRIAGE_RETURN("\\r"),

    /**
     * Символ перехода на новую страницу.
     */
    NEW_PAGE("\\f"),

    /**
     * Символ следующей строки.
     */
    NEXT_LINE("\\u0085"),

    /**
     * Символ разделения строк.
     */
    LINE_SPLITTING("\\u2028"),

    /**
     * Символ разделения абзацев.
     */
    PARAGRAPH_SPLITTING("\\u2029"),

    ;

    /**
     * Символ RegEx.
     */
    private final String regexChar;

    /**
     * Создание символов редактирования текста RegEx.
     * @author Namespace Stedd
     * @param regexChar символ RegEx
     */
    TextEditingChar(String regexChar) {
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
