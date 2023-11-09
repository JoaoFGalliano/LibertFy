package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.databinding.ActivityPerfilBinding

class Perfil : AppCompatActivity() {

    val binding by lazy {

        ActivityPerfilBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btHome.setOnClickListener {
            val irParaHome = Intent(this, MainActivity::class.java)
            startActivity(irParaHome)
        }

        binding.btRest.setOnClickListener {
            val irParaRestaurantes = Intent(this, Restaurantes::class.java)
            startActivity(irParaRestaurantes)
        }
    }
}