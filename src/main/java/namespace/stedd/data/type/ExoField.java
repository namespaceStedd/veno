package namespace.stedd.data.type;

import namespace.stedd.data.Converter;
import namespace.stedd.data.reflection.ZeroAvoiding;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Расширенное представление поля класса.
 * @author Namespace Stedd
 */
public class ExoField {

    protected final Field field;   // Поле класса
    protected Object value;   // Значение экземпляра класса

    /**
     * Создание расширенного представления поля класса.
     * @author Namespace Stedd
     * @param field поле класса
     */
    public ExoField(Field field) {
        this.field = field;
        this.field.setAccessible(true);
        this.value = null;
    }

    /**
     * Создание расширенного представления поля класса.
     * @author Namespace Stedd
     * @param field поле класса
     * @param instance экземпляр класса
     */
    public ExoField(Field field, Object instance) {
        this.field = field;
        this.field.setAccessible(true);
        this.value = getValue(this.field, instance);
    }

    /**
     * Создание расширенного представления поля класса.
     * @author Namespace Stedd
     * @param field поле класса
     * @return расширенное представление поля класса
     */
    public static ExoField create(Field field) {
        return new ExoField(field);
    }

    /**
     * Создание расширенного представления поля класса.
     * @author Namespace Stedd
     * @param field поле класса
     * @param instance экземпляр класса
     * @return расширенное представление поля класса
     */
    public static ExoField create(Field field, Object instance) {
        return new ExoField(field, instance);
    }

    /**
     * Получение всех полей экземпляра класса с их значениями.
     * @author Namespace Stedd
     * @param instance экземпляр класса
     * @return массив расширенных полей
     */
    public static ExoField[] getFields(Object instance) {
        return getFields(instance, true);
    }

    /**
     * Получение всех полей экземпляра класса с их значениями.
     * @author Namespace Stedd
     * @param instance экземпляр класса
     * @param includeParentFields необходимость включения полей родительского класса
     * @return массив расширенных полей
     */
    public static ExoField[] getFields(Object instance, boolean includeParentFields) {
        Field[] fields = includeParentFields ?
                getParentFields(instance, true) :
                instance.getClass().getDeclaredFields();
        ExoField[] exoFields = new ExoField[fields.length];
        for (int i = 0; i < exoFields.length; i++) {
            Field field = fields[i];
            ExoField exoField = ExoField.create(field, instance);
            exoFields[i] = exoField;
        }
        return exoFields;
    }

    /**
     * Получение родительских полей класса.
     * @author Namespace Stedd
     * @param instance экземпляр класса
     * @param includeCurrentFields показатель необходимости включить текущие поля класса
     * @return родительские поля класса
     */
    private static Field[] getParentFields(Object instance, boolean includeCurrentFields) {
        Field[] fields = includeCurrentFields ? instance.getClass().getDeclaredFields() : new Field[0];
        for (Class<?> parentClass = instance.getClass();
             parentClass != null;
             parentClass = parentClass.getSuperclass()) {
            // fields.addAll(Arrays.asList(parentClass.getDeclaredFields()));
            fields = ExoCollection.mergeArrays(fields, parentClass.getDeclaredFields(), Field.class);
        }
        return fields;
    }

    /**
     * Получение названия поля.
     * @author Namespace Stedd
     * @return название поля
     */
    public String getName() {
        return this.field.getName();
    }

    /**
     * Получение значения текущего поля.
     * @author Namespace Stedd
     * @return значение текущего поля
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * Получение значения текущего поля.
     * @author Namespace Stedd
     * @param defaultValue значение поля при NULL
     * @return значение текущего поля
     */
    public Object getValue(Object defaultValue) {
        return this.value != null ? this.value : defaultValue;
    }

    /**
     * Получение значения поля.
     * @author Namespace Stedd
     * @param field поле класса
     * @param instance экземпляр класса
     * @return значение поля
     */
    public static Object getValue(Field field, Object instance) {
        return getValue(field, instance, null);
    }

    /**
     * Получение значения поля.
     * @author Namespace Stedd
     * @param field поле класса
     * @param instance экземпляр класса
     * @param defaultValue значение поля при NULL
     * @return значение поля
     */
    public static Object getValue(Field field, Object instance, Object defaultValue) {
        field.setAccessible(true);
        try {
            return instance == null ? defaultValue : field.get(instance);
        }
        catch (IllegalAccessException ignored) {
            return defaultValue;
        }
    }

    /**
     * Обновление значения поля.
     * @author Namespace Stedd
     * @param instance экземпляр класса
     */
    public void setValue(Object instance) {
        this.setValue(instance, null);
    }

    /**
     * Обновление значения поля.
     * @author Namespace Stedd
     * @param instance экземпляр класса
     * @param value устанавливаемое значение
     */
    public void setValue(Object instance, Object value) {
        setValue(this.field, instance, value);
        this.value = value;
    }

    /**
     * Обновление значения поля.
     * @author Namespace Stedd
     * @param field поле класса
     * @param instance экземпляр класса
     */
    public static void setValue(Field field, Object instance) {
        setValue(field, instance, null);
    }

    /**
     * Обновление значения поля.
     * @author Namespace Stedd
     * @param field поле класса
     * @param instance экземпляр класса
     * @param value устанавливаемое значение
     */
    public static void setValue(Field field, Object instance, Object value) {
        field.setAccessible(true);
        try {
            field.set(instance, value);
        } catch (IllegalAccessException ignored) {}
    }

    /**
     * Обновление значения поля указанного экземпляра класса.
     * @author Namespace Stedd
     * @param instance экземпляр класса
     */
    public void setValueTo(Object instance) {
        this.setValue(instance, this.value);
    }

    /**
     * Статус принадлежности объекта к примитивному типу данных.
     * @author Namespace Stedd
     * @return принадлежность объекта к примитиву
     */
    public boolean isPrimitive() {
        return isPrimitive(this.field);
    }

    /**
     * Статус принадлежности объекта к примитивному типу данных.
     * @author Namespace Stedd
     * @param field поле класса
     * @return принадлежность объекта к примитиву
     */
    public static boolean isPrimitive(Field field) {
        return field.getType().isPrimitive();
    }

    /**
     * Определение принадлежности объекта к примитивному типу данных с нулевым значением.
     * @author Namespace Stedd
     * @return принадлежность объекта к нулевому примитиву
     */
    public boolean isZeroField() {
        return this.isZeroField(this.value);
    }

    /**
     * Определение принадлежности объекта к примитивному типу данных с нулевым значением.
     * @author Namespace Stedd
     * @param value значение поля класса
     * @return принадлежность объекта к нулевому примитиву
     */
    public boolean isZeroField(Object value) {
        return isZeroField(this.field, value);
    }

    /**
     * Определение принадлежности объекта к примитивному типу данных с нулевым значением.
     * @author Namespace Stedd
     * @param field поле класса
     * @param object объект
     * @return принадлежность объекта к нулевому примитиву
     */
    public static boolean isZeroField(Field field, Object object) {
        if (!isPrimitive(field)) {
            return object == null;
        }
        return switch (object) {
            case Boolean bool -> !(boolean) object;
            case Number number -> number.doubleValue() == 0.0;
            case Character character -> (char) object == '\u0000';
            default -> false;
        };
    }

    /**
     * Определение содержания указанной аннотации в поле класса.
     * @author Namespace Stedd
     * @param annotation аннотация
     * @return содержание в поле класса
     * @param <T> универсальный параметр типа
     */
    public <T extends Annotation> boolean contains(Class<T> annotation) {
        return this.field.isAnnotationPresent(annotation);
    }

    /**
     * Обновление значения поля по значению в другом экземпляре.
     * @author Namespace Stedd
     * @param field поле класса
     * @param sourceInstance экземпляр-источник данных
     * @param destinationInstance обновляемый экземпляр
     */
    public static void updateWithNullAvoiding(Field field, Object sourceInstance, Object destinationInstance) {
        // Создаём расширенное представление поля
        ExoField exoField = ExoField.create(field, sourceInstance);
        // Проверяем, установлена ли аннотация, отрицающая необходимость применять нулевые поля,
        // в связке с проверкой значения поля источника
        boolean annotationAcceptation = !(exoField.contains(ZeroAvoiding.class) && exoField.isZeroField());
        if (exoField.value != null && annotationAcceptation) {
            exoField.setValueTo(destinationInstance);
        }
    }

    /**
     * Разделённые поля.
     * @author Namespace Stedd
     */
    public static class Split {

        private final Field[] selectedFields;   // Массив выбранных полей
        private final Field[] freeFields;   // Массив свободных полей

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param selectedFields массив выбранных полей
         * @param freeFields массив свободных полей
         */
        public Split(Field[] selectedFields, Field[] freeFields) {
            this.selectedFields = selectedFields;
            this.freeFields = freeFields;
        }

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param selectedFields список выбранных полей
         * @param freeFields список свободных полей
         */
        public Split(List<Field> selectedFields, List<Field> freeFields) {
            this.selectedFields = Converter.toArray(selectedFields, Field.class);
            this.freeFields = Converter.toArray(freeFields, Field.class);
        }

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param selectedFields массив выбранных полей
         * @param freeFields массив свободных полей
         * @return разделённые поля
         */
        public static Split create(Field[] selectedFields, Field[] freeFields) {
            return new Split(selectedFields, freeFields);
        }

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param selectedFields массив выбранных полей
         * @param selectionRule правило выборки
         * @return разделённые поля
         */
        public static Split create(Field[] selectedFields, Rule selectionRule) {
            List<Field> selected = new ArrayList<>(),
                    free = new ArrayList<>();
            for (Field field : selectedFields) {
                if (selectionRule.isSelected(field)) {
                    selected.add(field);
                }
                else {
                    free.add(field);
                }
            }
            return create(selected, free);
        }

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param selectedFields список выбранных полей
         * @param freeFields список свободных полей
         * @return разделённые поля
         */
        public static Split create(List<Field> selectedFields, List<Field> freeFields) {
            return new Split(selectedFields, freeFields);
        }

        /**
         * Создание разделённых полей.
         * @author Namespace Stedd
         * @param selectedFields список выбранных полей
         * @param selectionRule правило выборки
         * @return разделённые поля
         */
        public static Split create(List<Field> selectedFields, Rule selectionRule) {
            return create(Converter.toArray(selectedFields, Field.class), selectionRule);
        }

        /**
         * Получение массива выбранных полей.
         * @author Namespace Stedd
         * @return массив выбранных полей
         */
        public Field[] getSelectedFields() {
            return this.selectedFields;
        }

        /**
         * Получение массива свободных полей.
         * @author Namespace Stedd
         * @return массив свободных полей
         */
        public Field[] getFreeFields() {
            return this.freeFields;
        }

        /**
         * Правило разделения полей.
         * @author Namespace Stedd
         */
        public interface Rule {

            /**
             * Получение принадлежности поля к выборке.
             * @author Namespace Stedd
             * @param field отбираемое поле
             * @return принадлежность поля к выборке
             */
            boolean isSelected(Field field);

        }

    }

}
