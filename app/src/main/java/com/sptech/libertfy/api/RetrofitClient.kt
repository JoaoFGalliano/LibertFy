package com.sptech.libertfy.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var retrofit: Retrofit? = null

    private const val BASE_URL = "http://ec2-23-22-61-175.compute-1.amazonaws.com:8080/"

    fun getClient(): Retrofit {
        if (retrofit == null) {
            val client = OkHttpClient.Builder().build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit!!
    }
}