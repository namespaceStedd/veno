package namespace.stedd.data.regex.type;

/**
 * Перечисление квантификаторов (обозначений количества символов) RegEx.
 * @author Namespace Stedd
 */
public enum QuantifierType {

    /*
     * Метасимвол	Назначение
     * ?	один или отсутствует
     * *	ноль или более раз
     * +	один или более раз
     * {n}	n раз
     * {n,}	n раз и более
     * {n,m}	не менее n раз и не более m раз
     */

    /**
     * Один или отсутствует.
     */
    ONE_OR_LESS("?"),

    /**
     * Ноль или более раз.
     */
    ZERO_OR_MORE("*"),

    /**
     * Один или более раз.
     */
    ONE_OR_MORE("+"),

    /**
     * Указанное n раз.
     */
    N_TIMES("{n}"),

    /**
     * Указанное n раз и более.
     */
    N_OR_MORE_TIMES("{n,}"),

    /**
     * Указанное не менее n раз и не более m раз.
     */
    N_TO_M_TIMES("{n,m}"),

    ;

    /**
     * Символ RegEx.
     */
    private final String regexChar;

    /**
     * Создание квантификатора (обозначений количества символов) RegEx.
     * @author Namespace Stedd
     * @param regexChar символ RegEx
     */
    QuantifierType(String regexChar) {
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
