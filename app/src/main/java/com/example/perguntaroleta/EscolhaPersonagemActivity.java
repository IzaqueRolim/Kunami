package com.example.perguntaroleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class EscolhaPersonagemActivity extends AppCompatActivity {

    int personagem;

    ImageView imgMula,imgBoto,imgIara,imgBoi,imgSaci,imgCurupira;
    Button btnEscolhaPersonagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_personagem);

        imgMula = findViewById(R.id.imgMula);
        imgBoto = findViewById(R.id.imgBoto);
        imgIara = findViewById(R.id.imgIara);
        imgBoi = findViewById(R.id.imgBoi);
        imgSaci = findViewById(R.id.imgSaci);
        imgCurupira = findViewById(R.id.imgCurupira);
        btnEscolhaPersonagem = findViewById(R.id.btnEscolhaPersonagem);

        imgMula.setOnClickListener(v->{
            personagem = R.drawable.mulac_p;
        });
        imgBoto.setOnClickListener(v->{
            personagem = R.drawable.boto_p2;
        });
        imgIara.setOnClickListener(v->{
            personagem = R.drawable.iara_p;
        });
        imgBoi.setOnClickListener(v->{
            personagem =R.drawable.boi_p;
        });
        imgSaci.setOnClickListener(v->{
            personagem = R.drawable.sacii_p;
        });
        imgCurupira.setOnClickListener(v->{
            personagem = R.drawable.curupira_p;
        });

        btnEscolhaPersonagem.setOnClickListener(v->{
            // Criar um Intent
            Intent intent = new Intent(getApplicationContext(), PerguntaActivity.class);
            // Adicionar dados extras
            intent.putExtra("personagem", personagem);
            // Iniciar a próxima atividade
            startActivity(intent);

        });
    }
}