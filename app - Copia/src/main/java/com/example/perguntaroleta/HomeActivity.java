package com.example.perguntaroleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    ImageView btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), PerguntaActivity.class);
            startActivity(intent);
            finish();
        });
    }


}