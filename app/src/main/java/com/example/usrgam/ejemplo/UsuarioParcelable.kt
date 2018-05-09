package com.example.usrgam.ejemplo

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import java.util.*


class UsuarioParcelable(var nombre: String,
                        var edad: Int,
                        var fechaNacimiento: Date?,
                        var casado: Boolean) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.leerDate(),
            parcel.readByte() != 0.toByte()) {
    }

    fun aumentarAnio(numero:Int){
        edad += numero
    }

    override fun writeToParcel(destino: Parcel?, p1: Int) {
        destino?.writeString(nombre)
        destino?.writeInt(edad)
        destino?.escribirDate(fechaNacimiento)
        destino?.writeByte((if (casado) 1 else 0).toByte())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsuarioParcelable> {
        override fun createFromParcel(parcel: Parcel): UsuarioParcelable {
            return UsuarioParcelable(parcel)
        }

        override fun newArray(size: Int): Array<UsuarioParcelable?> {
            return arrayOfNulls(size)
        }
    }
}


fun Parcel.escribirDate(date: Date?) {
    writeLong(date?.time ?: -1)
}

fun Parcel.leerDate(): Date? {
    val long = readLong()
    return if (long != -1L) Date(long) else null
}