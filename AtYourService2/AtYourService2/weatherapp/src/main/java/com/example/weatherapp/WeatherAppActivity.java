package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.Retrofit.ApiClient;
import com.example.weatherapp.Retrofit.ApiInterface;
import com.example.weatherapp.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherAppActivity extends AppCompatActivity {

    ImageView search;
    TextView tempText , descText , humidityText, windSpeedText;
    EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempText = findViewById(R.id.tempText);
        descText = findViewById(R.id.descText);

        search = findViewById(R.id.search);
        humidityText = findViewById(R.id.humidityText);
        textField = findViewById(R.id.textField);
        windSpeedText =findViewById(R.id.windSpeedText);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getWeatherData(textField.getText().toString().trim());

            }
        });
    }

    private void getWeatherData(String name){

       ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                tempText.setText("Temp :"+" "+response.body().getMain().getTemp()+" °C");
                descText.setText("Feels Like :"+" "+response.body().getMain().getFeels_like()+" °C");
                humidityText.setText("Humidity :"+" "+response.body().getMain().getHumidity());
                windSpeedText.setText("Wind Speed :"+" "+response.body().getWind().getSpeed()+" m/sec");


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }
}
