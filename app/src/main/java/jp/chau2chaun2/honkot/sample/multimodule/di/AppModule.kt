package jp.chau2chaun2.honkot.sample.multimodule.di

import android.content.Context
import android.content.res.Resources
import com.github.gfx.android.orma.AccessThreadConstraint
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import jp.chau2chaun2.honkot.sample.multimodule.CustomApplication
import jp.chau2chaun2.honkot.sample.multimodule.api.IQiitaService
import jp.chau2chaun2.honkot.sample.multimodule.model.OrmaDatabase
import jp.chau2chaun2.honkot.sample.multimodule.util.DateTimeUtil
import okhttp3.OkHttpClient
import org.threeten.bp.ZonedDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    fun provideGson(): Gson {
        return GsonBuilder()
            .serializeNulls()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(ZonedDateTime::class.java, DateTimeUtil.DateTimestampSerializer())
            .registerTypeAdapter(ZonedDateTime::class.java, DateTimeUtil.DateTimestampDeserializer())
            .create()
    }

    @Singleton
    @Provides
    fun provideQiitaService(gson: Gson): IQiitaService {
        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://qiita.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
        return retrofit.create(IQiitaService::class.java)
    }
}
