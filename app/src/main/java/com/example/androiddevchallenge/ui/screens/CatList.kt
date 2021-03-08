package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.entities.Cat
import com.example.androiddevchallenge.ui.components.CatCardItem

@Composable
fun CatList(onCatCardClicked : (catItem : Cat) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { stringResource(R.string.top_bar_title) },
                    backgroundColor = Color.White,
                    elevation = 8.dp,
                    modifier = Modifier.padding(all = 5.dp),
                )
            },
            content = {
                val list = CatRepository.generateRandomCatList(15)
                LazyColumn(content = {
                    items(list) { catItem -> CatCardItem(cat = catItem, onCatCardClicked = {
                        onCatCardClicked(it)
                    }) }
                })
            }
        )
    }

}