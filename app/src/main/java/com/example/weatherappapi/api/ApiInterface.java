package com.example.weatherappapi.api;

import com.example.weatherappapi.model.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("current")
    Call<CurrentWeather> getCurrentWeather(@Query("access_key") String access_key,
                                           @Query("query") String location);



}

//https://weatherstack.com/

//api key:
//43ec6f4bc9bd52c30de5708b9063f22a

//BASE_URL:
//http://api.weatherstack.com/

//weather current:
//http://api.weatherstack.com/current?access_key=YOUR_ACCESS_KEY&query=New York
//http://api.weatherstack.com/current?access_key=43ec6f4bc9bd52c30de5708b9063f22a&query=vietnam
//http://api.weatherstack.com/current?access_key=43ec6f4bc9bd52c30de5708b9063f22a&query=New York

//historical // toan bi FAILURE thoi
//http://api.weatherstack.com/historical?access_key=43ec6f4bc9bd52c30de5708b9063f22a&query=New York&historical_date=2019-01-01&hourly=1



