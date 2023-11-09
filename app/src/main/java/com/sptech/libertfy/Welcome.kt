package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.databinding.ActivityMainBinding
import com.sptech.libertfy.databinding.ActivityWelcomeBinding

class Welcome : AppCompatActivity() {

    val binding by lazy {

        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btAvancar1.setOnClickListener {
            val avancarNext1 = Intent(this, Next1::class.java)
            startActivity(avancarNext1)
        }
    }
}