package jp.chau2chaun2.honkot.sample.multimodule.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.chau2chaun2.honkot.sample.multimodule.repository.QiitaDocRepository
import jp.chau2chaun2.honkot.sample.multimodule.model.QiitaDoc
import jp.chau2chaun2.honkot.sample.multimodule.util.IDataLoading
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListQiitaDocFragmentViewModel @Inject constructor(
    private val qiitaDocRepository: QiitaDocRepository
) : IDataLoading, ViewModel() {
    override val loading = MutableLiveData<Boolean>()

    val displayItems = MutableLiveData<List<QiitaDoc>>()

    fun load() {
        viewModelScope.launch {
            loading.postValue(true)
            displayItems.value = qiitaDocRepository.getQiitaDocs()
            loading.postValue(false)
        }
    }
}
