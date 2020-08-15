package com.noel.sung.practice_mvvm.repository;


import android.content.Context;

import com.noel.sung.practice_mvvm.utils.database.DemoDatabase;
import com.noel.sung.practice_mvvm.utils.database.dao.MainTableDao;
import com.noel.sung.practice_mvvm.utils.database.entity.MainModelEntity;
import com.noel.sung.practice_mvvm.utils.database.implement.DatabaseExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;


public class DataBaseRepository {

    private static DataBaseRepository dataBaseRepository;
    private DemoDatabase demoDatabase;
    private MainTableDao mainTableDao;

    public static DataBaseRepository getInstance(Context context) {
        if (dataBaseRepository == null) {
            dataBaseRepository = new DataBaseRepository(context);
        }
        return dataBaseRepository;
    }

    //--------

    public DataBaseRepository(Context context) {
        demoDatabase = DemoDatabase.getInstance(context);
        mainTableDao = demoDatabase.getMainTableDao();
    }

    //--------

    public void insertMainDataToDatabase(final MainModelEntity mainModelEntity) {
        demoDatabase.executeWrite(new DatabaseExecutor() {
            @Override
            public void execute() {
                mainTableDao.insert(mainModelEntity);
            }
        });
    }


    //--------

    public Future<MainModelEntity> getMainDataFromDatabase() {
        Callable<MainModelEntity> callable = new Callable<MainModelEntity>() {
            @Override
            public MainModelEntity call() {
                return  mainTableDao.getData();
            }
        };
        return demoDatabase.getExecutorServiceRead().submit(callable);
    }
}
