package com.example.weatherappapi.api;

import com.example.weatherappapi.model.CurrentWeather;
import com.example.weatherappapi.model.ForeCastFiveDay;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather")
    Call<CurrentWeather> getCurrentWeather(@Query("q") String country,
                                           @Query("appid") String api_key);


    @GET("forecast")
    Call<ForeCastFiveDay> getForeCastFiveDay(@Query("q") String country, @Query("appid") String api_key);

}
//curent
//http://api.openweathermap.org/data/2.5/weather?q=korea&appid=cd981e9f8b0eaf987d8ea1a75488a09a


//forecast 5 ngày
//http://api.openweathermap.org/data/2.5/forecast?q=korea&mode=xml&appid=cd981e9f8b0eaf987d8ea1a75488a09a
//http://api.openweathermap.org/data/2.5/forecast?q=korea&appid=cd981e9f8b0eaf987d8ea1a75488a09a// bỏ kiểu xml đi