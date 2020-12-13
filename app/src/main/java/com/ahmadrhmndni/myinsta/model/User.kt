package com.ahmadrhmndni.myinsta.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val name: String,
    val harga: String,
    val deskripsi : String
        ) : Parcelable