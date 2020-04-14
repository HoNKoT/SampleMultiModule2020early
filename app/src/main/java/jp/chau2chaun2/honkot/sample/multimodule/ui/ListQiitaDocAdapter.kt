package jp.chau2chaun2.honkot.sample.multimodule.ui

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import jp.chau2chaun2.honkot.sample.multimodule.R
import jp.chau2chaun2.honkot.sample.multimodule.databinding.RowListQiitaDocBinding
import jp.chau2chaun2.honkot.sample.multimodule.model.QiitaDoc
import jp.chau2chaun2.honkot.sample.multimodule.repository.ImageRepository

class ListQiitaDocAdapter(
    private val viewLifecycleOwner: LifecycleOwner,
    private val imageRepository: ImageRepository,
    private val layoutInflater: LayoutInflater,
    items: List<QiitaDoc>
) : BaseAdapter() {

    private val displayItems = ArrayList<QiitaDoc>()

    init {
        displayItems.addAll(items)
    }

    fun addModels(items: List<QiitaDoc>) {
        this.displayItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(position)
        val binding = convertView?.let {
            (DataBindingUtil.bind(it) as? RowListQiitaDocBinding)!!.also {
                it.viewModel?.updateModel(item)
            }
        } ?: run {
            DataBindingUtil.inflate<RowListQiitaDocBinding>(layoutInflater, R.layout.row_list_qiita_doc, null, false).also {
                it.lifecycleOwner = viewLifecycleOwner
                it.viewModel = RowListQiitaDocViewModel(imageRepository, item)
            }
        }
        binding.executePendingBindings()
        return binding.root
    }

    override fun getItem(position: Int) = displayItems[position]

    override fun getItemId(position: Int) = 0L

    override fun getCount(): Int = displayItems.size

    companion object {
        @BindingAdapter("image")
        @JvmStatic
        fun setImageBitmap(imageView: ImageView, bitmap: Bitmap?) {
            imageView.setImageBitmap(bitmap)
        }
    }
}
