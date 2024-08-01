package com.example.myapplication.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.myapplication.api.ApiClient
import com.example.myapplication.api.models.Pokemon
import com.example.myapplication.room.PokemonDatabase
import com.example.myapplication.room.PokemonDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import retrofit2.await

class PokemonRepository(application: Application) {
    private val pokemonDao:PokemonDao
    private var database: PokemonDatabase
    private val api = ApiClient.apiService

    init {
        database = PokemonDatabase.getInstance(application)
        pokemonDao = database.pokemonDao()
    }

    fun insert(pokemon: Pokemon){
        CoroutineScope(Dispatchers.IO).launch {
            pokemonDao.insert(pokemon)
        }
    }

    suspend fun getAllPokemons(): List<Pokemon> {
        return pokemonDao.getPokemons()
    }

    suspend fun getPokemonByName(pokemonName: String): Pokemon {
        var pokemon = pokemonDao.getPokemonByName(pokemonName.lowercase())
        if (pokemon == null){
            pokemon = api.getPokemonByName(pokemonName.lowercase())
            pokemonDao.insert(pokemon)
        }
        return pokemon
    }
}