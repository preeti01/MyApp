package com.example.preeti.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.preeti.myapp.R;
import com.example.preeti.myapp.Services.ChamberService;

/**
 * Created by preeti on 1/23/2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(ChamberService.isUserLogin()) {
                    Intent in = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(in);
                }else
                {
                    Intent i = new Intent(SplashActivity.this, RegisterActivity.class);
                    startActivity(i);
                }
                finish();
            }
        }, 2000);


    }
}
