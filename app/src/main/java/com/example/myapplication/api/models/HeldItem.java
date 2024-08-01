package com.example.myapplication.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeldItem {

    @SerializedName("item")
    @Expose
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
