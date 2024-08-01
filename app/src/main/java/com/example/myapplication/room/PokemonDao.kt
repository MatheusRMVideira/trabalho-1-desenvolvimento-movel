package com.example.myapplication.room


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.api.models.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
public interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: Pokemon);

    @Query("SELECT DISTINCT * FROM pokemon")
    suspend fun getPokemons(): List<Pokemon>;

    @Query("SELECT DISTINCT * FROM pokemon WHERE name = :search")
    suspend fun getPokemonByName(search: String): Pokemon?

    @Query("DELETE FROM pokemon")
    suspend fun deleteAll();
}