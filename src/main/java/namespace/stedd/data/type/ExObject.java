package namespace.stedd.data.type;

import com.google.gson.Gson;
import namespace.stedd.data.Converter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Расширенное представление объекта.
 * @author Namespace Stedd
 */
public interface ExObject {

    /**
     * Получение названия объекта.
     * @author Namespace Stedd
     * @return название объекта
     */
    default String name() {
        return "";
    }

    /**
     * Сравнение равнозначности текущего объекта и указанного.
     * @author Namespace Stedd
     * @param object указанный объект
     * @return равнозначность текущего объекта и указанного
     */
    default boolean equals(ExObject object) {
        return this.equals((Object) object);
    }

    /**
     * Определение принадлежности текущего объекта к указанным.
     * @author Namespace Stedd
     * @param objects указанные объекты
     * @return принадлежность текущего объекта к одному из указанных
     */
    default boolean equals(ExObject... objects) {
        for (ExObject object : objects) {
            if (this.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Преобразование объекта в JSON-строку.
     * @author Namespace Stedd
     * @return строчное представление объекта
     */
    default String toJsonString() {
        return Converter.json.toJson(this);
    }

    /**
     * Преобразование объекта в карту полей класса и их значений.
     * @author Namespace Stedd
     * @return карта полей класса и их значений
     */
    default Map<String, Object> toMap() {
        return this.toMap(true);
    }

    /**
     * Преобразование объекта в карту полей класса и их значений.
     * @author Namespace Stedd
     * @param includeParentFields необходимость включения полей родительского класса
     * @return карта полей класса и их значений
     */
    default Map<String, Object> toMap(boolean includeParentFields) {
        Map<String, Object> map = new HashMap<>();
        for (ExoField field : ExoField.getFields(this, includeParentFields)) {
            map.put(field.getName(), field.getValue());
        }
        return map;
    }

    /**
     * Получение класса из карты объектов.
     * @author Namespace Stedd
     * @param objectMap карта объектов
     * @param t класс выходного объекта
     * @return заполненный объектами класс
     * @param <T> универсальный параметр типа
     */
    static <T> T toObject(Map<String, Object> objectMap, Class<T> t) {
        return toObject(objectMap, t, Converter.json);
    }

    /**
     * Получение класса из карты объектов.
     * @author Namespace Stedd
     * @param objectMap карта объектов
     * @param t класс выходного объекта
     * @param json JSON-элемент
     * @return заполненный объектами класс
     * @param <T> универсальный параметр типа
     */
    static <T> T toObject(Map<String, Object> objectMap, Class<T> t, Gson json) {
        StringBuilder jsonObject = new StringBuilder("{");
        for (String key : objectMap.keySet()) {
            Object value = objectMap.get(key);
            if (value != null) {
                jsonObject.append('"').append(key).append('"')
                        .append(':').append('"').append(value).append('"').append(',');
            }
        }
        return json.fromJson(jsonObject.replace(jsonObject.length() - 1, jsonObject.length(), "}").toString(), t);
    }

    /**
     * Проверка объекта на принадлежность к примитивному типу данных.
     * @author Namespace Stedd
     * @param object проверяемый объект
     * @return возможность преобразования в примитив
     */
    static boolean seemsLikePrimitive(Object object) {
        String stringObject = ExoString.parseString(object, null);
        if (stringObject == null || stringObject.isEmpty()) {
            return false;
        }
        if (stringObject.equals("true") || stringObject.equals("false")) {
            return true;
        }
        boolean dotAlreadyExist = false;
        for (char charee : stringObject.toCharArray()) {
            if (charee == '.' && !dotAlreadyExist) {
                dotAlreadyExist = true;
            }
            else if (charee == '.' || !Character.isDigit(charee)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Обновление параметров объекта по JSON-объекту.
     * @author Namespace Stedd
     * @param json строковый JSON-объект
     * @param implementedClass реализованный интерфейс
     * @param <T> универсальный параметр типа
     */
    default <T extends ExObject> void update(String json, Class<T> implementedClass) {
        // Получение объекта из JSON
        ExObject exobject = Converter.json.fromJson(json, implementedClass);
        this.update(exobject);
    }

    /**
     * Обновление параметров расширенного объекта по другому расширенному объекту.
     * @author Namespace Stedd
     * @param object представляемый расширенный объект
     */
    default void update(ExObject object) {
        // Получение полей класса
        Field[] fields = this.getClass().getDeclaredFields();
        // Перебор полей класса
        for (Field field : fields) {
            // Обновление полей, на которых присутствует значение
            ExoField.updateWithNullAvoiding(field, object, this);
        }
    }

}
