package namespace.stedd.data.regex;

import namespace.stedd.data.type.ExoCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static namespace.stedd.data.regex.type.CharType.*;
import static namespace.stedd.data.regex.type.QuantifierType.*;
import static namespace.stedd.data.regex.type.TextBound.*;
import static namespace.stedd.data.regex.type.TextEditingChar.*;

/**
 * Регистратор RegEx.
 * @author Namespace Stedd
 */
public class RegEx {

    /**
     * Строка шаблона RegEx.
     */
    private final String regex;

    /**
     * Шаблон RegEx.
     */
    private final Pattern pattern;

    /**
     * Создание регистратора RegEx.
     * @author Namespace Stedd
     * @param regex строка шаблона RegEx
     */
    public RegEx(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(this.regex);
    }

    /**
     * Получение шаблона RegEx.
     * @author Namespace Stedd
     * @return шаблон RegEx
     */
    public Pattern getPattern() {
        return this.pattern;
    }

    /**
     * Получение поисковика совпадений RegEx по тексту.
     * @author Namespace Stedd
     * @param text текст
     * @return поисковик совпадений RegEx
     */
    public Matcher match(String text) {
        return this.pattern.matcher(text);
    }

    /**
     * Преобразование строки шаблона RegEx в строку.
     * @author Namespace Stedd
     * @return строка шаблона RegEx
     */
    @Override
    public String toString() {
        return this.regex;
    }

    /**
     * Создание Конструктора регистратора RegEx.
     * @author Namespace Stedd
     * @return Конструктор регистратора RegEx
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Создание Конструктора регистратора RegEx.
     * @author Namespace Stedd
     * @param stringStartsWithPattern показатель необходимости пометить начало строки во время формирования
     * @param stringEndsWithPattern показатель необходимости пометить конец строки во время формирования
     * @return Конструктор регистратора RegEx
     */
    public static Builder newBuilder(boolean stringStartsWithPattern, boolean stringEndsWithPattern) {
        return new Builder(stringStartsWithPattern, stringEndsWithPattern);
    }

    /**
     * Конструктор регистратора RegEx.
     * @author Namespace Stedd
     */
    public static class Builder {

        /**
         * Шаблон строки RegEx.
         */
        private final StringBuilder regex;

        /**
         * Показатель необходимости пометить конец строки во время формирования.
         */
        private final boolean stringEndsWithPattern;

        /**
         * Создание Конструктора регистратора RegEx.
         * @author Namespace Stedd
         */
        public Builder() {
            this.regex = new StringBuilder();
            this.stringEndsWithPattern = false;
        }

        /**
         * Создание Конструктора регистратора RegEx.
         * @author Namespace Stedd
         * @param stringStartsWithPattern показатель необходимости пометить начало строки во время формирования
         * @param stringEndsWithPattern показатель необходимости пометить конец строки во время формирования
         */
        public Builder(boolean stringStartsWithPattern, boolean stringEndsWithPattern) {
            this.regex = new StringBuilder(stringStartsWithPattern ? STRING_BEGINNING.getRegexChar() : "");
            this.stringEndsWithPattern = stringEndsWithPattern;
            // TODO: \\A \\Z \\z?
        }

        /**
         * Квантификация последнего шаблона.
         * @author Namespace Stedd
         * @param quantifierRegex шаблон строки RegEx квантификатора
         * @return Конструктор регистратора RegEx
         */
        private Builder quantify(String quantifierRegex) {
            this.regex.append(quantifierRegex);
            return this;
        }

        /**
         * Добавление рукописной части шаблона строки RegEx.
         * @author Namespace Stedd // TODO: Notifier -> public
         * @param regexPart часть шаблона строки RegEx
         * @return Конструктор регистратора RegEx
         */
        public Builder custom(String regexPart) {
            this.regex.append(regexPart);
            return this;
        }

        /**
         * Добавление строки.
         * @author Namespace Stedd
         * @param string добавляемая строка
         * @return Конструктор регистратора RegEx
         */
        public Builder add(String string) {
            this.regex.append(string);
            return this;
        }

        /**
         * Добавление символов.
         * @author Namespace Stedd
         * @param chars добавляемые символы
         * @return Конструктор регистратора RegEx
         */
        public Builder add(char... chars) {
            this.regex.append(new String(chars));
            return this;
        }

        /**
         * Группировка возможных символов.
         * @author Namespace Stedd
         * @param chars возможные символы
         * @return квантификатор регистратора RegEx
         */
        public Quantifier oneOf(char... chars) {
            this.regex.append('[').append(ExoCollection.toArrayString(chars, "")).append("]");
            return new Quantifier(this);
        }

        /**
         * Группировка невозможных символов.
         * @author Namespace Stedd
         * @param chars невозможные символы
         * @return квантификатор регистратора RegEx
         */
        public Quantifier noOneOf(char... chars) {
            this.regex.append('[').append('^').append(ExoCollection.toArrayString(chars, "")).append("]");
            return new Quantifier(this);
        }

        /**
         * Определение диапазонов.
         * @author Namespace Stedd
         * @return определение диапазонов включения символов в RegEx
         */
        public Range range() {
            return new Range(this);
        }

        /**
         * Маркировка начала слова.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier wordBound() {
            this.regex.append(WORD_BOUND.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Маркировка не начала слова.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier notWordBound() {
            this.regex.append(NOT_WORD_BOUND.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о конце предыдущего совпадения.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier lastMatchingEnding() {
            this.regex.append(LAST_MATCHING_ENDING.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – цифра.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier digit() {
            this.regex.append(DIGIT.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – не цифра.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier notDigit() {
            this.regex.append(NOT_DIGIT.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – пробел.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier space() {
            this.regex.append(SPACE.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – не пробел.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier notSpace() {
            this.regex.append(NOT_SPACE.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – цифра, буква или нижнее подчёркивание.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier wordOrDigitOrUnderlining() {
            this.regex.append(WORD_OR_DIGIT_OR_UNDERLINING.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – не цифра, не буква и не нижнее подчёркивание.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier notWordAndNotDigitAndNotUnderlining() {
            this.regex.append(NOT_WORD_AND_NOT_DIGIT_AND_NOT_UNDERLINING.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – любой.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier anyChar() {
            this.regex.append(ANY_CHAR.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – табуляция.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier tab() {
            this.regex.append(TAB.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – новая строка.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier newLine() {
            this.regex.append(NEW_LINE.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – возврат каретки.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier carriageReturn() {
            this.regex.append(CARRIAGE_RETURN.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – переход на новую страницу.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier newPage() {
            this.regex.append(NEW_PAGE.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – следующая строка.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier nextLine() {
            this.regex.append(NEXT_LINE.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – разделение строки.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier lineSplitting() {
            this.regex.append(LINE_SPLITTING.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Отметка о том, что символ – разделение абзаца.
         * @author Namespace Stedd
         * @return квантификатор регистратора RegEx
         */
        public Quantifier paragraphSplitting() {
            this.regex.append(PARAGRAPH_SPLITTING.getRegexChar());
            return new Quantifier(this);
        }

        /**
         * Группировка части шаблона строки RegEx по Конструктору регистратора RegEx.
         * @author Namespace Stedd
         * @param groupBuilder Конструктор регистратора RegEx
         * @return Квантификатор регистратора RegEx
         */
        public Quantifier group(Builder groupBuilder) {
            this.regex.append('(').append(groupBuilder.build().regex).append(')');
            return new Quantifier(this);
        }

        /**
         * Формирование регистратора RegEx.
         * @author Namespace Stedd
         * @return Регистратор RegEx
         */
        public RegEx build() {
            return new RegEx(this.regex.append(this.stringEndsWithPattern ?
                    STRING_ENDING.getRegexChar() :
                    ""
            ).toString());
        }

    }

    /**
     * Квантификатор регистратора RegEx.
     * @author Namespace Stedd
     */
    public static class Quantifier {

        /**
         * Конструктор регистратора RegEx.
         */
        private final Builder builder;

        /**
         * Создание квантификатора регистратора RegEx.
         * @author Namespace Stedd
         * @param builder Конструктор регистратора RegEx
         */
        private Quantifier(Builder builder) {
            this.builder = builder;
        }

        /**
         * Пропуск квантификации.
         * @author Namespace Stedd
         * @return Конструктор регистратора RegEx
         */
        public Builder noQuantify() {
            return this.builder;
        }

        /**
         * Пометка присутствия последней части шаблона один или менее раз.
         * @author Namespace Stedd
         * @return Конструктор регистратора RegEx
         */
        public Builder oneOrLess() {
            return this.builder.quantify(ONE_OR_LESS.getRegexChar());
        }

        /**
         * Пометка присутствия последней части шаблона ноль или более раз.
         * @author Namespace Stedd
         * @return Конструктор регистратора RegEx
         */
        public Builder zeroOrMore() {
            return this.builder.quantify(ZERO_OR_MORE.getRegexChar());
        }

        /**
         * Пометка присутствия последней части шаблона один или более раз.
         * @author Namespace Stedd
         * @return Конструктор регистратора RegEx
         */
        public Builder oneOrMore() {
            return this.builder.quantify(ONE_OR_MORE.getRegexChar());
        }

        /**
         * Пометка присутствия последней части шаблона указанное n раз.
         * @author Namespace Stedd
         * @param n количество раз
         * @return Конструктор регистратора RegEx
         */
        public Builder nTimes(long n) {
            n = Math.max(0, n);
            return this.builder.quantify(N_TIMES.getRegexChar()
                    .replaceAll("n", String.valueOf(n))
            );
        }

        /**
         * Пометка присутствия последней части шаблона указанное n раз и более.
         * @author Namespace Stedd
         * @param n нижняя граница количества раз
         * @return Конструктор регистратора RegEx
         */
        public Builder nOrMoreTimes(long n) {
            n = Math.max(0, n);
            return this.builder.quantify(N_OR_MORE_TIMES.getRegexChar()
                    .replaceAll("n", String.valueOf(n))
            );
        }

        /**
         * Пометка присутствия последней части шаблона указанное не менее n и не более m раз.
         * @author Namespace Stedd
         * @param n нижняя граница количества раз
         * @param m верхняя граница количества раз
         * @return Конструктор регистратора RegEx
         */
        public Builder nToMTimes(long n, long m) {
            n = Math.max(0, n);
            m = Math.max(0, m);
            return this.builder.quantify(N_TO_M_TIMES.getRegexChar()
                    .replaceAll("n", String.valueOf(n))
                    .replaceAll("m", String.valueOf(m))
            );
        }

    }

    /**
     * Определение диапазонов включения символов в RegEx.
     * @author Namespace Stedd
     */
    public static class Range {

        /**
         * Конструктор регистратора RegEx.
         */
        private final Builder builder;

        /**
         * Указываемые включаемые диапазоны символов.
         */
        private final List<CharRange> includedCharRanges;

        /**
         * Указываемые исключаемые диапазоны символов.
         */
        private final List<CharRange> excludedCharRanges;

        /**
         * Создание определения диапазонов включения символов в RegEx.
         * @author Namespace Stedd
         * @param builder Конструктор регистратора RegEx
         */
        public Range(Builder builder) {
            this.builder = builder;
            this.includedCharRanges = new ArrayList<>();
            this.excludedCharRanges = new ArrayList<>();
        }

        /**
         * Добавление включаемого символьного диапазона.
         * @author Namespace Stedd
         * @param charRange новый включаемый символьный диапазон
         * @return определение диапазонов включения символов в RegEx
         */
        public Range include(CharRange charRange) {
            this.includedCharRanges.add(charRange);
            return this;
        }

        /**
         * Добавление исключаемого символьного диапазона.
         * @author Namespace Stedd
         * @param charRange новый исключаемый символьный диапазон
         * @return определение диапазонов включения символов в RegEx
         */
        public Range exclude(CharRange charRange) {
            this.excludedCharRanges.add(charRange);
            return this;
        }

        /**
         * Определение диапазонов RegEx.
         * @author Namespace Stedd
         * @return Конструктор регистратора RegEx
         */
        public Quantifier define() {
            return this.define(newBuilder());
        }

        /**
         * Определение диапазонов RegEx.
         * @author Namespace Stedd
         * @param including включающийся в диапазон Конструктор регистратора RegEx
         * @return Конструктор регистратора RegEx
         */
        public Quantifier define(Builder including) {
            String regexIncluding = including.build().regex;
            StringBuilder excludedRanges = new StringBuilder(
                    !(this.includedCharRanges.isEmpty() && regexIncluding.isEmpty()) ? "&&" : ""
            );
            int excludedRangesSize = this.excludedCharRanges.size();
            for (int i = 0; i < excludedRangesSize; i++) {
                excludedRanges.append("[^")
                        .append(this.excludedCharRanges.get(i).toString())
                        .append("]")
                        .append(i != excludedRangesSize - 1 ? "&&" : "");
            }
            ExoCollection.toListString(this.excludedCharRanges, "&&");
            return new Quantifier(this.builder.custom("[" +
                    regexIncluding +
                    ExoCollection.toListString(this.includedCharRanges, "") +
                    excludedRanges +
                    "]"
            ));
        }

    }

}
