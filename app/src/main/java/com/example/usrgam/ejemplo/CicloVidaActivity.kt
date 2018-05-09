package com.example.usrgam.ejemplo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CicloVidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("create", "Se esta creando la actividad")
    }

    override fun onStart() {
        super.onStart()
        Log.i("create", "Se esta starteando la actividad")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.i("create", "Se esta restorando la instancia de la actividad")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.i("create", "Se esta guardando el estado de la instancia de esta actividad")
    }

    override fun onResume() {
        super.onResume()
        Log.i("create", "Resumiendo, iniciando recursos como la camara por ejemplo")
    }

    override fun onPause() {
        super.onPause()
        Log.i("create", "Pausando, momento para liberar la memoria y recursos")
    }


    override fun onStop() {
        super.onStop()
        Log.i("create", "Se esta parando la actividad aqui se debe de liberar todos los recursos de interfaz, tambien es un buen lugar para almacenar informacion no volatil")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("create", "Va a destruirse la vista, adios a todos")
    }

    override fun finish() {
        super.finish()
        Log.i("create", "Finalizando, El usuario dijo que se quiere ir de esta Actividad")
    }
}
