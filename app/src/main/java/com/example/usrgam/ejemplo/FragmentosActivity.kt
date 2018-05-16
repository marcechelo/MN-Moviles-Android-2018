package com.example.usrgam.ejemplo

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragmentos.*

class FragmentosActivity : AppCompatActivity() {

    lateinit var fragmentoActual: android.support.v4.app.Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragmentoDos = Fragmento2();
        fragmentoActual = Fragmento2()

        fragmentTransaction.add(R.id.rl_Fragments, fragmentoDos)
        fragmentTransaction.commit()


        botonTab1.setOnClickListener { view ->
            val fragmentoUno = FragmentoUno()
            replazarFragmentoActual(fragmentoUno)
        }
        botonTab2.setOnClickListener { view ->
            val fragmentoDos = Fragmento2()
            replazarFragmentoActual(fragmentoDos)
        }
        botonTab3.setOnClickListener { view ->
            val fragmentoTres = FragmentoTres()
            replazarFragmentoActual(fragmentoTres)
        }
        botonDestruir.setOnClickListener { view ->
            destruirGragmentoActual()
        }
    }

    fun replazarFragmentoActual(fragmento: android.support.v4.app.Fragment){

        fragmentoActual = fragmento
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.rl_Fragments, fragmento)
        fragmentTransaction.commit()

    }

    fun destruirGragmentoActual(){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.commit()

    }
}
