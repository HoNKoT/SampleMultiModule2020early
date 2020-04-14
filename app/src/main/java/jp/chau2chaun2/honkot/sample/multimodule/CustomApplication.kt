package jp.chau2chaun2.honkot.sample.multimodule

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import jp.chau2chaun2.honkot.sample.multimodule.di.DaggerAppComponent

class CustomApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}
