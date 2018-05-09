package com.example.usrgam.ejemplo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*


class CicloVidaActivity : AppCompatActivity() {
    var contador = 0;
    var usuario:UsuarioParcelable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("ciclo-vida", "Ejecuto: On Create")

        usuario = intent.getParcelableExtra("nuevo_usuario")

        val contadorGuardado: Int? = savedInstanceState?.get("contador") as Int?

        val usuarioGuardado = savedInstanceState?.get("usuario") as UsuarioParcelable?

        Log.i("ciclo-vida","El contador es: $contadorGuardado")

        if(contadorGuardado ==null && usuarioGuardado == null){
            textViewContador.text = usuario?.edad.toString()
        } else {
            textViewContador.text = usuarioGuardado?.edad.toString()
            usuario = usuarioGuardado
        }


        botonContador
                .setOnClickListener { view ->
                    usuario?.aumentarAnio(1)
                    textViewContador.text = usuario?.edad.toString()
                }


    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "Ejecuto: On Start")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida", "Ejecuto: On Restart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida", "Ejecuto: On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida", "Ejecuto: On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida", "Ejecuto: On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida", "Ejecuto: On Destroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.i("ciclo-vida", "Ejecuto: On RestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putInt("contador",contador)
        outState?.putParcelable("usuario",usuario)

        Log.i("ciclo-vida", "Ejecuto: On SaveInstanceState")
    }
}
