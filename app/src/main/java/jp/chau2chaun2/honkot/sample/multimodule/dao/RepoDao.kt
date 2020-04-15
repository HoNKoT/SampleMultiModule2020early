package jp.chau2chaun2.honkot.sample.multimodule.dao

import jp.chau2chaun2.honkot.sample.multimodule.data.model.ColorType
import jp.chau2chaun2.honkot.sample.multimodule.model.OrmaDatabase
import jp.chau2chaun2.honkot.sample.multimodule.data.model.Repo
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class RepoDao @Inject constructor(
    private val orma: OrmaDatabase
) {
    fun hasModel(): Boolean = !orma.relationOfRepo().isEmpty

    /**
     * @return all data array
     */
    fun getModels(): List<Repo> {
        return orma.relationOfRepo().toList()
    }

    /**
     * Insert data as initialize
     */
    fun initialize() {
        val random = Random(System.currentTimeMillis())
        val colors = ColorType.values()
        IntRange(0, INITIALISE_MODEL_COUNT).forEach { index ->
            orma.insertIntoRepo(
                Repo().also {
                it.index = index
                it.message = "0x${Integer.toHexString(it.hashCode())}"
                it.colorType = colors[random.nextInt(0, colors.lastIndex)]
            })
        }
    }

    companion object {
        private const val INITIALISE_MODEL_COUNT = 5000
    }
}
