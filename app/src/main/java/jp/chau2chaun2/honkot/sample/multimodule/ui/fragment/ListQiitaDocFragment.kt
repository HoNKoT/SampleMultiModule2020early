package jp.chau2chaun2.honkot.sample.multimodule.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.afri_inc.senri.utils.autoCleared
import dagger.android.support.DaggerFragment
import jp.chau2chaun2.honkot.sample.multimodule.feature.list_database.databinding.FragmentListBinding
import jp.chau2chaun2.honkot.sample.multimodule.ui.adapter.ListQiitaDocAdapter
import jp.chau2chaun2.honkot.sample.multimodule.vm.ListQiitaDocFragmentViewModel
import jp.chau2chaun2.honkot.sample.repository.ImageRepository
import javax.inject.Inject

class ListQiitaDocFragment : DaggerFragment() {
    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    @Inject
    lateinit var imageRepository: ImageRepository

    private val viewModel by viewModels<ListQiitaDocFragmentViewModel> { vmFactory }

    private var binding by autoCleared<FragmentListBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.dataLoadingState = viewModel
        initializeObserver()
        viewModel.load()
    }

    private fun initializeObserver() {
        // 表示情報の更新を検知
        viewModel.displayItems.observe(viewLifecycleOwner, Observer { items ->
            (binding.list.adapter as? ListQiitaDocAdapter)?.let {
                it.addModels(items)
            } ?: run {
                binding.list.adapter =
                    ListQiitaDocAdapter(
                        viewLifecycleOwner,
                        imageRepository,
                        layoutInflater,
                        items
                    )
            }
        })
    }
}