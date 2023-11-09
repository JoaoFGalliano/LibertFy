package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.databinding.ActivityNext1Binding

class Next1 : AppCompatActivity() {


    val binding by lazy {

        ActivityNext1Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btAvancar2.setOnClickListener {
            val avancarNext2 = Intent(this, Next2::class.java)
            startActivity(avancarNext2)
        }

    }
}