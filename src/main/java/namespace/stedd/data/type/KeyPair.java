package namespace.stedd.data.type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import namespace.stedd.data.Converter;

import java.lang.reflect.Field;

/**
 * Пара ключ-значение.
 * @author Namespace Stedd
 */
public class KeyPair {

    protected String key;   // Ключ
    protected Object value;   // значение

    /**
     * Создание пары ключ-значение.
     * @author Namespace Stedd
     * @param key ключ
     * @param value значение
     */
    public KeyPair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Создание пары ключ-значение по полю и экземпляру класса, хранящему это значение.
     * @author Namespace Stedd
     * @param field поле класса
     * @param instance экземпляр класса
     */
    public KeyPair(Field field, Object instance) {
        this.key = field.getName();
        this.value = ExoField.getValue(field, instance);
    }

    /**
     * Создание пары ключ-значение.
     * @author Namespace Stedd
     * @param key ключ
     * @param value значение
     * @return пара ключ-значение
     */
    public static KeyPair create(String key, Object value) {
        return new KeyPair(key, value);
    }

    /**
     * Получение ключа.
     * @author Namespace Stedd
     * @return ключ
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Обновление ключа.
     * @author Namespace Stedd
     * @param key новый ключ
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Получение значения.
     * @author Namespace Stedd
     * @return значение
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * Обновление значения.
     * @author Namespace Stedd
     * @param value новое значение
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * // TODO: Метод по установке JSON.key:value?
     * Получение пары ключ-значения для JSON-объектов.
     * @author Namespace Stedd
     * @param key ключ
     * @param value значение
     * @return JSON-пара ключ-значение
     */
    public static String getJsonKeyPair(String key, Object value) {
        JsonObject object = new JsonObject();
        JsonElement je = Converter.json.toJsonTree(value);
        object.add(key, je);
        return object.toString().replace("{", "").replace("}", "");
    }

}
