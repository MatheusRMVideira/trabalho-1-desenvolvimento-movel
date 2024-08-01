package com.example.myapplication

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.repository.PokemonRepository
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class PokemonInstrumentedTest {
    private lateinit var repository: PokemonRepository

    @Before
    fun initDb() {
        repository = PokemonRepository(ApplicationProvider.getApplicationContext())
    }
    @Test
    fun test_GetPokemonByName_successfully(): Unit = runBlocking {
        val response = repository.getPokemonByName("Pikachu")
        assertTrue("Pokemon id 25", response.id == 25)
        val response_2 = repository.getPokemonByName("pikachu")
        assertTrue("Pokemon id 25", response_2.id == 25)
    }

    @Test
    fun test_GetPokemonByName_with_wrong_name(): Unit = runBlocking {
        try {
            val response = repository.getPokemonByName("RandomName")
            fail()
        } catch (e: Exception) {
            assertEquals("HTTP 404 ", e.message)
        }
    }
}