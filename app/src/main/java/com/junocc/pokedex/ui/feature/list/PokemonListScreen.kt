package com.junocc.pokedex.ui.feature.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.junocc.pokedex.R

@Composable
fun PokemonListScreen() {
    Column {
        Text(
            modifier = Modifier
                .padding(top = 12.dp, start = 12.dp),
            fontSize = 40.sp,
            text = stringResource(R.string.pokemon_list_title),
            color = Color.White
        )
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(10) { index ->
                PokemonItem(index)
            }
        }
    }
}

@Composable
fun PokemonItem(index: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(120.dp),
                painter = painterResource(id = R.drawable.bolva),
                contentDescription = "Imagen $index",
                contentScale = ContentScale.FillWidth
            )
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "Balbasu"
            )
        }
    }
}


@Preview
@Composable
fun PokemonListScreenPreview() {
    PokemonListScreen()
}