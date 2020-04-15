package jp.chau2chaun2.honkot.sample.multimodule.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.chau2chaun2.honkot.sample.multimodule.model.QiitaDoc
import jp.chau2chaun2.honkot.sample.multimodule.repository.QiitaDocRepository
import jp.chau2chaun2.honkot.sample.multimodule.util.IDataLoading
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListQiitaDocFragmentViewModel @Inject constructor(
    private val qiitaDocRepository: QiitaDocRepository
) : jp.chau2chaun2.honkot.sample.multimodule.util.IDataLoading, ViewModel() {
    private val _loading = MutableLiveData<Boolean>()

    override val loading: LiveData<Boolean> = _loading

    private val _displayItems = MutableLiveData<List<QiitaDoc>>()

    val displayItems: LiveData<List<QiitaDoc>> = _displayItems

    fun load() {
        viewModelScope.launch {
            _loading.postValue(true)
            _displayItems.value = qiitaDocRepository.getQiitaDocs()
            _loading.postValue(false)
        }
    }
}
