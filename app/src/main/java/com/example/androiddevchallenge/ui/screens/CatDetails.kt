package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.entities.Cat


@Composable
fun CatDetails(cat: Cat) {
    Row {
        Text(text = stringResource(id = cat.summary))
    }
}

@Preview
@Composable
fun CatDetailsPreview() {
    CatDetails(CatRepository.generateRandomCatList(1).first())
}