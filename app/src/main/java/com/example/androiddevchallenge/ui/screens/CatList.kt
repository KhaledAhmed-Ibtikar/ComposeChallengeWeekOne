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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.entities.Cat
import com.example.androiddevchallenge.ui.components.CatCardItem
import com.example.androiddevchallenge.utils.PullToRefresh

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun CatList(onCatCardClicked: (catItem: Cat) -> Unit) {
    // Using "rememberSaveable", because "remember" doesn't survive navigation
    var list by rememberSaveable { mutableStateOf(CatRepository.generateRandomCatList(15)) }
    // MutableState recomposes any Composable when it's value is changed https://stackoverflow.com/a/66178263/11276817
    var isRefreshing by mutableStateOf(false)
    PullToRefresh(
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            list = CatRepository.generateRandomCatList(15)
        },
        content = {
            LazyColumn(
                content = {
                    stickyHeader {
                        Text(
                            text = stringResource(R.string.cat_list_title),
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp)
                                .background(MaterialTheme.colors.background)
                        )
                    }
                    items(list) { catItem ->
                        CatCardItem(cat = catItem, onCatCardClicked = { onCatCardClicked(it) })
                        isRefreshing = true
                    }
                }
            )
        }
    )
}
