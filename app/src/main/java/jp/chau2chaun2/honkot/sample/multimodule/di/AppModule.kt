package jp.chau2chaun2.honkot.sample.multimodule.di

import com.github.gfx.android.orma.AccessThreadConstraint
import dagger.Module
import dagger.Provides
import jp.chau2chaun2.honkot.sample.multimodule.CustomApplication
import jp.chau2chaun2.honkot.sample.multimodule.model.OrmaDatabase
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideOrma(app: CustomApplication): OrmaDatabase  {
        return OrmaDatabase.builder(app.applicationContext)
            .readOnMainThread(AccessThreadConstraint.NONE)
            .writeOnMainThread(AccessThreadConstraint.NONE)
            .name("honkot.db")
            .build()
    }
}
