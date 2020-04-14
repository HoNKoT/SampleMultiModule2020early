package jp.chau2chaun2.honkot.sample.multimodule.api

import jp.chau2chaun2.honkot.sample.multimodule.model.QiitaDoc
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IQiitaService {
    @GET("api/v2/items")
    fun items(
        @Query("page") page: Int,
        @Query("par_page") perPage: Int
    ): Call<List<QiitaDoc>>
}