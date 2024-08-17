package com.pandaapps.medicalstoremangementsystem.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    val api: Api_Builder =
        Retrofit.Builder()
            .client(client)
            .baseUrl(Api_Builder.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api_Builder::class.java)

}