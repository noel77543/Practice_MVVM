package com.noel.sung.practice_mvvm.utils.connect;





import com.noel.sung.practice_mvvm.model.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCenter {


    @GET("/hc/en-us/article_attachments/202761627/example_1.json")
    Call<MainModel> getMainData();
}
