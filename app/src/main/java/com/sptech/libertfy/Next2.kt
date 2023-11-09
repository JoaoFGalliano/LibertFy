package com.sptech.libertfy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sptech.libertfy.databinding.ActivityNext1Binding
import com.sptech.libertfy.databinding.ActivityNext2Binding

class Next2 : AppCompatActivity() {

    val binding by lazy {

        ActivityNext2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btAvancar3.setOnClickListener {
            val avancarNext3 = Intent(this, Next3::class.java)
            startActivity(avancarNext3)
        }
    }
}