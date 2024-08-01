package com.example.myapplication.room.models


import androidx.room.TypeConverter
import com.example.myapplication.api.models.Ability
import com.example.myapplication.api.models.Form
import com.example.myapplication.api.models.GameIndex
import com.example.myapplication.api.models.HeldItem
import com.example.myapplication.api.models.Move
import com.example.myapplication.api.models.Species
import com.example.myapplication.api.models.Sprites
import com.example.myapplication.api.models.Stat
import com.example.myapplication.api.models.Type
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromAbility(ability: List<Ability>): String? {
        return if (ability == null) null else Gson().toJson(ability)
    }

    @TypeConverter
    fun toAbility(abilityJson: String?): List<Ability>? {
        return if (abilityJson == null) null else {
            val type = object : TypeToken<List<Ability>>() {}.type
            Gson().fromJson(abilityJson, type)
        }
    }

    @TypeConverter
    fun fromForm(form: List<Form>): String? {
        return if (form == null) null else Gson().toJson(form)
    }

    @TypeConverter
    fun toForm(formJson: String?): List<Form>? {
        return if (formJson == null) null else {
            val type = object : TypeToken<List<Form>>() {}.type
            Gson().fromJson(formJson, type)
        }
    }

    @TypeConverter
    fun fromGameIndex(gameIndex: List<GameIndex>): String? {
        return if (gameIndex == null) null else Gson().toJson(gameIndex)
    }

    @TypeConverter
    fun toGameIndex(gameIndexJson: String?): List<GameIndex>? {
        return if (gameIndexJson == null) null else {
            val type = object : TypeToken<List<GameIndex>>() {}.type
            Gson().fromJson(gameIndexJson, type)
        }
    }

    @TypeConverter
    fun fromHeldItem(heldItem: List<HeldItem>): String? {
        return if (heldItem == null) null else Gson().toJson(heldItem)
    }

    @TypeConverter
    fun toHeldItem(heldItemJson: String?): List<HeldItem>? {
        return if (heldItemJson == null) null else {
            val type = object : TypeToken<List<HeldItem>>() {}.type
            Gson().fromJson(heldItemJson, type)
        }
    }

    @TypeConverter
    fun fromMove(move: List<Move>): String? {
        return if (move == null) null else Gson().toJson(move)
    }

    @TypeConverter
    fun toMove(moveJson: String?): List<Move>? {
        return if (moveJson == null) null else {
            val type = object : TypeToken<List<Move>>() {}.type
            Gson().fromJson(moveJson, type)
        }
    }

    @TypeConverter
    fun fromObject(obj: List<Object>): String? {
        return if (obj == null) null else Gson().toJson(obj)
    }

    @TypeConverter
    fun toObject(objectJson: String?): List<Object>? {
        return if (objectJson == null) null else {
            val type = object : TypeToken<List<Object>>() {}.type
            Gson().fromJson(objectJson, type)
        }
    }

    @TypeConverter
    fun fromStat(stat: List<Stat>): String? {
        return if (stat == null) null else Gson().toJson(stat)
    }

    @TypeConverter
    fun toStat(statJson: String?): List<Stat>? {
        return if (statJson == null) null else {
            val type = object : TypeToken<List<Stat>>() {}.type
            Gson().fromJson(statJson, type)
        }
    }

    @TypeConverter
    fun fromType(type: List<Type>): String? {
        return if (type == null) null else Gson().toJson(type)
    }

    @TypeConverter
    fun toType(typeJson: String?): List<Type>? {
        return if (typeJson == null) null else {
            val type = object : TypeToken<List<Type>>() {}.type
            Gson().fromJson(typeJson, type)
        }
    }

    @TypeConverter
    fun fromSpecies(species: Species): String? {
        return if (species == null) null else Gson().toJson(species)
    }

    @TypeConverter
    fun toSpecies(speciesJson: String?): Species? {
        return if (speciesJson == null) null else Gson().fromJson(speciesJson, Species::class.java)
    }

    @TypeConverter
    fun fromSprites(sprites: Sprites): String? {
        return if (sprites == null) null else Gson().toJson(sprites)
    }

    @TypeConverter
    fun toSprites(spritesJson: String?): Sprites? {
        return if (spritesJson == null) null else Gson().fromJson(spritesJson, Sprites::class.java)
    }
}