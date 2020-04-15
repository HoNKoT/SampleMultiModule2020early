package jp.chau2chaun2.honkot.sample.multimodule.repository

import jp.chau2chaun2.honkot.sample.multimodule.data.dao.RepoDao
import jp.chau2chaun2.honkot.sample.multimodule.data.model.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoRepository @Inject constructor(
    private val repoDao: RepoDao
) {
    suspend fun getModels(): List<Repo> = withContext(Dispatchers.IO) {
        if (!repoDao.hasModel()) {
            repoDao.initialize()
        }
        return@withContext repoDao.getModels()
    }
}
