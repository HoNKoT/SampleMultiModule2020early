package jp.chau2chaun2.honkot.sample.multimodule.di

import android.content.Context
import android.content.res.Resources
import com.github.gfx.android.orma.AccessThreadConstraint
import dagger.Module
import dagger.Provides
import jp.chau2chaun2.honkot.sample.multimodule.CustomApplication
import jp.chau2chaun2.honkot.sample.multimodule.data.api.IQiitaService
import jp.chau2chaun2.honkot.sample.multimodule.data.api_builder.ApiBuilder
import jp.chau2chaun2.honkot.sample.multimodule.data.api_builder.CustomGsonBuilder
import jp.chau2chaun2.honkot.sample.multimodule.model.OrmaDatabase
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideResources(context: Context): Resources {
        return context.resources
    }

    @Singleton
    @Provides
    fun provideOrma(app: CustomApplication): OrmaDatabase  {
        return OrmaDatabase.builder(app.applicationContext)
            .readOnMainThread(AccessThreadConstraint.NONE)
            .writeOnMainThread(AccessThreadConstraint.NONE)
            .name("honkot.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideQiitaService(customGsonBuilder: CustomGsonBuilder): IQiitaService {
        return ApiBuilder().buildQiitaService("https://qiita.com/", customGsonBuilder.buildGson())
    }
}
