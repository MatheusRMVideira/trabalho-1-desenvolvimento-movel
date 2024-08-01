package com.example.myapplication.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.api.models.Pokemon
import com.example.myapplication.api.models.Species
import com.example.myapplication.ui.theme.PokemonWikiTheme
import com.google.gson.Gson
import java.util.Locale

@Composable
fun DetailView(
    mainViewModel: MainViewModel = viewModel(),
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(mainViewModel.pokemon!!.sprites.frontDefault),
                contentDescription = null,
                modifier = Modifier.size(400.dp),
                alignment = Alignment.Center,
                ContentScale.FillBounds,

                )
        }
        Row {
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(MaterialTheme.colorScheme.tertiary)
            )
        }
        Row {
            Text(text = mainViewModel.pokemon!!.name.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }, fontSize = 65.sp)
        }
        Row {
            Text(text = stringResource(R.string.present_in).format(mainViewModel.pokemon!!.gameIndices.size))
        }
        Row {
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                itemsIndexed(mainViewModel.pokemon!!.stats) { index, stats ->
                    Card(Modifier.padding(5.dp)) {
                        Text(
                            text = stats.stat.name.toString(),
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = stats.baseStat.toString(), modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(), textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth(0.5F)
            ) {
                Text(text = stringResource(R.string.abilities)+ ":", fontWeight = FontWeight.Bold)
                LazyColumn {
                    itemsIndexed(mainViewModel.pokemon!!.abilities) { index, abilities ->
                        Text(text = abilities.ability.name)
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth(0.5F)
            ) {
                Text(text = stringResource(R.string.moves) + ":", fontWeight = FontWeight.Bold)
                LazyColumn {
                    itemsIndexed(mainViewModel.pokemon!!.moves) { index, moves ->
                        Text(text = moves.move.name)
                    }
                }
            }
        }
    }
}

