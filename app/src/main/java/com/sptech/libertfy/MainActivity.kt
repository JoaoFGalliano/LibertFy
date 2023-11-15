package com.sptech.libertfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}