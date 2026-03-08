package namespace.stedd.data.console;

import namespace.stedd.data.Converter;

import java.util.Scanner;

/**
 * Консольный Ввод.
 * @author Namespace Stedd
 */
public class Cin {

    private static final Scanner scanner = new Scanner(System.in);   // Обёрточный Ввод в Консоль

    /**
     * Чтение Ввода с Консоли.
     * @author Namespace Stedd
     * @return прочитанная строка
     */
    public static String read() {
        return scanner.nextLine();
    }

    /**
     * Чтение Ввода с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанная строка
     */
    public static String read(String outputMessage) {
        System.out.print(outputMessage + ": ");
        return read();
    }

    /**
     * Чтение Символа строки с Консоли.
     * @author Namespace Stedd
     * @return прочитанный Символ строки
     */
    public static char readChar() {
        String input = read();
        return input.isEmpty() ? ' ' : input.charAt(0);
    }

    /**
     * Чтение Символа строки с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанный Символ строки
     */
    public static char readChar(String outputMessage) {
        System.out.print(outputMessage + ": ");
        return readChar();
    }

    /**
     * Чтение Логической булевой с Консоли.
     * @author Namespace Stedd
     * @return прочитанная Логическая булева
     */
    public static boolean readBoolean() {
        String input = read();
        if (input.contains("true")) {
            return true;
        }
        if (input.contains("false")) {
            return false;
        }
        StringBuilder numberCandidate = new StringBuilder();
        for (char charee : input.toCharArray()) {
            if (charee == '-' && numberCandidate.isEmpty() || Character.isDigit(charee)) {
                numberCandidate.append(charee);
            }
        }
        if (numberCandidate.isEmpty()) {
            return false;
        }
        String number = numberCandidate.toString();
        return !number.contains("-") && withMaximum(number) != 0;
    }

    /**
     * Чтение Логической булевой с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанная Логическая булева
     */
    public static boolean readBoolean(String outputMessage) {
        System.out.print(outputMessage + ": ");
        return readBoolean();
    }

    /**
     * Чтение Байта с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанный Байт
     */
    public static byte readByte(String outputMessage) {
        System.out.print(outputMessage + ": ");
        String input = read();
        String number = toNumberString(input);
        input = input.toLowerCase();   // Для того чтобы сравнивать только малые литералы
        if (input.contains("0x")) {
            char firstDigit = '0', secondDigit = '0';
            char[] extendedAlphabet = { 'a', 'b', 'c', 'd', 'e', 'f' };
            String[] splitNumber = input.split("0x");
            String byteCandidate = splitNumber.length > 1 ? splitNumber[1] : "";
            for (int i = 0, digits = 1; digits <= 2 && i < byteCandidate.length(); i++) {
                char charee = byteCandidate.charAt(i);
                if (Character.isDigit(charee) || charee == 'a' || charee == 'b' || charee == 'c' || charee == 'd' || charee == 'e' || charee == 'f') {
                    switch (digits) {
                        case 1 -> firstDigit = charee;
                        case 2 -> secondDigit = charee;
                    }
                    digits++;
                }
            }
            return Converter.hexStringToByte(firstDigit + "" + secondDigit);
        }
        if (input.contains("0b")) {
            int maxDigits = 8;
            char[] binary = "0".repeat(maxDigits).toCharArray();
            String[] splitNumber = input.split("0b");
            String byteCandidate = splitNumber.length > 1 ? splitNumber[1] : "";
            for (int i = 0, digits = 1; digits <= maxDigits && i < byteCandidate.length(); i++) {
                char charee = byteCandidate.charAt(i);
                if (charee == '0' || charee == '1') {
                    binary[digits - 1] = charee;
                    digits++;
                }
            }
            return Converter.binaryStringToByte(String.valueOf(binary));
        }
        return (byte) getLong(number);
    }

    /**
     * Преобразование строки в Числоподобную.
     * @author Namespace Stedd
     * @param input преобразуемая строка
     * @return Числоподобная строка
     */
    private static String toNumberString(String input) {
        StringBuilder numberCandidate = new StringBuilder();
        for (char charee : input.toCharArray()) {
            if (charee == '-' && numberCandidate.isEmpty() || Character.isDigit(charee)) {
                numberCandidate.append(charee);
            }
        }
        return numberCandidate.toString();
    }

    /**
     * Преобразование строки в Числоподобную.
     * @author Namespace Stedd
     * @param input преобразуемая строка
     * @return Числоподобная строка
     */
    private static String toNumberString(String input, boolean ignoreNegative) {
        return toNumberString(input).replaceAll(ignoreNegative ? "-" : "", "");
    }

    /**
     * Преобразование Большого Целого числа с учётом выхода за его верхние границы.
     * @author Namespace Stedd
     * @param longString Строковое Большое Целое число
     * @return корректное Большое Целое число
     */
    private static long withMaximum(String longString) {
        long max = Long.MAX_VALUE;
        String maxLong = Long.toString(max);
        // Если количество цифр меньше количества цифр в максимальном значении Большого Целого числа, то парсим реальное введённое число
        if (longString.length() < maxLong.length()) {
            return Converter.parseLong(longString, 0);
        }
        // Если количество цифр больше количества цифр в максимальном значении Большого Целого числа, то отправляем максимальное число
        else if (longString.length() > maxLong.length()) {
            return max;
        }
        // Если количество цифр у введённого и максимального значения равны, то проверяем каждую цифру по отдельности
        else {
            for (int i = 0; i < longString.length(); i++) {
                int inputted = Integer.parseInt(longString.charAt(i) + "");
                int maximized = Integer.parseInt(maxLong.charAt(i) + "");
                if (inputted > maximized) {
                    return max;
                }
            }
            return Converter.parseLong(longString, 0);
        }
    }

    /**
     * Преобразование Большого Целого числа с учётом выхода за его нижние границы.
     * @author Namespace Stedd
     * @param longString Строковое Большое Целое число
     * @return корректное Большое Целое число
     */
    private static long withMinimum(String longString) {
        long min = Long.MIN_VALUE;
        String minLong = Long.toString(min);
        // Если введён только минус, то возвращаем 0 TODO: подумать насчёт парсера
        if (longString.length() < 2 && longString.startsWith("-")) {
            return 0;
        }
        // Если количество цифр меньше количества цифр в максимальном значении Большого Целого числа, то парсим реальное введённое число
        else if (longString.length() < minLong.length()) {
            return Converter.parseLong(longString, 0);
        }
        // Если количество цифр больше количества цифр в максимальном значении Большого Целого числа, то отправляем максимальное число
        else if (longString.length() > minLong.length()) {
            return min;
        }
        // Если количество цифр у введённого и максимального значения равны, то проверяем каждую цифру по отдельности
        else {
            for (int i = 0; i < longString.length(); i++) {
                char inputtedChar = longString.charAt(i);
                if (inputtedChar == '-') {
                    continue;
                }
                int inputted = Integer.parseInt(inputtedChar + "");
                int minimized = Integer.parseInt(minLong.charAt(i) + "");
                if (inputted > minimized) {
                    return min;
                }
            }
            return Converter.parseLong(longString, 0);
        }
    }

    /**
     * Преобразование Строкового числа в Большое Целое число.
     * @author Namespace Stedd
     * @param number Строковое число
     * @return Большое Целое число
     */
    private static long getLong(String number) {
        return number.contains("-") ? withMinimum(number) : withMaximum(number);
    }

    /**
     * Чтение Большого Целого числа с Консоли.
     * @author Namespace Stedd
     * @return прочитанное Большое Целое число
     */
    public static long readLong() {
        String input = read();
        StringBuilder numberCandidate = new StringBuilder();
        for (char charee : input.toCharArray()) {
            if (charee == '-' && numberCandidate.isEmpty() || Character.isDigit(charee)) {
                numberCandidate.append(charee);
            }
        }
        String number = numberCandidate.toString();
        return getLong(number);
    }

    /**
     * Чтение Большого Целого числа с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанное Большое Целое число
     */
    public static long readLong(String outputMessage) {
        System.out.print(outputMessage + ": ");
        return readLong();
    }

    /**
     * Чтение Целого числа с Консоли.
     * @author Namespace Stedd
     * @return прочитанное Целое число
     */
    public static int readInt() {
        return (int) readLong();
    }

    /**
     * Чтение Целого числа с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанное Целое число
     */
    public static int readInt(String outputMessage) {
        return (int) readLong(outputMessage);
    }

    /**
     * Чтение Малого Целого числа с Консоли.
     * @author Namespace Stedd
     * @return прочитанное Малое Целое число
     */
    public static short readShort() {
        return (short) readLong();
    }

    /**
     * Чтение Малого Целого числа с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанное Малое Целое число
     */
    public static short readShort(String outputMessage) {
        return (short) readLong(outputMessage);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @return прочитанное Дробное число Двойной точности
     */
    public static double readDouble() {
        return readDouble(',');
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param separator разделитель вводимого Дробного числа Двойной точности
     * @return прочитанное Дробное число Двойной точности
     */
    public static double readDouble(char separator) {
        if (Character.isDigit(separator)) {
            separator = ',';
        }
        String input = read();
        StringBuilder numberCandidate = new StringBuilder();
        boolean separatorFound = false;
        for (char charee : input.toCharArray()) {
            boolean isSeparator = charee == separator;
            if (charee == '-' && numberCandidate.isEmpty() || Character.isDigit(charee) || isSeparator && !separatorFound) {
                numberCandidate.append(charee);
            }
            separatorFound |= isSeparator;
        }
        String number = numberCandidate.toString().replace(separator, '.');
        return Double.parseDouble(number);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param replaceToMaxValueIfInfinite показатель необходимости замены числа при его бесконечном значении
     * @return прочитанное Дробное число Двойной точности
     */
    public static double readDouble(boolean replaceToMaxValueIfInfinite) {
        return readDouble(',', replaceToMaxValueIfInfinite);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param separator разделитель вводимого Дробного числа Двойной точности
     * @param replaceToMaxValueIfInfinite показатель необходимости замены числа при его бесконечном значении
     * @return прочитанное Дробное число Двойной точности
     */
    public static double readDouble(char separator, boolean replaceToMaxValueIfInfinite) {
        double decker = readDouble(separator);
        if (replaceToMaxValueIfInfinite && Double.isInfinite(decker)) {
            if (decker == Double.NEGATIVE_INFINITY) {
                return Double.MIN_VALUE;
            }
            if (decker == Double.POSITIVE_INFINITY) {
                return Double.MAX_VALUE;
            }
        }
        return decker;
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанное Дробное число Двойной точности
     */
    public static double readDouble(String outputMessage) {
        System.out.print(outputMessage + ": ");
        return readDouble(',');
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @param separator разделитель вводимого Дробного числа Двойной точности
     * @return прочитанное Дробное число Двойной точности
     */
    public static double readDouble(String outputMessage, char separator) {
        System.out.print(outputMessage + ": ");
        return readDouble(separator);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @param replaceToMaxValueIfInfinite показатель необходимости замены числа при его бесконечном значении
     * @return прочитанное Дробное число Двойной точности
     */
    public static double readDouble(String outputMessage, boolean replaceToMaxValueIfInfinite) {
        System.out.print(outputMessage + ": ");
        return readDouble(replaceToMaxValueIfInfinite);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @param separator разделитель вводимого Дробного числа Двойной точности
     * @param replaceToMaxValueIfInfinite показатель необходимости замены числа при его бесконечном значении
     * @return прочитанное Дробное число Двойной точности
     */
    public static double readDouble(String outputMessage, char separator, boolean replaceToMaxValueIfInfinite) {
        System.out.print(outputMessage + ": ");
        return readDouble(separator, replaceToMaxValueIfInfinite);
    }

    /**
     * Чтение Дробного числа с Консоли.
     * @author Namespace Stedd
     * @return прочитанное Дробное число
     */
    public static float readFloat() {
        return readFloat(',');
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param separator разделитель вводимого Дробного числа Двойной точности
     * @return прочитанное Дробное число Двойной точности
     */
    public static float readFloat(char separator) {
        if (Character.isDigit(separator)) {
            separator = ',';
        }
        String input = read();
        StringBuilder numberCandidate = new StringBuilder();
        boolean separatorFound = false;
        for (char charee : input.toCharArray()) {
            boolean isSeparator = charee == separator;
            if (charee == '-' && numberCandidate.isEmpty() || Character.isDigit(charee) || isSeparator && !separatorFound) {
                numberCandidate.append(charee);
            }
            separatorFound |= isSeparator;
        }
        String number = numberCandidate.toString().replace(separator, '.');
        return Float.parseFloat(number);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param replaceToMaxValueIfInfinite показатель необходимости замены числа при его бесконечном значении
     * @return прочитанное Дробное число Двойной точности
     */
    public static float readFloat(boolean replaceToMaxValueIfInfinite) {
        return readFloat(',', replaceToMaxValueIfInfinite);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param separator разделитель вводимого Дробного числа Двойной точности
     * @param replaceToMaxValueIfInfinite показатель необходимости замены числа при его бесконечном значении
     * @return прочитанное Дробное число Двойной точности
     */
    public static float readFloat(char separator, boolean replaceToMaxValueIfInfinite) {
        float decker = readFloat(separator);
        if (replaceToMaxValueIfInfinite && Double.isInfinite(decker)) {
            if (decker == Float.NEGATIVE_INFINITY) {
                return Float.MIN_VALUE;
            }
            if (decker == Float.POSITIVE_INFINITY) {
                return Float.MAX_VALUE;
            }
        }
        return decker;
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @return прочитанное Дробное число Двойной точности
     */
    public static float readFloat(String outputMessage) {
        System.out.print(outputMessage + ": ");
        return readFloat(',');
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @param separator разделитель вводимого Дробного числа Двойной точности
     * @return прочитанное Дробное число Двойной точности
     */
    public static float readFloat(String outputMessage, char separator) {
        System.out.print(outputMessage + ": ");
        return readFloat(separator);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @param replaceToMaxValueIfInfinite показатель необходимости замены числа при его бесконечном значении
     * @return прочитанное Дробное число Двойной точности
     */
    public static float readFloat(String outputMessage, boolean replaceToMaxValueIfInfinite) {
        System.out.print(outputMessage + ": ");
        return readFloat(replaceToMaxValueIfInfinite);
    }

    /**
     * Чтение Дробного числа Двойной точности с Консоли.
     * @author Namespace Stedd
     * @param outputMessage выводимое для Ввода сообщение
     * @param separator разделитель вводимого Дробного числа Двойной точности
     * @param replaceToMaxValueIfInfinite показатель необходимости замены числа при его бесконечном значении
     * @return прочитанное Дробное число Двойной точности
     */
    public static float readFloat(String outputMessage, char separator, boolean replaceToMaxValueIfInfinite) {
        System.out.print(outputMessage + ": ");
        return readFloat(separator, replaceToMaxValueIfInfinite);
    }

}
