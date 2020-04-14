package jp.chau2chaun2.honkot.sample.multimodule.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import jp.chau2chaun2.honkot.sample.multimodule.databinding.FragmentListBinding
import jp.chau2chaun2.honkot.sample.multimodule.vm.ListDatabaseFragmentViewModel
import javax.inject.Inject

class ListDatabaseFragment : DaggerFragment() {
    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<ListDatabaseFragmentViewModel> { vmFactory }

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.dataLoadingState = viewModel
    }
}