package com.sptech.libertfy.api.model

data class Usuario(
    val id: Int,

    val nome: String,

    val genero: String,

    val dataNascimento: String,

    val email: String,

    val senha: String,
)
