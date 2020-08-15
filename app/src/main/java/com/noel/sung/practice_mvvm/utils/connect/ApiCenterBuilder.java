package com.noel.sung.practice_mvvm.utils.connect;


import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiCenterBuilder {

    private final static String DOMAIN = "https://support.oneskyapp.com";
    private final static int TIME_OUT = 15;
    private static Retrofit retrofit;

    public static <S> S getServiceInterface(Class<S> serviceInterface) {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(DOMAIN)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                            .setPrettyPrinting()
                            .setLenient()
                            .serializeNulls()
                            .create()))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofit.create(serviceInterface);
    }
}
