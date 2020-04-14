package jp.chau2chaun2.honkot.sample.multimodule.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import jp.chau2chaun2.honkot.sample.multimodule.CustomApplication

@Module
interface ViewModelModule {

    @Binds
    fun context(app: CustomApplication): Context

    @Binds
    fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
