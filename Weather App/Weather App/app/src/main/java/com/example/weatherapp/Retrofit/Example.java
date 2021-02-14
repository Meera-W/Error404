package com.example.weatherapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("main")
    private Main main;
    @SerializedName("wind")
    private Wind wind;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {return wind; }
    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
