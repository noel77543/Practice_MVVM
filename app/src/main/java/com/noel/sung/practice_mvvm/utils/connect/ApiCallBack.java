package com.noel.sung.practice_mvvm.utils.connect;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class ApiCallBack<T> implements Callback<T> {


    private boolean isRetried = false;

    public ApiCallBack() {

    }

    //-------------

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T data = response.body();
        if(data != null){
            onSuccess(data);
        }else {
            onFail(response.message()+"");
        }
    }

    //-------------

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (!isRetried) {
            call.clone().enqueue(this);
        } else {
            onFail(t.getMessage());
        }
        isRetried = true;
    }


    //-------------

    /***
     * 處理後的成功結果
     */
    public abstract void onSuccess(T data);

    //------------

    /***
     * 處理後的失敗結果
     */
    public abstract void onFail(String error);
}
