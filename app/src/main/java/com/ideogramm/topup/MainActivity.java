package com.ideogramm.topup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIMEOUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toWelcomeIntent = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(toWelcomeIntent);
                finish();
            }
        },SPLASH_SCREEN_TIMEOUT);
    }
}