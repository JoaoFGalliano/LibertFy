package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sptech.libertfy.databinding.ActivityMainBinding
import com.sptech.libertfy.sessao.Sessao

class MainActivity : AppCompatActivity() {
    val binding by lazy {

        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val token = "lweijfiojeri"
        Sessao.token = token


        binding.btRest.setOnClickListener {
            val irParaRestaurantes = Intent(this, Restaurantes::class.java)
            startActivity(irParaRestaurantes)
        }

        binding.btPerfil.setOnClickListener {
            val irParaPerfil = Intent(this, Perfil::class.java)
            startActivity(irParaPerfil)
        }
    }
}