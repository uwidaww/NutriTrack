package com.example.tubes

import android.os.Parcel
import android.os.Parcelable

data class dataClassRv(var dataImage:Int, var dataTitle:String,var dataKalori:String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataKalori)
//        parcel.writeString(dataDesc)
//        parcel.writeInt(dataDetailImage)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<dataClassRv> {
        override fun createFromParcel(parcel: Parcel): dataClassRv {
            return dataClassRv(parcel)
        }
        override fun newArray(size: Int): Array<dataClassRv?> {
            return arrayOfNulls(size)
        }
    }
}

