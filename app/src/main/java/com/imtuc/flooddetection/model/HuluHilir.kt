package com.imtuc.flooddetection.model

import android.os.Parcel
import android.os.Parcelable

data class HuluHilir(
    var distance: String = "",
    var datetime: String = ""
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(distance)
        parcel.writeString(datetime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HuluHilir> {
        override fun createFromParcel(parcel: Parcel): HuluHilir {
            return HuluHilir(parcel)
        }

        override fun newArray(size: Int): Array<HuluHilir?> {
            return arrayOfNulls(size)
        }
    }
}
