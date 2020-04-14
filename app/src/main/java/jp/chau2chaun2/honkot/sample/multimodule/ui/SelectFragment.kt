package jp.chau2chaun2.honkot.sample.multimodule.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import jp.chau2chaun2.honkot.sample.multimodule.R

class SelectFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.useDatabaseButton).apply {
            setOnClickListener {
                val action = SelectFragmentDirections.actionSelectFragmentToListDatabaseFragment()
                findNavController().navigate(action)
            }
        }

        view.findViewById<Button>(R.id.useAPIButton).apply {
            setOnClickListener {
                val action = SelectFragmentDirections.actionSelectFragmentToListAPIFragment()
                findNavController().navigate(action)
            }
        }
    }
}