package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.api.LibertFyAPI
import com.sptech.libertfy.databinding.ActivityCategoriasBinding

class Categorias : AppCompatActivity() {

    val binding by lazy {

        ActivityCategoriasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.icVoltar3.setOnClickListener {
            val irParaPrincipal = Intent(this, MainActivity::class.java)
            startActivity(irParaPrincipal)
        }

        binding.catJapa.setOnClickListener {
            val japonesa = Intent(this, Restaurantes::class.java)
            startActivity(japonesa)
        }
        binding.catChina.setOnClickListener {
            val chinesa = Intent(this, Restaurantes::class.java)
            startActivity(chinesa)
        }
        binding.catCor.setOnClickListener {
            val coreana = Intent(this, Restaurantes::class.java)
            startActivity(coreana)
        }
    }
}