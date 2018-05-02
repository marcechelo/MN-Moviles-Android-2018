package com.example.usrgam.ejemplo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actividad_dos.*

class ActividadDos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)

        val nombre = intent.getStringExtra("nombre")
        textView.text = nombre


        button_dos.setOnClickListener { view ->
            irAActividadTres()
        }

        botonEnviarCorreo.setOnClickListener { view ->
            enviarCorreo()
        }

    }

    fun irAActividadTres() {
        val intent = Intent(this, ActividadTres::class.java)
        startActivity(intent)
    }

    fun enviarCorreo(){
        val addressees = arrayOf("direccion@unocom", "direccion@dos.com")
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/html"
        intent.putExtra(Intent.EXTRA_EMAIL, addressees)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Sujeto")
        intent.putExtra(Intent.EXTRA_TEXT, "Texto.")
        startActivity(intent)
    }
}
