package jp.chau2chaun2.honkot.sample.multimodule.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.chau2chaun2.honkot.sample.multimodule.ui.ListAPIFragment
import jp.chau2chaun2.honkot.sample.multimodule.ui.ListDatabaseFragment
import jp.chau2chaun2.honkot.sample.multimodule.ui.SelectFragment

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeSelectFragment(): SelectFragment

    @ContributesAndroidInjector
    abstract fun contributeListAPIFragment(): ListAPIFragment

    @ContributesAndroidInjector
    abstract fun contributeListDatabaseFragment(): ListDatabaseFragment
}
