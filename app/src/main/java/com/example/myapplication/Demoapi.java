package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Demoapi {
    private static final String url="http://192.168.29.233:8007/api/interview/";

    public static Api apiservice=null;
    public static Api getApi(){
        if (apiservice==null){
            Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            apiservice=retrofit.create(Demoapi.Api.class);
        }
        return apiservice;
    }

    public interface Api{
        @GET("test")
        Call<Datamodel> getdetails();
    }
}
