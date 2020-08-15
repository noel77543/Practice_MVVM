package com.noel.sung.practice_mvvm.useCase;


import android.content.Context;


import com.noel.sung.practice_mvvm.model.MainModel;
import com.noel.sung.practice_mvvm.repository.DataBaseRepository;
import com.noel.sung.practice_mvvm.repository.MainRepository;
import com.noel.sung.practice_mvvm.utils.connect.ApiCallBack;
import com.noel.sung.practice_mvvm.utils.database.entity.MainModelEntity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainUseCase {

    public void connectToGetMainDataFromServer(ApiCallBack<MainModel> callBack) {
        MainRepository.getInstance().getMainDataFromServer(callBack);
    }

    //-----------

    public MainModelEntity getMainDataFromDatabase(Context context) {
        try {
            return DataBaseRepository.getInstance(context).getMainDataFromDatabase().get(1, TimeUnit.SECONDS);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    //-----------

    public void insertMainDataToDataBase(Context context, MainModel mainModel) {
        DataBaseRepository.getInstance(context).insertMainDataToDatabase(new MainModelEntity(mainModel.getFruit(), mainModel.getSize(), mainModel.getColor(),mainModel.getLastUpdateTime()));
    }
}
