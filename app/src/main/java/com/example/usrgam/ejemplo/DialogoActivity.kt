package com.example.usrgam.ejemplo

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log

import kotlinx.android.synthetic.main.activity_dialogo.*

class DialogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogo)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val builder = AlertDialog.Builder(this)
            val seleccionUsuario = booleanArrayOf(true,false,false,false)

            //builder.setMessage("¿Está seguro?")
            val listaItems = resources.getStringArray(R.array.string_array_opciones_dialogo)
            builder.setTitle("Escoja un numero")
//            builder.setSingleChoiceItems(listaItems,-1,DialogInterface.OnClickListener { dialog, which ->
//                Log.i("dialogo", "Acepto")
//            })

            builder.setMultiChoiceItems(listaItems,seleccionUsuario,DialogInterface.OnMultiChoiceClickListener {
                dialog: DialogInterface,
                i: Int,
                b -> Log.i("dialogo","escogio algo $i")  }
            )
            //builder.setSingleChoiceItems()
            builder.setPositiveButton(
                    "Aceptar",
                    DialogInterface.OnClickListener { dialog, which ->
                        Log.i("dialogo", "Acepto")
                    }
            )
            builder.setNegativeButton(
                    "Cancelar",
                    null
            )
            val dialogo = builder.create()
            dialogo.show()





            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

}
