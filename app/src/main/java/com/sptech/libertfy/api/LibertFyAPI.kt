package com.sptech.libertfy.api

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LibertFyAPI {

    @GET("/usuarios")

    fun get(): retrofit2.Call<List<Usuario>>

    @GET("/usuarios/{id}")
    fun get(@Path("id") id: Int): retrofit2.Call<Usuario>

    @POST("/usuarios/criar")
    fun post(@Body requestBody: RequestBody): Call<Usuario>

    @DELETE("/usuarios/{id}")
    fun delete(@Path("id") id: Int): retrofit2.Call<Void>

}