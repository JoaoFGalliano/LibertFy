package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.databinding.ActivityLoginBinding

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
}