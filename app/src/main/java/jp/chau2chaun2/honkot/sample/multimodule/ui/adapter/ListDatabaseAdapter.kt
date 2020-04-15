package jp.chau2chaun2.honkot.sample.multimodule.ui.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import jp.chau2chaun2.honkot.sample.multimodule.R
import jp.chau2chaun2.honkot.sample.multimodule.databinding.RowListDatabaseBinding
import jp.chau2chaun2.honkot.sample.multimodule.data.model.Repo
import jp.chau2chaun2.honkot.sample.multimodule.vm.RowListDatabaseViewModel

class ListDatabaseAdapter(
    private val viewLifecycleOwner: LifecycleOwner,
    private val layoutInflater: LayoutInflater,
    private val resources: Resources,
    private var items: List<Repo>
) : BaseAdapter() {
    fun updateModels(items: List<Repo>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(position)
        val binding = convertView?.let {
            (DataBindingUtil.bind(it) as? RowListDatabaseBinding)!!.also {
                it.viewModel?.updateModel(item)
            }
        } ?: run {
            DataBindingUtil.inflate<RowListDatabaseBinding>(layoutInflater, R.layout.row_list_database, null, false).also {
                it.lifecycleOwner = viewLifecycleOwner
                it.viewModel =
                    RowListDatabaseViewModel(
                        resources,
                        item
                    )
            }
        }
        binding.executePendingBindings()
        return binding.root
    }

    override fun getItem(position: Int) = items[position]

    override fun getItemId(position: Int) = 0L

    override fun getCount(): Int = items.size

}
