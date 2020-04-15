package jp.chau2chaun2.honkot.sample.multimodule.vm

import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import jp.chau2chaun2.honkot.sample.multimodule.data.model.Repo

class RowListDatabaseViewModel(
    private val resources: Resources,
    repo: Repo
) : ViewModel() {

    private var data = MutableLiveData<Repo>()

    val index: LiveData<String> = Transformations.map(data) { it.index.toString() }

    val message: LiveData<String> = Transformations.map(data) { it.message }

    val color: LiveData<Drawable> = Transformations.map(data) {
        ColorDrawable(ResourcesCompat.getColor(resources, it.colorType.resId, null))
    }

    init {
        updateModel(repo)
    }

    fun updateModel(repo: Repo) {
        data.value = repo
    }
}
