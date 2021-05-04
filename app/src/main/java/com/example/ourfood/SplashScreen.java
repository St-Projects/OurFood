package com.example.ourfood;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    ProgressBar progressBar;

    private boolean backbtnpress;
    private static final int SPLASH_DURATION = 3000;
    private Handler myhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        progressBar = (ProgressBar)findViewById(R.id.Progresbar);

        myhandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                finish();

                if(!backbtnpress){

                    Intent manda = getIntent();
                    String nome = manda.getStringExtra("nome");

                    Intent it = new Intent(SplashScreen.this, Escolha.class);
                    it.putExtra("nome2", nome);
                    SplashScreen.this.startActivity(it);
                }
            }
        }, SPLASH_DURATION);

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        backbtnpress = true;
        super.onBackPressed();
    }



}