package jp.chau2chaun2.honkot.sample.multimodule.repository

import jp.chau2chaun2.honkot.sample.multimodule.api.IQiitaService
import jp.chau2chaun2.honkot.sample.multimodule.model.QiitaDoc
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QiitaDocRepository @Inject constructor(
    private val qiitaService: IQiitaService
) {
    /**
     * Do not catch an error
     */
    suspend fun getQiitaDocs(): List<QiitaDoc> = withContext(Dispatchers.IO) {
        qiitaService.items(page = 1, perPage = 100)
            .execute()
            .takeIf { it.isSuccessful }?.body() ?: ArrayList()
    }
}
