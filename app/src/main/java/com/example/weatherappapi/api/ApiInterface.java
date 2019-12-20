package com.example.weatherappapi.api;

import com.example.weatherappapi.model.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather")
    Call<CurrentWeather> getCurrentWeather(@Query("q") String country,
                                           @Query("appid") String api_key);

}
//http://api.openweathermap.org/data/2.5/weather?q=korea&appid=cd981e9f8b0eaf987d8ea1a75488a09a



