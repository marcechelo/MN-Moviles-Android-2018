package com.example.usrgam.ejemplo

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val permisoDeCamara = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)

        Log.i("tag", "Crear permiso ${permisoDeCamara}")
        if (permisoDeCamara != PackageManager.PERMISSION_GRANTED) {
            Log.i("tag", "Entrando a pedir permiso")
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), RESULTADO_PERMISO_CAMARA)
        } else {
            Log.i("tag", "Ya tiene este permiso")
        }
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        // nuestro codigo

        button_navegar_activida_dos.setOnClickListener { view: View -> irAActividadDos()}

        spinner.setOnClickListener { view: View -> irAActividadSpinner()}

        botonCrearUusario.setOnClickListener { view: View -> irAActividadUsario()}


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun irAActividadDos() {
        val intent = Intent(this, ActividadDos::class.java)
        intent.putExtra("nombre", "ronnie")
        startActivity(intent)

    }

    fun irAActividadSpinner() {
        val intent = Intent(this, Spinner::class.java)
        startActivity(intent)

    }

    fun irAActividadUsario() {
        val intent = Intent(this, CrearUsuarioActivity::class.java)
        startActivity(intent)

    }

    companion object {
        val RESULTADO_PERMISO_CAMARA = 1;
    }

    /*override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode){
            RESULTADO_PERMISO_CAMARA ->
        }
    }*/
}













