package jp.chau2chaun2.honkot.sample.multimodule.util

import com.google.gson.*
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.DateTimeParseException
import java.lang.reflect.Type

object DateTimeUtil {
    private val formatDate = DateTimeFormatter.ofPattern("yyyy/MM/dd")

    fun toString(date: ZonedDateTime): String = date.toString()

    fun format(zonedDateTime: ZonedDateTime): String = zonedDateTime.format(formatDate)

    class DateTimestampSerializer : JsonSerializer<ZonedDateTime?> {
        override fun serialize(
            src: ZonedDateTime?,
            typeOfSrc: Type,
            context: JsonSerializationContext
        ): JsonElement {
            return JsonPrimitive(
                toString(
                    src ?: ZonedDateTime.now()
                )
            )
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
