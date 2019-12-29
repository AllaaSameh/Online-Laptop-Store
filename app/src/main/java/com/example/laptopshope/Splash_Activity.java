package com.example.laptopshope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {

                Intent go = new Intent(Splash_Activity.this, LoginActivity.class);
                startActivity(go);

            }
        };
        handler.postDelayed(run,3000);
    }
}
