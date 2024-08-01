package com.example.myapplication

import android.app.Application
import com.example.myapplication.repository.PokemonRepository

class PokemonApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}

class AppContainer(private val context: Application) {
    val pokemonRepository: PokemonRepository by lazy {
        PokemonRepository(context)
    }
}