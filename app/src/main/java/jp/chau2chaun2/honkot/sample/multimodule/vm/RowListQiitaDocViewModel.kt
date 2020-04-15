package jp.chau2chaun2.honkot.sample.multimodule.vm

import android.graphics.Bitmap
import androidx.lifecycle.*
import jp.chau2chaun2.honkot.sample.multimodule.model.QiitaDoc
import jp.chau2chaun2.honkot.sample.multimodule.repository.ImageRepository
import jp.chau2chaun2.honkot.sample.multimodule.util.DateTimeUtil
import kotlinx.coroutines.launch

class RowListQiitaDocViewModel(
    private val imageRepository: ImageRepository,
    qiitaDoc: QiitaDoc
) : ViewModel() {

    private var data = MutableLiveData<QiitaDoc>()

    val docTitle: LiveData<String> = Transformations.map(data) { it.title }

    val userName: LiveData<String> = Transformations.map(data) { "@${it.user.id}" }

    val createdAt: LiveData<String> = Transformations.map(data) { jp.chau2chaun2.honkot.sample.multimodule.util.DateTimeUtil.format(it.createdAt) }

    val lgtmCount: LiveData<String> = Transformations.map(data) { it.likesCount.toString() }

    val commentCount: LiveData<String> = Transformations.map(data) { it.commentsCount.toString() }

    private var _loading = MutableLiveData<Boolean>()

    val loading: LiveData<Boolean> = _loading

    private var _bitmap = MutableLiveData<Bitmap>()

    val bitmap: LiveData<Bitmap> = _bitmap

    init {
        updateModel(qiitaDoc)
    }

    fun updateModel(qiitaDoc: QiitaDoc) {
        viewModelScope.launch {
            _loading.postValue(true)
            data.value = qiitaDoc
            _bitmap.value = imageRepository.loadImage(qiitaDoc.user.profileImageUrl ?: "")
            _loading.postValue(false)
        }
    }
}
