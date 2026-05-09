package namespace.stedd.data.type;

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

}
