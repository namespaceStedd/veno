package namespace.stedd.data.reflection;

import namespace.stedd.data.Converter;
import namespace.stedd.data.type.ExoString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Разделитель аннотаций.
 * @author Namespace Stedd
 */
public class AnnotationSplitter {

    /**
     * Разделённые поля.
     * @author Namespace Stedd
     */
    public static class Fields {

        private final Field[] annotatedFields;   // Массив полей с указанной аннотацией
        private final Field[] freeFields;   // Массив полей без указанной аннотации

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param annotatedFields массив полей с указанной аннотацией
         * @param freeFields массив полей без указанной аннотации
         */
        public Fields(Field[] annotatedFields, Field[] freeFields) {
            this.annotatedFields = annotatedFields;
            this.freeFields = freeFields;
        }

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param annotatedFields список полей с указанной аннотацией
         * @param freeFields список полей без указанной аннотации
         */
        public Fields(List<Field> annotatedFields, List<Field> freeFields) {
            this.annotatedFields = Converter.toArray(annotatedFields, Field.class);
            this.freeFields = Converter.toArray(freeFields, Field.class);
        }

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param annotatedFields массив полей с указанной аннотацией
         * @param freeFields массив полей без указанной аннотации
         * @return разделённые поля
         */
        public static Fields create(Field[] annotatedFields, Field[] freeFields) {
            return new Fields(annotatedFields, freeFields);
        }

        /**
         * Получение массива полей с указанной аннотацией.
         * @author Namespace Stedd
         * @return массив полей с указанной аннотацией
         */
        public Field[] getAnnotatedFields() {
            return this.annotatedFields;
        }

        /**
         * Получение массива полей с указанной аннотацией в виде строки.
         * @author Namespace Stedd
         * @param delimiter разделитель элементов массива
         * @return строчный массив полей с указанной аннотацией
         */
        public String getAnnotatedFields(String delimiter) {
            return getFields(true, delimiter, new FieldRule() { });
        }

        /**
         * Получение массива полей без указанной аннотации.
         * @author Namespace Stedd
         * @return массив полей без указанной аннотации
         */
        public Field[] getFreeFields() {
            return this.freeFields;
        }

        /**
         * Получение массива полей без указанной аннотации в виде строки.
         * @author Namespace Stedd
         * @param delimiter разделитель элементов массива
         * @return строчный массив полей без указанной аннотации
         */
        public String getFreeFields(String delimiter) {
            return getFields(false, delimiter, new FieldRule() { });
        }

        /**
         * Получение массива полей в виде строки.
         * @author Namespace Stedd
         * @param annotated показатель необходимости использования аннотационных полей
         * @param delimiter разделитель элементов массива
         * @param rule правило получения строки из элемента массива
         * @return строчный массив полей
         */
        public String getFields(boolean annotated, String delimiter, FieldRule rule) {
            Field[] fields = annotated ? this.annotatedFields : this.freeFields;
            List<String> stringFields = new ArrayList<>();
            for (Field field : fields) {
                String stringField = rule.toString(field);
                if (ExoString.notNullStatus(stringField)) {
                    stringFields.add(stringField);
                }
            }
            return Converter.toListString(stringFields, delimiter);
        }

    }

    /**
     * Интерфейс по определению правила преобразования поля в строку.
     * @author Namespace Stedd
     */
    public interface FieldRule {

        /**
         * Преобразование поля в строку по умолчанию.
         * @author Namespace Stedd
         * @param field поле класса
         * @return строчное представление поля
         */
        default String toString(Field field) {
            return field.getName();
        }

    }

    /**
     * Разделение полей по указанной аннотации.
     * @author Namespace Stedd
     * @param object сущность, содержащая поля
     * @param annotation аннотация
     * @return разделённые поля
     * @param <T> универсальный параметр типа
     */
    public static <T extends Annotation> Fields split(Object object, Class<T> annotation) {
        // Возврат разделённых полей
        return split(object.getClass().getDeclaredFields(), annotation);
    }

    /**
     * Разделение полей по указанной аннотации.
     * @author Namespace Stedd
     * @param fields список полей
     * @param annotation аннотация
     * @return разделённые поля
     * @param <T> универсальный параметр типа
     */
    public static <T extends Annotation> Fields split(Field[] fields, Class<T> annotation) {
        // Создание списков
        List<Field> annotatedFields = new ArrayList<>();
        List<Field> freeFields = new ArrayList<>();
        // Перебор полей класса
        for (Field field : fields) {
            // Установка доступности текущего поля
            field.setAccessible(true);
            // Получение аннотации поля
            Annotation annotated = field.getAnnotation(annotation);
            // Добавление поля в нужный список в зависимости от наличия аннотации
            if (annotated != null) {
                annotatedFields.add(field);
            }
            else {
                freeFields.add(field);
            }
        }
        // Возврат разделённых полей
        return new Fields(annotatedFields, freeFields);
    }

}
