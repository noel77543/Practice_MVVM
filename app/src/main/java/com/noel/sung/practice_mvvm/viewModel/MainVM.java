package com.noel.sung.practice_mvvm.viewModel;

import android.app.Application;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.google.gson.Gson;
import com.noel.sung.practice_mvvm.model.MainModel;
import com.noel.sung.practice_mvvm.useCase.MainUseCase;
import com.noel.sung.practice_mvvm.utils.connect.ApiCallBack;
import com.noel.sung.practice_mvvm.utils.database.entity.MainModelEntity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainVM extends AndroidViewModel {
    private MainUseCase mainUseCase;
    private MediatorLiveData<MainModel> response;

    public LiveData<MainModel> getResponse() {
        return response;
    }

    public MainVM(@NonNull Application application) {
        super(application);
        mainUseCase = new MainUseCase();
        response = new MediatorLiveData<>();
    }

    //--------------

    public void init() {
        MainModelEntity mainModelEntity = mainUseCase.getMainDataFromDatabase(getApplication());
        if (mainModelEntity != null) {
            response.postValue(new MainModel(mainModelEntity.getFruit(), mainModelEntity.getSize(), mainModelEntity.getColor(),mainModelEntity.getLastUpdateTime()));
        }
    }

    //-----------

    public void connectToGetMainDataFromServer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainUseCase.connectToGetMainDataFromServer(new ApiCallBack<MainModel>() {
                    @Override
                    public void onSuccess(MainModel data) {
                        data.setLastUpdateTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime()));
                        Log.e("取得API資料成功", new Gson().toJson(data));
                        mainUseCase.insertMainDataToDataBase(getApplication(), data);
                        response.postValue(data);
                    }

                    @Override
                    public void onFail(String error) {
                        Log.e("取得API資料失敗", error);
                        response.postValue(new MainModel(error, "", ""));
                    }
                });
                //模擬網路延遲
            }
        }, 10 * 1000);
    }
}
