package com.example.myapplication.ui.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.api.models.Pokemon
import com.example.myapplication.repository.PokemonRepository
import kotlinx.coroutines.launch

class MainViewModel(private val pokemonRepository: PokemonRepository) :  ViewModel() {
    private var searchText = ""
    public var pokemon by mutableStateOf<Pokemon?>(null)
    public var allPokemon by mutableStateOf<List<Pokemon>?>(null)

    var showNetworkErrorSnackbar by mutableStateOf(false)

    var showNotFound by mutableStateOf(false)

    init {
        searchText = ""
        viewModelScope.launch {
            loadAll()
        }
    }

    suspend fun loadAll(){
        allPokemon = pokemonRepository.getAllPokemons()
    }

    fun search(callback: () -> Unit = {}){
        viewModelScope.launch {
            try {
                pokemon = pokemonRepository.getPokemonByName(searchText)
                if (pokemon != null) {
                    callback()
                } else {
                    showNotFound = true
                }
                loadAll()
            } catch (e: Exception) {
                showNotFound = true
            }
        }
    }

    fun textChange(text: String) {
        searchText = text
    }

    fun dismissNetworkErrorSnackBar() {
        showNetworkErrorSnackbar = false
    }

    fun dismissNotFoundSnackBar() {
        showNotFound = false
    }
}