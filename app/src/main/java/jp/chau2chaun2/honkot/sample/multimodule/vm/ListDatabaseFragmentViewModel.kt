package jp.chau2chaun2.honkot.sample.multimodule.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.chau2chaun2.honkot.sample.multimodule.data.model.Repo
import jp.chau2chaun2.honkot.sample.repository.RepoRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListDatabaseFragmentViewModel @Inject constructor(
    private val repoRepository: RepoRepository
) : jp.chau2chaun2.honkot.sample.multimodule.util.IDataLoading, ViewModel() {

    private val _loading = MutableLiveData<Boolean>()

    override val loading: LiveData<Boolean> = _loading

    private val _displayItems = MutableLiveData<List<Repo>>()

    val displayItems: LiveData<List<Repo>> = _displayItems

    fun load() {
        viewModelScope.launch {
            _loading.postValue(true)
            _displayItems.value = repoRepository.getModels()
            _loading.postValue(false)
        }
    }
}
