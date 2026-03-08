package namespace.stedd.data.console;

import namespace.stedd.data.Converter;

import java.io.PrintStream;

/**
 * Консольный Вывод.
 * @author Namespace Stedd
 */
public class Cout {

    private static final PrintStream cout = System.out;   // Вывод в Консоль

    /**
     * Вывод пустой информации в Консоль.
     * @author Namespace Stedd
     */
    public static void write() {
        cout.println();
    }

    /**
     * Вывод объекта в Консоль.
     * @author Namespace Stedd
     * @param object выводимый в Консоль объект
     */
    public static void write(Object object) {
        cout.println(object);
    }

    /**
     * Вывод нескольких объектов в Консоль.
     * @author Namespace Stedd
     * @param objects выводимые в Консоль объекты
     */
    public static void write(Object... objects) {
        cout.println(Converter.toArrayString(objects, " "));
    }

    /**
     * Вывод объекта в Консоль.
     * @author Namespace Stedd
     * @param title подпись к объекту
     * @param object выводимый в Консоль объект
     */
    public static void write(String title, Object object) {
        cout.println(title + ": " + object);
    }

    /**
     * Вывод нескольких объектов в Консоль.
     * @author Namespace Stedd
     * @param title подпись к объекту
     * @param objects выводимые в Консоль объекты
     */
    public static void write(String title, Object... objects) {
        cout.println(title + ": " + Converter.toArrayString(objects, ","));
    }

    /**
     * Вывод нескольких объектов в Консоль.
     * @author Namespace Stedd
     * @param number печатаемая цифра
     * @param precision точность знаков после запятой
     */
    public static void writeWithPrecision(double number, int precision) {
        precision = Math.max(precision, 0);
        String pattern = "%." + precision + "f";
        cout.printf(pattern + "%n", number);
    }

    /**
     * Вывод нескольких объектов в Консоль.
     * @author Namespace Stedd
     * @param title подпись к цифре
     * @param number печатаемая цифра
     * @param precision точность знаков после запятой
     */
    public static void writeWithPrecision(String title, double number, int precision) {
        cout.print(title + ": ");
        writeWithPrecision(number, precision);
    }

    /**
     * Вывод объекта в Консоль.
     * @author Namespace Stedd
     * @param patternedString шаблонная строка
     * @param objects выводимые в Консоль объекты
     */
    public static void writeWithPattern(String patternedString, Object... objects) {
        for (Object object : objects) {
            patternedString = patternedString.replaceFirst("\\{}", object.toString());
        }
        cout.println(patternedString);
    }

    /**
     * Вывод объекта в Консоль.
     * @author Namespace Stedd
     * @param title подпись к объекту
     * @param patternedString шаблонная строка
     * @param objects выводимые в Консоль объекты
     */
    public static void writeWithPattern(String title, String patternedString, Object... objects) {
        cout.print(title + ": ");
        writeWithPattern(patternedString, objects);
    }

    /**
     * Вывод C#-объекта в Консоль.
     * @author Namespace Stedd
     * @param patternedString шаблонная строка
     * @param objects выводимые в Консоль объекты
     */
    public static void writeWithSharpPattern(String patternedString, Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            patternedString = patternedString.replaceFirst("\\{" + i + '}', object.toString());
        }
        cout.println(patternedString);
    }

    /**
     * Вывод C#-объекта в Консоль.
     * @author Namespace Stedd
     * @param title подпись к объекту
     * @param patternedString шаблонная строка
     * @param objects выводимые в Консоль объекты
     */
    public static void writeWithSharpPattern(String title, String patternedString, Object... objects) {
        cout.print(title + ": ");
        writeWithSharpPattern(patternedString, objects);
    }

}
