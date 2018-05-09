package com.example.usrgam.ejemplo

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import java.util.*


class UsuarioParcelable (val nombre:String,
                         val edad: Int,
                         val fechaNacimiento:Date?,
                         val casado:Boolean):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            TODO("fechaNacimiento"),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(edad)
        parcel.writeByte(if (casado) 1 else 0)
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