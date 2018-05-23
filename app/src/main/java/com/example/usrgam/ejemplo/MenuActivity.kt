package com.example.usrgam.ejemplo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu

import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val popup = PopupMenu(this,view)
            popup.setOnMenuItemClickListener(this)
            val inflar = popup.menuInflater
            inflar.inflate(R.menu.pop_up_menu,popup.menu)
            popup.show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.item_menu_pokemon -> {
                Log.i("menu", "Menu pokemon")
                return true
            }
            R.id.item_menu_settings -> {
                Log.i("menu", "Menu settings")
                return true
            }
            R.id.item_menu_nuevo1 -> {
                Log.i("menu", "Menu nuevo")
                return true
            }
            R.id.item_menu_aceptar-> {
                Log.i("menu", "Menu aceptar")
                return true
            }
            R.id.item_menu_cancelar -> {
                Log.i("menu", "Menu cancelar")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onMenuItemClick(item:MenuItem):Boolean{
        when (item.getItemId()) {
            R.id.item_menu_aceptar-> {
                Log.i("menu", "Menu aceptar")
                return true
            }
            R.id.item_menu_cancelar -> {
                Log.i("menu", "Menu cancelar")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
