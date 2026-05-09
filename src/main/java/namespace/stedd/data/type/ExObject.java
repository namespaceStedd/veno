package namespace.stedd.data.type;

import com.google.gson.Gson;
import namespace.stedd.data.Converter;

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

}
