package com.sptech.libertfy.api.model

data class Restaurante(
    val id: Int,

    val nome: String,

    val endereco: String,

    val telefone: String,

    val cnpj: String,

    val categoriaPreco: Int,

    val especialidade: String,
)
