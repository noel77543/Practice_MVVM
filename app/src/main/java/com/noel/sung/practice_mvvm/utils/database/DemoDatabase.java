package com.noel.sung.practice_mvvm.utils.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.noel.sung.practice_mvvm.utils.database.dao.MainTableDao;
import com.noel.sung.practice_mvvm.utils.database.entity.MainModelEntity;
import com.noel.sung.practice_mvvm.utils.database.implement.DatabaseExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MainModelEntity.class}, version = 1, exportSchema = false)
public abstract class DemoDatabase extends RoomDatabase {
    private static final String DB_NAME = "demoDatabase.db";
    private static DemoDatabase demoDatabase;
    private static final int NUMBER_OF_THREADS = 10;
    private ExecutorService executorServiceRead = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private ExecutorService executorServiceWrite = Executors.newSingleThreadExecutor();


    public static DemoDatabase getInstance(Context context) {
        if (demoDatabase == null) {
            demoDatabase = create(context);
        }

        return demoDatabase;
    }

    //------------

    public ExecutorService getExecutorServiceRead() {
        return executorServiceRead;
    }

    //------------

    public ExecutorService getExecutorServiceWrite() {
        return executorServiceWrite;
    }

    //------------

    public static DemoDatabase create(final Context context) {
        return Room.databaseBuilder(
                context, DemoDatabase.class, DB_NAME)
                .build();
    }

    //------------

    public void executeRead(final DatabaseExecutor databaseExecutor) {
        executorServiceRead.execute(new Runnable() {
            @Override
            public void run() {
                databaseExecutor.execute();
            }
        });
    }

    //------------

    public void executeWrite(final DatabaseExecutor databaseExecutor) {
        executorServiceWrite.execute(new Runnable() {
            @Override
            public void run() {
                databaseExecutor.execute();
            }
        });
    }

    //------------


    @Override
    public void clearAllTables() {

    }

    //--------

    public abstract MainTableDao getMainTableDao();

}
