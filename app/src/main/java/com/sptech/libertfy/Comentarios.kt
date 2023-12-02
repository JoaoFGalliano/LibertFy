package com.sptech.libertfy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.sptech.libertfy.databinding.ActivityComentariosBinding
import com.sptech.libertfy.databinding.ActivityLoginBinding


class Comentarios : AppCompatActivity() {

    val binding by lazy {

        ActivityComentariosBinding.inflate(layoutInflater)
    }
    lateinit var comentario: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mostrar = findViewById<TextView>(R.id.tvComentario)

    }

    fun inicializar() {
//        comentario = findViewById<EditText>(R.id.etComent)
    }

}

