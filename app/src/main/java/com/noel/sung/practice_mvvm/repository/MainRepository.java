package com.noel.sung.practice_mvvm.repository;


import com.noel.sung.practice_mvvm.model.MainModel;
import com.noel.sung.practice_mvvm.utils.connect.ApiCallBack;
import com.noel.sung.practice_mvvm.utils.connect.ApiCenter;
import com.noel.sung.practice_mvvm.utils.connect.ApiCenterBuilder;

public class MainRepository {

    private static MainRepository mainRepository;

    public static MainRepository getInstance() {
        if (mainRepository == null) {
            mainRepository = new MainRepository();
        }
        return mainRepository;
    }

    //--------

    public void getMainDataFromServer(ApiCallBack<MainModel> callBack){
        ApiCenterBuilder.getServiceInterface(ApiCenter.class)
                .getMainData()
                .enqueue(callBack);
    }
}
