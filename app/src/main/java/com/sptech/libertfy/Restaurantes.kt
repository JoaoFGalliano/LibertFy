package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.api.LibertFyAPI

import com.sptech.libertfy.databinding.ActivityRestaurantesBinding

class Restaurantes : AppCompatActivity() {

    val binding by lazy {

        ActivityRestaurantesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btHome.setOnClickListener {
            val irParaHome = Intent(this, MainActivity::class.java)
            startActivity(irParaHome)
        }

        binding.btPerfil.setOnClickListener {
            val irParaPerfil = Intent(this, Perfil::class.java)
            startActivity(irParaPerfil)
        }
    }

//    private fun buscarRestaurantes(){
//
//        val endpoint = retrofitClient.create(LibertFyAPI::class.java)
//    }

}