package com.sptech.libertfy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.sptech.libertfy.api.LibertFyAPI
import com.sptech.libertfy.api.model.Usuario
import com.sptech.libertfy.databinding.ActivityCadastroBinding
import com.sptech.libertfy.sessao.Sessao
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDate


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

    @RequiresApi(Build.VERSION_CODES.O)
    private fun cadastrar() {
        val endpoint = LibertFyAPI.criar()

        // Crie sua carga útil "raw" como uma String
        val jsonPayload = """
            
        """.trimIndent()
                     "{\"nome\": \"${binding.etUsuario.text.toString()}\",\n" +
                    "  \"genero\": \"${binding.etGenero.text.toString()}\",\n" +
                    "  \"data\": \"${binding.etData.text.toString()}\",\n" +
                    "  \"email\": \"${binding.etEmail.text.toString()}\",\n" +
                    "  \"senha\": \"${binding.etSenha.text.toString()}\"}"

        // Converta a String em um RequestBody
        val requestBody = jsonPayload.toRequestBody("application/json".toMediaTypeOrNull())

       // endpoint.criarComentario("oijioiou", Sessao.token)

        // Faça a chamada à API passando o RequestBody
        val usuario = Usuario(
            null,
            binding.etUsuario.text.toString(),
            binding.etGenero.text.toString(),
            binding.etData.text.toString(),
            binding.etEmail.text.toString(),
            binding.etSenha.text.toString()
        )
        val callback = endpoint.post(usuario)
        callback.enqueue(object : retrofit2.Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                when {
                    response.isSuccessful -> {
                        print("Deu Bom")
                        val intent = Intent(this@Cadastro, Login::class.java)
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                println("Deu Ruim ${t.message}")
            }
        })
    }
}