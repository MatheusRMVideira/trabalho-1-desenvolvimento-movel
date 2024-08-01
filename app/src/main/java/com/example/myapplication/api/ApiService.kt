package com.example.myapplication.api

import com.example.myapplication.api.models.Pokemon
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") pokemonName: String): Pokemon
}