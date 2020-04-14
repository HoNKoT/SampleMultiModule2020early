package jp.chau2chaun2.honkot.sample.multimodule.ui

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

    val loading = MutableLiveData<Boolean>()

    val bitmap = MutableLiveData<Bitmap>()

    init {
        updateModel(qiitaDoc)
    }

    fun updateModel(qiitaDoc: QiitaDoc) {
        viewModelScope.launch {
            loading.postValue(true)
            data.value = qiitaDoc
            bitmap.value = imageRepository.loadImage(qiitaDoc.user.profileImageUrl ?: "")
            loading.postValue(false)
        }
    }
}
