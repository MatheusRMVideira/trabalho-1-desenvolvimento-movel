package com.example.myapplication.room

import android.content.Context
import android.os.AsyncTask
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.api.models.Pokemon
import com.example.myapplication.room.models.Converter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Pokemon::class], version = 5)
@TypeConverters(Converter::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao;


    companion object {
        private const val DATABASE_NAME = "Poke"

        @Volatile
        private var INSTANCE: PokemonDatabase? = null

        fun getInstance(context: Context): PokemonDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    PokemonDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build()
                    .also { INSTANCE = it }

            }
        }

        private val callback = object : RoomDatabase.Callback() {
            override fun onOpen(@NonNull db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    CoroutineScope(Dispatchers.IO).launch {
                        populateDatabase(database.pokemonDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(pokemonDao: PokemonDao) {
            pokemonDao.deleteAll()
        }
    }
}