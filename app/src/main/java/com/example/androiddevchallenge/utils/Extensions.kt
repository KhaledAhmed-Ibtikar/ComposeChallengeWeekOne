package com.example.androiddevchallenge.utils

import android.os.Parcelable
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate


object Extensions {
    fun NavHostController.navigateWithParcelableData(route: String, key: String, data: Parcelable) {
        currentBackStackEntry?.arguments?.putParcelable(key, data)
        navigate(route)
    }

    fun <T : Parcelable> NavHostController.getParcelableData(key: String) = previousBackStackEntry
        ?.arguments?.getParcelable<T>(key)
}