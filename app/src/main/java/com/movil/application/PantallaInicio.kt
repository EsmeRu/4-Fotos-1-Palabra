package com.movil.application

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class PantallaInicio : AppCompatActivity() {

    private lateinit var btnJugar:Button
    private lateinit var btnInstrucciones:Button
    private lateinit var btnSalir:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicio)

        btnJugar = findViewById(R.id.btnJugar)
        btnJugar.setOnClickListener {
            cambiarPantalla()
        }

        btnInstrucciones = findViewById(R.id.btnInstrucciones)
        btnInstrucciones.setOnClickListener {
            mostrarInstrucciones()
        }

        btnSalir = findViewById(R.id.btnSalir)
        btnSalir.setOnClickListener{
            finish()
        }
    }

    fun cambiarPantalla() {
        val intent:Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun mostrarInstrucciones() {
        AlertDialog.Builder(this)
            .setTitle("Como Jugar")
            .setMessage("1. Aparecerán 4 imagenes, todas ellas tienen una palbra en común \n\n" +
                        "2. Toque las letras para contruir la palabra correcta \n\n" +
                        "3. Si se equivoca en alguna letra al contruir la palabra correcta toque el boton rojo para borrar su seleccion de letras")
            .show()
    }
}