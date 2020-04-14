package jp.chau2chaun2.honkot.sample.multimodule.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.chau2chaun2.honkot.sample.multimodule.util.IDataLoading
import javax.inject.Inject

class ListAPIFragmentViewModel @Inject constructor() : IDataLoading, ViewModel() {
    private val mLoading = MutableLiveData(false)

    override val loading: LiveData<Boolean> = mLoading
}
