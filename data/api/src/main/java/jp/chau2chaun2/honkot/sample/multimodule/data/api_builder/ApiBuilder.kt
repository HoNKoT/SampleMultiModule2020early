package jp.chau2chaun2.honkot.sample.multimodule.data.api_builder

import com.google.gson.Gson
import jp.chau2chaun2.honkot.sample.multimodule.data.api.IQiitaService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiBuilder @Inject constructor() {
    fun buildQiitaService(
        baseUrl: String,
        gson: Gson
    ): IQiitaService {
        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
        return retrofit.create(IQiitaService::class.java)
    }
}
