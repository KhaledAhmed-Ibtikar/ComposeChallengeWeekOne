/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
                    CatList(
                        onCatCardClicked = { cat ->
                            navigateWithParcelableData(Screen.CatDetails.route, KEY_CAT, cat)
                        }
                    )
                }
            )

            composable(
                route = Screen.CatDetails.route,
                content = {
                    getParcelableData<Cat>(KEY_CAT)?.also { cat ->
                        CatDetails(
                            cat = cat,
                            onBackButtonClick = { navController.popBackStack() }
                        )
                    }
                }
            )
        }
    }
}

const val KEY_CAT = "cat"
