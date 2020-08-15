package com.noel.sung.practice_mvvm.utils.database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.noel.sung.practice_mvvm.utils.database.entity.MainModelEntity;


@Dao
public abstract class MainTableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(MainModelEntity mainModelEntity);

    @Query("SELECT * FROM `MainTable`")
    public abstract MainModelEntity getData();

}
