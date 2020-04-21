package com.example.retrofitmvpdatasourcetask.network;

import com.example.retrofitmvpdatasourcetask.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    private static Retrofit retrofit;

    private static Retrofit getRetrofitObject() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Client getClient() {
        return getRetrofitObject().create(Client.class);
    }
}
