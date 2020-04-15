package jp.chau2chaun2.honkot.sample.multimodule.model

import org.threeten.bp.ZonedDateTime

data class QiitaDoc(
    val title: String,
    val commentsCount: Int,
    val createdAt: ZonedDateTime,
    val likesCount: Int,
    val tags: List<Tag>,
    val user: User
)

data class Tag(val name: String)

data class User(
    val id: String,
    val name: String?,
    val profileImageUrl: String?
)
