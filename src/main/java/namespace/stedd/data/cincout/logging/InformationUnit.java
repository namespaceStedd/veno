package namespace.stedd.data.cincout.logging;

/**
 * Единицы измерения информации.
 * @author Namespace Stedd
 */
public enum InformationUnit {
    Byte("B"),
    KiloByte("KB"),
    MegaByte("MB"),
    GigaByte("GB"),
    TeraByte("TB"),
    ;

    private final String unit;   // Единица измерения в строчном формате

    /**
     * Создание единицы измерения информации.
     * @author Namespace Stedd
     * @param unit единица измерения в строчном формате
     */
    InformationUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Получение единицы измерения в строчном формате.
     * @author Namespace Stedd
     * @return единица измерения в строчном формате
     */
    public String getUnit() {
        return this.unit;
    }

}
