package com.imtuc.flooddetection.model

import android.os.Parcel
import android.os.Parcelable

class Suhu(
    var celcius: String = "",
    var fahrenheit: String = "",
    var datetime: String = ""
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(celcius)
        parcel.writeString(fahrenheit)
        parcel.writeString(datetime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Suhu> {
        override fun createFromParcel(parcel: Parcel): Suhu {
            return Suhu(parcel)
        }

        override fun newArray(size: Int): Array<Suhu?> {
            return arrayOfNulls(size)
        }
    }
}