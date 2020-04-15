package jp.chau2chaun2.honkot.sample.multimodule.data.api_builder

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import jp.chau2chaun2.honkot.sample.multimodule.util.DateTimeUtil
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class CustomGsonBuilder @Inject constructor() {
    fun buildGson(): Gson {
        return GsonBuilder()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(ZonedDateTime::class.java, DateTimeUtil.DateTimestampSerializer())
            .registerTypeAdapter(ZonedDateTime::class.java, DateTimeUtil.DateTimestampDeserializer())
            .create()
    }
}
