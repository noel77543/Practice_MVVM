package com.noel.sung.practice_mvvm.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainModel {


    /**
     * fruit : Apple
     * size : Large
     * color : Red
     */
    @SerializedName("fruit")
    private String fruit;
    @SerializedName("size")
    private String size;
    @SerializedName("color")
    private String color;

    private String lastUpdateTime;


    public MainModel(String fruit, String size, String color) {
        this.fruit = fruit;
        this.size = size;
        this.color = color;
    }

    public MainModel(String fruit, String size, String color, String lastUpdateTime) {
        this(fruit, size, color);
        this.lastUpdateTime = lastUpdateTime;
    }


    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getFruit() {
        return TextUtils.isEmpty(fruit) ? "" : fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getSize() {
        return TextUtils.isEmpty(size) ? "" : size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return TextUtils.isEmpty(color) ? "" : color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
