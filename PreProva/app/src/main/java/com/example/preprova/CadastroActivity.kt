package com.example.preprova

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class CadastroActivity : AppCompatActivity() {



    val listaRestaurante = arrayListOf<Restaurante>()

    val gson = Gson()





    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.cadastro_layout)


        var i: Long = 0;

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtEndereco = findViewById<EditText>(R.id.edt_endereco)
        val edtTipoComida = findViewById<EditText>(R.id.edt_tipo)
        val edtLat = findViewById<EditText>(R.id.edt_lat)
        val edtLongi = findViewById<EditText>(R.id.edt_longi)
        val edtDesc = findViewById<EditText>(R.id.edt_desc)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val btnLista = findViewById<Button>(R.id.btn_lista)

        btnSalvar.setOnClickListener{

            val nome = edtNome.text.toString()
            val endereco = edtEndereco.text.toString()
            val tipoComida = edtTipoComida.text.toString()
            val latitude = edtLat.text.toString().toDouble()
            val longitude = edtLongi.text.toString().toDouble()
            val descricao = edtDesc.text.toString()

            var restaurante = Restaurante(i, nome, endereco, tipoComida,
                                            latitude, longitude, descricao)
            i++;

            listaRestaurante.add(restaurante)

            salvarPrefs(listaRestaurante)





        }

        btnLista.setOnClickListener{

            val intent: Intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

    }

    fun salvarPrefs(array : ArrayList<Restaurante>) {
        val sp = getSharedPreferences("Restaurantes", Context.MODE_PRIVATE)
        var arrayString = gson.toJson(array)
        with (sp.edit()) {
            putString("array", arrayString)
            apply()
        }
    }
}