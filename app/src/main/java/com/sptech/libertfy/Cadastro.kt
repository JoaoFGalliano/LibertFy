package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.api.LibertFyAPI
import com.sptech.libertfy.api.RetrofitClient
import com.sptech.libertfy.api.Usuario
import com.sptech.libertfy.databinding.ActivityCadastroBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Response


class Cadastro : AppCompatActivity() {

    val binding by lazy {

        ActivityCadastroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.txtLogin.setOnClickListener {
            val irParaLogin = Intent(this, Login::class.java)
            startActivity(irParaLogin)
        }

        binding.btCadastro.setOnClickListener {
            cadastrar()
        }

    }

    private fun cadastrar() {
        val retrofitClient = RetrofitClient.getClient()
        val endpoint = retrofitClient.create(LibertFyAPI::class.java)

        // Crie sua carga útil "raw" como uma String
        val jsonPayload =
                     "{\"nome\": \"${binding.etUsuario.text.toString()}\",\n" +
                    "  \"genero\": \"${binding.etGenero.text.toString()}\",\n" +
                    "  \"data\": \"${binding.etData.text.toString()}\",\n" +
                    "  \"email\": \"${binding.etEmail.text.toString()}\",\n" +
                    "  \"senha\": \"${binding.etSenha.text.toString()}\"}"

        // Converta a String em um RequestBody
        val requestBody = jsonPayload.toRequestBody("application/json".toMediaTypeOrNull())

        // Faça a chamada à API passando o RequestBody
        val callback = endpoint.post(requestBody)
        callback.enqueue(object : retrofit2.Callback<Usuario> {

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                when {
                    response.isSuccessful -> {
                        print("Deu Bom")
                        val intent = Intent(this@Cadastro, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                println("Deu Ruim ${t.message}")
            }
        })
    }
}