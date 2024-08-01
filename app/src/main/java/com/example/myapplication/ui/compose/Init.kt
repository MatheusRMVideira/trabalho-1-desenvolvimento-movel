package com.example.myapplication.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import java.util.Locale

@Composable
fun Init(
    mainViewModel: MainViewModel = viewModel(),
    onSearchPokemonClicked: () -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Text(
                text = stringResource(R.string.menu_title),
                fontSize = 55.sp,
                lineHeight = 70.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 30.dp, bottom = 30.dp)
            )
        }
        Row(
            modifier = Modifier.padding(5.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(stringResource(R.string.type_here)) },
                modifier = Modifier.padding(top = 30.dp, bottom = 30.dp)
            )
        }
        if (mainViewModel.showNotFound) {
            Row(modifier = Modifier.padding(5.dp)) {
                Text(stringResource(R.string.pokemon_not_found))
            }
        }
        Row(
            modifier = Modifier.padding(5.dp)
        ) {
            Button(
                onClick = {
                    mainViewModel.showNotFound = false
                    mainViewModel.textChange(text = text)
                    mainViewModel.search { onSearchPokemonClicked() }
                },

                ) {
                Text(text = stringResource(R.string.button_search))
            }
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.history) + ":",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(5.dp).fillMaxWidth()
            )
        }
        Row {
            LazyColumn {
                itemsIndexed(mainViewModel.allPokemon ?: emptyList()) { index, pokemon ->
                    Card(onClick = {
                        mainViewModel.textChange(text = pokemon.name)
                        mainViewModel.search { onSearchPokemonClicked() }
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = pokemon.name.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.getDefault()
                                ) else it.toString()
                            }, modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

}