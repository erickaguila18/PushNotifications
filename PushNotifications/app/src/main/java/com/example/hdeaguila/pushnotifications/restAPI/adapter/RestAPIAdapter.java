package com.example.hdeaguila.pushnotifications.restAPI.adapter;

import com.example.hdeaguila.pushnotifications.restAPI.ConstantesRestAPI;
import com.example.hdeaguila.pushnotifications.restAPI.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hd.eaguila on 25/07/2016.
 */
public class RestAPIAdapter {
    public Endpoints establecerConexion(){
        System.out.print("Adapter");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Endpoints.class);
    }
}
