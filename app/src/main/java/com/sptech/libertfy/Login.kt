package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.api.LibertFyAPI
import com.sptech.libertfy.api.model.Usuario
import com.sptech.libertfy.databinding.ActivityLoginBinding
import com.sptech.libertfy.sessao.Sessao
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Response

class Login : AppCompatActivity() {

    val binding by lazy {

        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.icVoltar2.setOnClickListener {
            val irParaCadastro = Intent(this, Cadastro::class.java)
            startActivity(irParaCadastro)
        }

        binding.txtCadastro.setOnClickListener {
            val irParaCadastro = Intent(this, Cadastro::class.java)
            startActivity(irParaCadastro)
        }
    }

    private fun logar() {
        val endpoint = LibertFyAPI.criar()

        val jsonPayload =
            "{\"email\": \"${binding.etUsuario.text.toString()}\",\n" +
                    "  \"senha\": \"${binding.etSenha.text.toString()}\"}"

        val requestBody = jsonPayload.toRequestBody("application/json".toMediaTypeOrNull())


        val callback = endpoint.login(requestBody)
        callback.enqueue(object : retrofit2.Callback<Usuario> {

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                when {
                    response.isSuccessful -> {
                        print("Deu Bom")
                        Sessao.usuario = response.body()!!
                        val intent = Intent(this@Login, MainActivity::class.java)
                        startActivity(intent)
                    }
                    // Faça algo com os dados do usuário
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                println("Deu Ruim ${t.message}")
            }
        })
    }
}
