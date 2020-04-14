package jp.chau2chaun2.honkot.sample.multimodule.util

import androidx.lifecycle.LiveData

interface IDataLoading {
    val loading: LiveData<Boolean>
}
