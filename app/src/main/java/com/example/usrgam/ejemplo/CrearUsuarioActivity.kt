package com.example.usrgam.ejemplo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_usuario.*
import kotlinx.android.synthetic.main.content_main.*

class CrearUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        botonCrearUusario.setOnClickListener{view: View -> crearUsuario()}

    }

    fun crearUsuario(){

        val nombre = editTextNombre.text.toString()
        val apellido = editTextApellido.text.toString()
        val color = editTextColor.text.toString()
        Factory.usuarios.add(Usuario(nombre,apellido,color))
        irAActividadSpinner()

    }

    fun irAActividadSpinner() {
        val intent = Intent(this, Spinner::class.java)
        startActivity(intent)

    }
}
