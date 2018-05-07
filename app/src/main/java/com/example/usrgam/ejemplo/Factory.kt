package com.example.usrgam.ejemplo

class Factory {

    companion object {
        var usuarios: ArrayList<Usuario> = ArrayList()

        init {

            usuarios.add(Usuario("marcelo","nieto","verde"))
            usuarios.add(Usuario("paula","acosta","azul"))
            usuarios.add(Usuario("andres","arcentales","blanco"))


        }
    }

}