package com.movil.application

import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private var respuesta = ""
    private var nivelActual = 0
    private lateinit var dataNiveles: Niveles
    private var gson = Gson()
    private lateinit var btnPresionado: Button
    private lateinit var btnBorrar: Button
    private lateinit var btnSiguienteLetraRespuesta: Button
    private var imgUpLeft: ImageView? = null
    private var imgUpRigth: ImageView? = null
    private var imgDownLeft: ImageView? = null
    private var imgDownRigth: ImageView? = null
    private var btnPresionados: ArrayList<Button> = ArrayList()
    private var btnRespuestas: ArrayList<Button> = ArrayList()

    //TODO: Obtener el nivel y las imagenes en funcion del nivel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val json = loadData("Niveles.json")
        imgUpLeft = findViewById(R.id.image1)
        imgUpRigth = findViewById(R.id.image2)
        imgDownLeft = findViewById(R.id.image3)
        imgDownRigth = findViewById(R.id.image4)
        btnBorrar = findViewById(R.id.buttonBorrar)

        dataNiveles = gson.fromJson(json, Niveles::class.java)
        Log.d("DATA", dataNiveles.niveles[nivelActual].respuesta)


        btnBorrar.setOnClickListener {
            borrarRespuesta()
        }
    }

    fun buttonPressed(view: View) {
        btnPresionado = findViewById(view.id)
        when (contador){
            0 -> btnSiguienteLetraRespuesta = findViewById(R.id.btnRespuesta1)
            1 -> btnSiguienteLetraRespuesta = findViewById(R.id.btnRespuesta2)
            2 -> btnSiguienteLetraRespuesta = findViewById(R.id.btnRespuesta3)
            3 -> btnSiguienteLetraRespuesta = findViewById(R.id.btnRespuesta4)
            4 -> btnSiguienteLetraRespuesta = findViewById(R.id.btnRespuesta5)
            5 -> btnSiguienteLetraRespuesta = findViewById(R.id.btnRespuesta6)
            else -> {
                Log.d("BTN", "NO HAY BOTON")
            }
        }

        btnSiguienteLetraRespuesta.text = btnPresionado.text
        btnRespuestas.add(btnSiguienteLetraRespuesta)
        btnPresionado.visibility = View.INVISIBLE
        btnPresionados.add(btnPresionado)

        respuesta += btnPresionado.text
        contador++

        if(respuesta == dataNiveles.niveles[nivelActual].respuesta){
            ganar()
        } else if (contador == 6) {
            borrarRespuesta()
        }
    }

    fun borrarRespuesta() {
        for (botones in btnPresionados){
            botones.visibility = View.VISIBLE
        }

        for(botones in btnRespuestas) {
            botones.text = ""
        }

        respuesta = ""
        contador = 0
    }

    fun ganar() {
        val json = loadData("Niveles.json")
        dataNiveles = gson.fromJson(json, Niveles::class.java)
        AlertDialog.Builder(this)
            .setTitle("Ganador")
            .setMessage("Has encontrado la palabra correcta")
            .setPositiveButton(android.R.string.yes, DialogInterface.OnClickListener { dialog, which ->
                //TODO: Implementar el cambio de niveles
                nivelActual+=1;

                imgUpLeft?.setImageURI(Uri.parse("android.resource://com.movil.application/drawable/" + (dataNiveles.niveles[nivelActual].imagen1)))
                imgUpRigth?.setImageURI(Uri.parse("android.resource://com.movil.application/drawable/" + (dataNiveles.niveles[nivelActual].imagen2)))
                imgDownLeft?.setImageURI(Uri.parse("android.resource://com.movil.application/drawable/" + (dataNiveles.niveles[nivelActual].imagen3)))
                imgDownRigth?.setImageURI(Uri.parse("android.resource://com.movil.application/drawable/" + (dataNiveles.niveles[nivelActual].imagen4)))

            })
            .show()
    }

    private fun loadData(inFile: String): String {
        var tContent = ""

        try{
            val stream = assets.open(inFile)

            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            tContent = String(buffer)
        } catch (e: IOException){
            Log.d("JSON", "No se encontro el json")
            AlertDialog.Builder(this)
                .setTitle("Error en JSON")
                .setMessage("No se ha encontrado la data")
                .show()
        }

        return tContent
    }
}