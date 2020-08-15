package com.noel.sung.practice_mvvm.utils.database.entity;

import android.text.TextUtils;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "MainTable")
public class MainModelEntity {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "fruit")
    private String fruit;

    @ColumnInfo(name = "size")
    private String size;

    @ColumnInfo(name = "color")
    private String color;

    @ColumnInfo(name = "lastUpdateTime")
    private String lastUpdateTime;

    public MainModelEntity(String fruit, String size, String color, String lastUpdateTime) {
        this.fruit = fruit;
        this.size = size;
        this.color = color;
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
