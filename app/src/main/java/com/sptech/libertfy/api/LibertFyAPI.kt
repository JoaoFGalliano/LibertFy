package com.sptech.libertfy.api

import com.sptech.libertfy.api.model.Restaurante
import com.sptech.libertfy.api.model.Usuario
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
//import retrofit2.http.DELETE
//import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface LibertFyAPI {

    //Usuarios
    @GET("/usuarios")
    fun get(): Call<List<Usuario>>

    @POST("/usuarios/login")
    fun login(@Body requestBody: RequestBody): Call<Usuario>

    @GET("/usuarios/{id}")
    fun get(@Path("id") id: Int): Call<Usuario>

    @POST("/usuarios/criar")
    fun post(@Body requestBody: Usuario): Call<Void>

//    @DELETE("/usuarios/{id}")
//    fun delete(@Path("id") id: Int): Call<Void>

    //Restaurantes
    @GET("/restaurantes")
    fun listarRestaurantes(): Call<Restaurante>

    @GET("/restaurantes/{id}")
    fun mostrarRestaurante(@Path("id") id: Int): Call<Restaurante>

    //Categorias
    @GET("/categorias")
    fun buscarCategoria(): Call<Restaurante>

    //Categorias
    @POST("/comentarios")
    fun criarComentario(@Body comentario:String, @Header("authentication") authentication:String): Call<Void>

    companion object {
        var BASE_URL = "http://ec2-23-22-61-175.compute-1.amazonaws.com:8081"
        fun criar():LibertFyAPI {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(LibertFyAPI::class.java)
        }
    }
}
