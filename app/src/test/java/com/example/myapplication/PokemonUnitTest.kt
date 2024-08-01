package com.example.myapplication

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.api.ApiClient
import com.example.myapplication.repository.PokemonRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import retrofit2.await

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PokemonUnitTest {

    private val api = ApiClient.apiService

    @Test
    fun test_GetPokemonByName_successfully(): Unit = runBlocking {
        val response = api.getPokemonByName("pikachu").await()
        assertTrue("Pokemon id 25", response.id == 25)
    }

    @Test
    fun `test GetPokemonByName with wrong name`(): Unit = runBlocking {
        try {
            val response = api.getPokemonByName("randomName").await()
            fail()
        } catch (e: Exception) {
            assertEquals("HTTP 404 ", e.message)
        }
    }

}