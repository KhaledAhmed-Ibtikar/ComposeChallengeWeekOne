package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.CatRepository
import com.example.androiddevchallenge.entities.Cat


@Composable
fun CatDetails(cat: Cat, onBackButtonClick : () -> Unit) {
    Column(
        Modifier
            .background(color = MaterialTheme.colors.onPrimary)
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()) // Behaves like ScrollView
    ) {
        Image(
            painter = painterResource(cat.image), modifier = Modifier.fillMaxWidth(),
            contentDescription = "Cat image",
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = cat.name,
            Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_pin),
                contentDescription = cat.location,
                modifier = Modifier.padding(end = 8.dp),
                tint = Color.Red
            )
            Text(
                text = cat.location,
                Modifier.weight(1.0f)
            )
            Text(
                text = "Age: ${cat.age}",
                Modifier.weight(1.0f),
            textAlign = TextAlign.Center)
        }
        Text(text = "Summary:- ", modifier = Modifier.padding(start = 8.dp, top = 16.dp), style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Bold)
        Text(
            text = stringResource(id = cat.summary), modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            style = MaterialTheme.typography.body1
        )
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(modifier = Modifier
                .padding(20.dp)
                .clip(RoundedCornerShape(8.dp))
                , onClick = { onBackButtonClick() }) {
                Text(text = "Go back")
            }
        }
    }
}

@Preview
@Composable
fun CatDetailsPreview() {
    CatDetails(CatRepository.generateRandomCatList(1).first(), onBackButtonClick = {})
}