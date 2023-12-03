package com.sptech.libertfy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.sptech.libertfy.api.LibertFyAPI
import com.sptech.libertfy.databinding.ActivityComentariosBinding
import com.sptech.libertfy.databinding.ActivityLoginBinding
import com.sptech.libertfy.sessao.Sessao.token
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Comentarios : AppCompatActivity() {



//    val binding by lazy {
//
//        ActivityComentariosBinding.inflate(layoutInflater)
//    }
//    lateinit var comentario: String

    private lateinit var binding: ActivityComentariosBinding
    private lateinit var comentarioTextView: TextView

    private lateinit var etComent: EditText
    private lateinit var icOk: ImageView

    private lateinit var tvComentarioEnviado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val mostrar = findViewById<TextView>(R.id.tvComentario)
//        binding = ActivityComentariosBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        // Inicializar a TextView
//        comentarioTextView = binding.tvComentario

        setContentView(R.layout.activity_comentarios)

        etComent = findViewById(R.id.etComent)
        icOk = findViewById(R.id.icOk)

        icOk.setOnClickListener {
            enviarComentario()
        }

        tvComentarioEnviado = findViewById(R.id.tvComentarioEnviado)

    }




    private fun enviarComentario() {
        val comentario = etComent.text.toString()

        val usuarioId = 1
        val restauranteId = 2
        val avaliacao = 4.5

        if (comentario.isNotEmpty()) {
            val jsonComentario = """
            {
                "comentario": "$comentario",
                "usuarioId": $usuarioId,
                "restauranteId": $restauranteId,
                "avaliacao": $avaliacao
            }
        """.trimIndent()


            val requestBody = jsonComentario.toRequestBody("application/json".toMediaTypeOrNull())

            val endpoint = LibertFyAPI.criarComentario()
            endpoint.criarComentario(requestBody, "Bearer $token").enqueue(object :
                retrofit2.Callback<Void> {  // Certifique-se de importar a classe correta aqui
                override fun onResponse(call: retrofit2.Call<Void>, response: retrofit2.Response<Void>) {
                    if (response.isSuccessful) {
                        // Comentário enviado com sucesso
                        etComent.text.clear() // Limpar o EditText após o envio
                        // Adicione aqui qualquer lógica adicional após o envio bem-sucedido
                        exibirMensagem("Comentário enviado com sucesso")
                        tvComentarioEnviado.text = "Joao: $comentario"
                        tvComentarioEnviado.visibility = View.VISIBLE
                    } else {
                        // Tratar resposta não bem-sucedida da API
                        // Exemplo: exibir uma mensagem de erro ao usuário
                        exibirMensagem("Erro ao enviar comentário")
                    }
                }

                override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                    // Tratar falha na comunicação com a API
                    // Exemplo: exibir uma mensagem de erro ao usuário
                    exibirMensagem("Falha na comunicação com a API")
                }
            })
        }
    }

    private fun exibirMensagem(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }



    fun inicializar() {
//        comentario = findViewById<EditText>(R.id.etComent)
    }

}

