package com.example.androiddevchallenge.ui


sealed class Screen(val route : String) {
    object CatList : Screen("cat/list")
    object CatDetails : Screen("cat/details")
}