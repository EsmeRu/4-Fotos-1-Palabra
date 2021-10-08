package com.movil.application //comentario pa ver si ya jala git

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var btnBorrar : Button

    lateinit var btnLetra1 : Button
    lateinit var btnLetra2 : Button
    lateinit var btnLetra3 : Button
    lateinit var btnLetra4 : Button
    lateinit var btnLetra5 : Button
    lateinit var btnLetra6 : Button

    lateinit var btnTecla1 : Button
    lateinit var btnTecla2 : Button
    lateinit var btnTecla3 : Button
    lateinit var btnTecla4 : Button
    lateinit var btnTecla5 : Button
    lateinit var btnTecla6 : Button
    lateinit var btnTecla7 : Button
    lateinit var btnTecla8 : Button
    lateinit var btnTecla9 : Button
    lateinit var btnTecla10 : Button
    lateinit var btnTecla11 : Button
    lateinit var btnTecla12 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBorrar = findViewById(R.id.buttonBorrar)

        btnLetra1 = findViewById(R.id.buttonLetra1)
        btnLetra2 = findViewById(R.id.buttonLetra2)
        btnLetra3 = findViewById(R.id.buttonLetra3)
        btnLetra4 = findViewById(R.id.buttonLetra4)
        btnLetra5 = findViewById(R.id.buttonLetra5)
        btnLetra6 = findViewById(R.id.buttonLetra6)

        btnTecla1 = findViewById(R.id.buttonTecla1)
        btnTecla2 = findViewById(R.id.buttonTecla2)
        btnTecla3 = findViewById(R.id.buttonTecla3)
        btnTecla4 = findViewById(R.id.buttonTecla4)
        btnTecla5 = findViewById(R.id.buttonTecla5)
        btnTecla6 = findViewById(R.id.buttonTecla6)
        btnTecla7 = findViewById(R.id.buttonTecla7)
        btnTecla8 = findViewById(R.id.buttonTecla8)
        btnTecla9 = findViewById(R.id.buttonTecla9)
        btnTecla10 = findViewById(R.id.buttonTecla10)
        btnTecla11 = findViewById(R.id.buttonTecla11)
        btnTecla12 = findViewById(R.id.buttonTecla12)

        btnBorrar!!.setOnClickListener {
            btnLetra1!!.setText("")
            btnLetra2!!.setText("")
            btnLetra3!!.setText("")
            btnLetra4!!.setText("")
            btnLetra5!!.setText("")
            btnLetra6!!.setText("")

            btnTecla1!!.isEnabled = true
            btnTecla2!!.isEnabled = true
            btnTecla3!!.isEnabled = true
            btnTecla4!!.isEnabled = true
            btnTecla5!!.isEnabled = true
            btnTecla6!!.isEnabled = true
            btnTecla7!!.isEnabled = true
            btnTecla8!!.isEnabled = true
            btnTecla9!!.isEnabled = true
            btnTecla10!!.isEnabled = true
            btnTecla11!!.isEnabled = true
            btnTecla12!!.isEnabled = true
        }

        btnBorrar!!.performClick()

        /*btnTecla1!!.setOnClickListener {
            print(btnLetra1.text)

        }

        fun checarBoton(view: View)
        {
            view.getTag()
        }*/
    }
}