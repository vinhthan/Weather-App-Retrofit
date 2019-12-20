package com.example.weatherappapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.weatherappapi.R;
import com.example.weatherappapi.adapter.FiveDayAdapter;
import com.example.weatherappapi.api.ApiClient;
import com.example.weatherappapi.api.ApiInterface;
import com.example.weatherappapi.model.Constants;
import com.example.weatherappapi.model.ForeCastFiveDay;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FiveDayActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ForeCastFiveDay.List> mList;

    private FiveDayAdapter mAdapter;

    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_day);


        apiInterface = ApiClient.getRetrofitForeCast().create(ApiInterface.class);

        getForeCastFiveDay();

    }



    private void getForeCastFiveDay() {
        recyclerView = findViewById(R.id.recyclerView);
        mList = new ArrayList<>();
        mAdapter = new FiveDayAdapter(mList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);


        Call<ForeCastFiveDay> callForecastFiveDay = apiInterface.getForeCastFiveDay("vietnam", Constants.API_KEY);
        callForecastFiveDay.enqueue(new Callback<ForeCastFiveDay>() {
            @Override
            public void onResponse(Call<ForeCastFiveDay> call, Response<ForeCastFiveDay> response) {
                if (response.isSuccessful()){
                    //add list
                    mList.addAll(response.body().getList());

                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ForeCastFiveDay> call, Throwable t) {

            }
        });
    }


}
