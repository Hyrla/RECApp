package com.radioesieaclub.recapp.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    public static final String BASE_URL = "http://radioesieaclub.com/api/";

    public static RestRECApi getInstance(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestRECApi restRECApi = retrofit.create(RestRECApi.class);
        return restRECApi;
    }
}
