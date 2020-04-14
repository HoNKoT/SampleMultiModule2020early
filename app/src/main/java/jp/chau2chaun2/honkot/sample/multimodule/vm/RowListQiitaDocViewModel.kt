package jp.chau2chaun2.honkot.sample.multimodule.vm

import android.graphics.Bitmap
import androidx.lifecycle.*
import jp.chau2chaun2.honkot.sample.multimodule.model.QiitaDoc
import jp.chau2chaun2.honkot.sample.multimodule.repository.ImageRepository
import kotlinx.coroutines.launch

class RowListQiitaDocViewModel(
    private val imageRepository: ImageRepository,
    qiitaDoc: QiitaDoc
) : ViewModel() {

    private var data = MutableLiveData<QiitaDoc>()

    val docTitle: LiveData<String> = Transformations.map(data) { "(LGTM: ${it.likesCount}) ${it.title}" }

    val userName: LiveData<String> =
        Transformations.map(data) { "@${it.user.id}" + if (it.user.name?.isNotEmpty() == true) " (${it.user.name})" else "" }

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
