package com.example.myapplication.api.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "pokemon", indices = @Index(value = {"id"}, unique = true))
public class Pokemon {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @Expose
    private Integer id;

    @SerializedName("abilities")
    @ColumnInfo(name = "abilities")
    @Expose
    private List<Ability> abilities;
    @SerializedName("base_experience")
    @ColumnInfo(name = "base_experience")
    @Expose
    private Integer baseExperience;
    @SerializedName("forms")
    @ColumnInfo(name = "forms")
    @Expose
    private List<Form> forms;
    @SerializedName("game_indices")
    @ColumnInfo(name = "game_indices")
    @Expose
    private List<GameIndex> gameIndices;
    @SerializedName("height")
    @ColumnInfo(name = "height")
    @Expose
    private Integer height;
    @SerializedName("held_items")
    @ColumnInfo(name = "held_items")
    @Expose
    private List<HeldItem> heldItems;
    @SerializedName("is_default")
    @ColumnInfo(name = "is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("location_area_encounters")
    @ColumnInfo(name = "location_area_encounters")
    @Expose
    private String locationAreaEncounters;
    @SerializedName("moves")
    @ColumnInfo(name = "moves")
    @Expose
    private List<Move> moves;
    @SerializedName("name")
    @ColumnInfo(name = "name")
    @Expose
    private String name;
    @SerializedName("order")
    @ColumnInfo(name = "order")
    @Expose
    private Integer order;
    @SerializedName("past_abilities")
    @ColumnInfo(name = "past_abilities")
    @Expose
    private List<Object> pastAbilities;
    @SerializedName("past_types")
    @ColumnInfo(name = "past_types")
    @Expose
    private List<Object> pastTypes;
    @SerializedName("species")
    @ColumnInfo(name = "species")
    @Expose
    private Species species;
    @SerializedName("sprites")
    @ColumnInfo(name = "sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("stats")
    @ColumnInfo(name = "stats")
    @Expose
    private List<Stat> stats;
    @SerializedName("types")
    @ColumnInfo(name = "types")
    @Expose
    private List<Type> types;
    @SerializedName("weight")
    @ColumnInfo(name = "weight")
    @Expose
    private Integer weight;

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<HeldItem> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(List<HeldItem> heldItems) {
        this.heldItems = heldItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Object> getPastAbilities() {
        return pastAbilities;
    }

    public void setPastAbilities(List<Object> pastAbilities) {
        this.pastAbilities = pastAbilities;
    }

    public List<Object> getPastTypes() {
        return pastTypes;
    }

    public void setPastTypes(List<Object> pastTypes) {
        this.pastTypes = pastTypes;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
