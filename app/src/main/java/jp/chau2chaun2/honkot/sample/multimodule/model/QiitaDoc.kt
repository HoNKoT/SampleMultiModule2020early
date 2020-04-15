package jp.chau2chaun2.honkot.sample.multimodule.model

import org.threeten.bp.ZonedDateTime

data class QiitaDoc(
    val renderedBody: String,
    val body: String,
    val coediting: Boolean,
    val commentsCount: Int,
    val createdAt: ZonedDateTime,
    val id: String,
    val likesCount: Int,
    val private: Boolean,
    val reactionsCount: Int,
    val tags: List<Tag>,
    val title: String,
    val updatedAt: ZonedDateTime,
    val url: String,
    val user: User
)

data class Tag(val name: String)

data class User(
    val id: String,
    val name: String?,
    val profileImageUrl: String?
)
