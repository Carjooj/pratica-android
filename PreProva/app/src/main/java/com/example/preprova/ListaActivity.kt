package com.example.preprova

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListaActivity : AppCompatActivity() {

    val arraySp = arrayListOf<Restaurante>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.lista_layout)

        val lista = findViewById<ListView>(R.id.list_restaurantes)



    }
}