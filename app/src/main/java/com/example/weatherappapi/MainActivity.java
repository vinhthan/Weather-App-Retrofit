package com.example.weatherappapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.weatherappapi.api.ApiClient;
import com.example.weatherappapi.api.ApiInterface;
import com.example.weatherappapi.model.Constants;
import com.example.weatherappapi.model.CurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        apiInterface = ApiClient.getRetrofitCurrent().create(ApiInterface.class);

        getCurrentWeather();


    }

    private void getCurrentWeather() {

        Call<CurrentWeather> callCurrentWeather = apiInterface.getCurrentWeather(Constants.ACCESS_KEY, "vietnam");
        callCurrentWeather.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.body().getLocation().getLocaltime(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {

            }
        });
    }
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

