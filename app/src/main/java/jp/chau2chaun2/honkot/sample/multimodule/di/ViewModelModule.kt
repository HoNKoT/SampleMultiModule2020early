package jp.chau2chaun2.honkot.sample.multimodule.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import jp.chau2chaun2.honkot.sample.multimodule.CustomApplication
import jp.chau2chaun2.honkot.sample.multimodule.feature.list_database.ListDatabaseFragmentViewModel
import jp.chau2chaun2.honkot.sample.multimodule.vm.ListQiitaDocFragmentViewModel

@Module
interface ViewModelModule {

    @Binds
    fun context(app: CustomApplication): Context

    @Binds
    fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListQiitaDocFragmentViewModel::class)
    fun listQiitaDocFragmentViewModel(viewModel: ListQiitaDocFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(jp.chau2chaun2.honkot.sample.multimodule.feature.list_database.ListDatabaseFragmentViewModel::class)
    fun listDatabaseFragmentViewModel(viewModel: jp.chau2chaun2.honkot.sample.multimodule.feature.list_database.ListDatabaseFragmentViewModel): ViewModel
}
