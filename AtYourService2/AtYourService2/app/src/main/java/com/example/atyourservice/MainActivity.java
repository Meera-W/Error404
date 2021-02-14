package com.example.atyourservice;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.weatherapp.WeatherAppActivity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
     Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.logo);

        button1 = findViewById(R.id.weather);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openweather();
            }
        });
    }
        public void openweather() {
            Intent intent = new Intent(this, WeatherAppActivity.class);
            startActivity(intent);

    }
}
