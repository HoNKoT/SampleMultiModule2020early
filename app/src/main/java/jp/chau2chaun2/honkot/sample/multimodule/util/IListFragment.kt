package jp.chau2chaun2.honkot.sample.multimodule.util

import androidx.lifecycle.MutableLiveData

interface IDataLoading {
    val loading: MutableLiveData<Boolean>
}
