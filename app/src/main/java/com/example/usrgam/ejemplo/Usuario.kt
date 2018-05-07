package com.example.usrgam.ejemplo

class Usuario (val nombre:String,
               val apellido:String,
               val colorFavorito:String) {

    override fun toString():String{
        return "Nombre: $nombre, apellido: $apellido"
    }

}