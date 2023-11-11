package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.databinding.ActivityNext1Binding
import com.sptech.libertfy.databinding.ActivityNext3Binding

class Next3 : AppCompatActivity() {

    val binding by lazy {

        ActivityNext3Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btComecar.setOnClickListener {
            val irParaCadastro = Intent(this, Cadastro::class.java)
            startActivity(irParaCadastro)
        }
    }
}