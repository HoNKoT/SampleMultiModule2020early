package jp.chau2chaun2.honkot.sample.multimodule.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.chau2chaun2.honkot.sample.multimodule.model.Repo
import jp.chau2chaun2.honkot.sample.multimodule.repository.RepoRepository
import jp.chau2chaun2.honkot.sample.multimodule.util.IDataLoading
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListDatabaseFragmentViewModel @Inject constructor(
    private val repoRepository: RepoRepository
) : IDataLoading, ViewModel() {
    override val loading = MutableLiveData<Boolean>()

    val displayItems = MutableLiveData<List<Repo>>()

    fun load() {
        viewModelScope.launch {
            loading.postValue(true)
            displayItems.value = repoRepository.getModels()
            loading.postValue(false)
        }
    }
}
