package com.example.myapplication.ui.compose


import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplication.PokemonApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            MainViewModel(pokemonApplication().container.pokemonRepository)
        }
    }
}

fun CreationExtras.pokemonApplication(): PokemonApplication = (this[AndroidViewModelFactory.APPLICATION_KEY] as PokemonApplication)