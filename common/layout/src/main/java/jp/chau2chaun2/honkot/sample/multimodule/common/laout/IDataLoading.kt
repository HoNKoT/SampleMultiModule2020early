package jp.chau2chaun2.honkot.sample.multimodule.common.laout

import androidx.lifecycle.LiveData

interface IDataLoading {
    val loading: LiveData<Boolean>
}
