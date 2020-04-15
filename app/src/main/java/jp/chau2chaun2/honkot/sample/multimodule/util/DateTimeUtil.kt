package jp.chau2chaun2.honkot.sample.multimodule.util

import com.google.gson.*
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeParseException
import java.lang.reflect.Type

object DateTimeUtil {
    fun parseFrom(value: String): ZonedDateTime = ZonedDateTime.parse(value)

    fun toString(date: ZonedDateTime): String = date.toString()

    class DateTimestampSerializer : JsonSerializer<ZonedDateTime?> {
        override fun serialize(
            src: ZonedDateTime?,
            typeOfSrc: Type,
            context: JsonSerializationContext
        ): JsonElement {
            return JsonPrimitive(toString(src ?: ZonedDateTime.now()))
        }
    }

    class DateTimestampDeserializer :
        JsonDeserializer<ZonedDateTime?> {
        @Throws(JsonParseException::class)
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type,
            context: JsonDeserializationContext
        ): ZonedDateTime? {
            return try {
                ZonedDateTime.parse(json.asString)
            } catch (e1: DateTimeParseException) {
                ZonedDateTime.now()
            }
        }
    }
}
