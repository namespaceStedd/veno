package namespace.stedd.data.adapter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Специализированный адаптер формата Даты и Времени.
 * @author Namespace Stedd
 */
public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private final String format;   // Указываемый формат Даты и Времени

    /**
     * Создание специализированного адаптера формата Даты и Времени.
     * @author Namespace Stedd
     * @param format указываемый формат Даты и Времени
     */
    public LocalDateTimeAdapter(String format) {
        this.format = format;
    }

    /**
     * Сериализация формата Даты и Времени.
     * @author Namespace Stedd
     * @param dateTime сущность Даты и Времени
     * @param type тип данных
     * @param context контекст сериализации JSON
     * @return JSON-элемент
     */
    @Override
    public JsonElement serialize(final LocalDateTime dateTime, final Type type, final JsonSerializationContext context) {
        return new JsonPrimitive(dateTime.format(DateTimeFormatter.ofPattern(this.format)));
    }

    /**
     * Десериализация формата Даты и Времени.
     * @author Namespace Stedd
     * @param json JSON-элемент
     * @param type тип Данных
     * @param context контекст десериализации JSON
     * @return сущность Даты и Времени
     * @throws JsonParseException исключение JSON-преобразования
     */
    @Override
    public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ofPattern(this.format));
    }

}
