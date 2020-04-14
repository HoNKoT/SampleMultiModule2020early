package jp.chau2chaun2.honkot.sample.multimodule.model

import com.github.gfx.android.orma.annotation.StaticTypeAdapter
import com.github.gfx.android.orma.annotation.StaticTypeAdapters

/**
 * 表示色定義
 */
@StaticTypeAdapters(
    StaticTypeAdapter(
        targetType = ColorType::class,
        serializedType = String::class,
        serializer = "serialize",
        deserializer = "deserialize"
    )
)
enum class ColorType(var resId: Int) {
    Red(android.R.color.holo_red_dark),
    Blue(android.R.color.holo_blue_light),
    Green(android.R.color.holo_green_dark),
    Black(android.R.color.black),
    Gray(android.R.color.darker_gray);

    companion object {
        @JvmStatic
        fun serialize(colorType: ColorType): String = colorType.name

        @JvmStatic
        fun deserialize(name: String): ColorType = values().firstOrNull { it.name == name } ?: Red
    }
}
