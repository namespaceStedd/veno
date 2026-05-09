package namespace.stedd.data.type;

/**
 * Расширенное представление логического типа данных.
 * @author Namespace Stedd
 */
public class ExoBoolean {

    private Boolean bool;   // Представляемый логический тип данных

    /**
     * Создание несуществующего представляемого логического типа данных.
     * @author Namespace Stedd
     */
    public ExoBoolean() {
        this.bool = null;
    }

    /**
     * Создание представляемого логического типа данных.
     * @author Namespace Stedd
     * @param bool представляемый логический тип данных
     */
    public ExoBoolean(boolean bool) {
        this.bool = bool;
    }

    /**
     * Создание представляемого логического типа данных.
     * @author Namespace Stedd
     * @param bool представляемый логический тип данных
     * @return расширенное представление логического типа данных
     */
    public static ExoBoolean create(boolean bool) {
        return new ExoBoolean(bool);
    }

    /**
     * Получение представляемого логического типа данных.
     * @author Namespace Stedd
     * @return представляемый логический тип данных
     */
    public Boolean getBoolean() {
        return this.bool;
    }

    /**
     * Получение представляемого логического типа данных.
     * @author Namespace Stedd
     * @param ifNull если текущее значение NULL
     * @return представляемый логический тип данных
     */
    public boolean getBoolean(boolean ifNull) {
        return this.bool != null ? this.bool : ifNull;
    }

    /**
     * Обновление представляемого логического типа данных.
     * @author Namespace Stedd
     * @param bool представляемый логический тип данных
     */
    public void setBoolean(Boolean bool) {
        this.bool = bool;
    }

    /**
     * Преобразование объекта в логическое значение с проверкой на NULL.
     * @author Namespace Stedd
     * @param booleanable подвергающийся логики объект
     * @param ifNull значение при пустом объекте
     * @return логическое значение
     */
    public static boolean parseBoolean(Object booleanable, boolean ifNull) {
        return parseBoolean(booleanable, Boolean.valueOf(ifNull));
    }

    /**
     * Преобразование объекта в логическое значение с проверкой на NULL.
     * @author Namespace Stedd
     * @param booleanable подвергающийся логики объект
     * @param ifNull значение при пустом объекте
     * @return логическое значение
     */
    public static Boolean parseBoolean(Object booleanable, Boolean ifNull) {
        String booleanableString = ExoString.parseString(booleanable, ExoString.parseString(ifNull, null));
        return ExoString.notNullStatus(booleanableString) ? Boolean.parseBoolean(booleanableString) : ifNull;
    }

}
