package com.example.preprova

data class Restaurante (var id: Long,
                        var nome: String,
                        var endereco: String,
                        var tipoComida: String,
                        var latitude: Double,
                        var longitude: Double,
                        var descricao: String)