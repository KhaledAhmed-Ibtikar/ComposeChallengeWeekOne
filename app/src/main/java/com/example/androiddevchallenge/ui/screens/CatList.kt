package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.entities.Cat
import com.example.androiddevchallenge.ui.components.CatCardItem

@Composable
fun CatList(onCatCardClicked: (catItem: Cat) -> Unit) {
    val list =
        rememberSaveable { CatRepository.generateRandomCatList(15) } // Using rememberSaveable, because remember doesn't survive navigation?
    Column {
        Text(
            text = "Cat adoption list",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        LazyColumn(content = {
            items(list) { catItem ->
                CatCardItem(cat = catItem, onCatCardClicked = { onCatCardClicked(it) })
            }
        })
    }

}
