package com.example.weatherappapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherappapi.R;
import com.example.weatherappapi.api.ApiClient;
import com.example.weatherappapi.api.ApiInterface;
import com.example.weatherappapi.model.Constants;
import com.example.weatherappapi.model.CurrentWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private TextView txvCity, txvDayOfWeek, txvTemperature, txvWindSpeed, txvHumidity, txvMaxTem, txvMinTem;
    private ImageView imgIcon, imgSearch;
    private EditText edtSearch;
    private LinearLayout layoutToday, layout7Day;
    private Context context;

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        apiInterface = ApiClient.getRetrofitCurrent().create(ApiInterface.class);

        getCurrentWeather();

        layout7Day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FiveDayActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initView() {
        txvCity = findViewById(R.id.txvCity);
        txvDayOfWeek = findViewById(R.id.txvDayOfWeek);
        txvTemperature = findViewById(R.id.txvTemperature);
        txvWindSpeed = findViewById(R.id.txvWindSpeed);
        txvHumidity = findViewById(R.id.txvHumidity);
        txvMaxTem = findViewById(R.id.txvMaxTem);
        txvMinTem = findViewById(R.id.txvMinTem);
        edtSearch = findViewById(R.id.edtSearch);
        imgIcon = findViewById(R.id.imgIcon);
        imgSearch = findViewById(R.id.imgSearch);
        layoutToday = findViewById(R.id.layoutToday);
        layout7Day = findViewById(R.id.layout7Day);
    }

    private void getCurrentWeather() {

        Call<CurrentWeather> callCurrentWeather = apiInterface.getCurrentWeather("vietnam", Constants.API_KEY);
        callCurrentWeather.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (response.isSuccessful()) {

                    txvCity.setText(response.body().getName());
                    //txvDayOfWeek.setText(response.body().getCurrent().getWeatherDescriptions().toString());

                    double tem = response.body().getMain().getTemp() - 273.15;
                    //làm tròn số lấy 1 chữ số sau dấu phẩy
                    double temRound = Math.round(tem*10)/10;

                    double temMax = response.body().getMain().getTempMax() - 273.15;
                    double temMaxRound = Math.round(temMax*10)/10;

                    double temMin = response.body().getMain().getTempMin() - 273.15;
                    double temMinRound = Math.round(temMin*10)/10;

                    txvTemperature.setText(temRound + "°C");
                    txvWindSpeed.setText("Wind: "+response.body().getWind().getSpeed() + " kph");
                    txvHumidity.setText("Humidity: "+response.body().getMain().getHumidity()+ " %");
                    txvMaxTem.setText("Max: " + temMaxRound + "°C");
                    txvMinTem.setText("Min: "+temMinRound+"°C");
                    //Glide.with(context).load(response.body().getCurrent().getWeatherIcons()).into(imgIcon);

                    //Picasso.get().load(response.body().getCurrent().getWeatherIcons()).into(imgIcon);

                }
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

//https://home.openweathermap.org/api_keys
//cd981e9f8b0eaf987d8ea1a75488a09a

//http://api.openweathermap.org/data/2.5/weather?q=korea&appid=cd981e9f8b0eaf987d8ea1a75488a09a