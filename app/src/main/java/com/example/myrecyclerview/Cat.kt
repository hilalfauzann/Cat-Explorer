package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cat (
    val name: String,
    val description: String,
    val photo: Int

) : Parcelable