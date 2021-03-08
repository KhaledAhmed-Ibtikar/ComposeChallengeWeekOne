package com.example.androiddevchallenge.entities

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cat(
    @DrawableRes val image: Int,
    val name: String,
    val age: Int,
    val gender: String,
    val location: String,
    @StringRes val summary: Int,
) : Parcelable {

}