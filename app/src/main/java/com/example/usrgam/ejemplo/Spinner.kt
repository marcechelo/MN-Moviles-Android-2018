package com.example.usrgam.ejemplo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_spinner.*

class Spinner : AppCompatActivity() {

//    val arregloUusario = arrayOf(Usuario("marcelo","nieto","verde"),
//            Usuario("paula","acosta","azul"),
//            Usuario("andres","arcentales","blanco"))

    var arregloUusario: ArrayList<Usuario> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        arregloUusario = Factory.usuarios

        val adaterSpinnerItems = ArrayAdapter<Usuario>(this, android.R.layout.simple_spinner_item, arregloUusario)
        adaterSpinnerItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerUsuario.adapter = adaterSpinnerItems

        spinnerUsuario.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                Log.i("spinner", "rp: $id, posicion $position")
                var usuarioSeleccionado = arregloUusario.get(position)

                textViewApellidoGrande.text = usuarioSeleccionado.apellido
                textViewApellido.text = usuarioSeleccionado.apellido
                textViewNombre.text = usuarioSeleccionado.nombre
                textViewColor.text = usuarioSeleccionado.colorFavorito

            }

        }

    }
}
