package com.example.preprova

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class ListaActivity : AppCompatActivity() {

    val arraySp = arrayListOf<Restaurante>()

    val gson = Gson()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.lista_layout)

        val lista = findViewById<ListView>(R.id.list_restaurantes)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arraySp)

        lista.adapter = adapter

        adapter.addAll(carregarPrefs())


    }

    fun carregarPrefs(): ArrayList<Restaurante> {
        val sp = getSharedPreferences("Restaurantes", Context.MODE_PRIVATE)

        val restaurantes = sp.getString("array", "[]")

        val listaRestaurantes = gson.fromJson(restaurantes, ArrayList<Restaurante>()::class.java)

        return listaRestaurantes
    }
}