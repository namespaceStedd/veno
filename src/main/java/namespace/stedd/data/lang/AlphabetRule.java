package namespace.stedd.data.lang;

import namespace.stedd.data.type.ExObject;

/**
 * Перечисление возможных порядков отображения алфавита.
 * @author Namespace Stedd
 */
public enum AlphabetRule implements ExObject {
    ForwardOrder,   // Прямой порядок
    ReverseOrder,   // Обратный порядок
    SplitLetterCases,   // Раздельное перечисление верхних и нижних регистров
    UpperCaseOnly,   // Только заглавные буквы
    LowerCaseOnly,   // Только строчные буквы
    ;
}
