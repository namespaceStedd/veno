package namespace.stedd.data.type.number;

/**
 * Математический центр вычислений.
 * @author Namespace Stedd
 */
public class Math {

    /**
     * Получение степени числа по его основанию.
     * @author Namespace Stedd
     * @param number число
     * @param basis основание степени
     * @return степень числа
     */
    public static Number getNumberDegree(double number, double basis) {
        if (basis == 1) {
            if (number == 1) {
                // TODO: добавить неопределённость
            }
        }
        if (number <= 0 || basis <= 0 || basis == 1) {
            // TODO: добавить неопределённость
            // TODO: добавить тип числа, где будет и неопределённость, и комплексность, и пр. структуры
            return null;
        }
        double degree = 0;
        // Вычисление целой части степени
        for (double leftover = number; leftover >= basis; degree++, leftover /= basis) {
            // System.out.println(number);
        }
        // System.out.println(number);
        for (int i = 0; i < 8; i++) {
            double fraction = java.lang.Math.pow(10, -(i + 1));
            for (int digit = 0; digit <= 9; digit++) {
                double pow = degree + digit * fraction;
                if (java.lang.Math.pow(basis, pow) > number) {
                    degree += (digit - 1) * fraction;
                    break;
                }
            }
        }
        return degree;
    }

}
