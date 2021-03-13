package com.example.androiddevchallenge.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.entities.Cat
import com.example.androiddevchallenge.ui.screens.CatDetails
import com.example.androiddevchallenge.ui.screens.CatList
import com.example.androiddevchallenge.utils.Extensions.getParcelableData
import com.example.androiddevchallenge.utils.Extensions.navigateWithParcelableData

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun NavigationGraph(startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {

        with(navController) {
            composable(
                route = Screen.CatList.route,
                content = {
                    CatList( onCatCardClicked = { cat ->
                        navigateWithParcelableData(Screen.CatDetails.route, KEY_CAT, cat)
                    })
                })

            composable(
                route = Screen.CatDetails.route,
                content = {
                    getParcelableData<Cat>(KEY_CAT)?.also { cat ->
                        CatDetails(
                            cat = cat,
                            onBackButtonClick = { navController.popBackStack() })
                    }
                })
        }
    }
}

const val KEY_CAT = "cat"