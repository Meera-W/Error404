package com.example.atyourservice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private ImageView splash;
    private static int timeout=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash= (ImageView)findViewById(R.id.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this , MainActivity.class);
                startActivity(i);
                finish();
            }
        },timeout);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.splashanim);
        splash.startAnimation(myanim);
    }
}