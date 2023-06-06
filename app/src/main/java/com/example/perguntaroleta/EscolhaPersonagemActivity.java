package com.example.perguntaroleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class EscolhaPersonagemActivity extends AppCompatActivity {

    int personagem;

    ImageView imgMula,imgBoto,imgIara,imgBoi,imgSaci,imgCurupira;

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


        imgMula.setOnClickListener(v->{
            personagem = R.drawable.mulac_p;
            imgMula.setBackgroundResource(R.drawable.border);
            imgBoto.setBackgroundResource(0);
            imgIara.setBackgroundResource(0);
            imgBoi.setBackgroundResource(0);
            imgSaci.setBackgroundResource(0);
            imgCurupira.setBackgroundResource(0);
            MudarTela();
        });
        imgBoto.setOnClickListener(v->{
            personagem = R.drawable.boto_p2;
            imgBoto.setBackgroundResource(R.drawable.border);
            imgMula.setBackgroundResource(0);
            imgIara.setBackgroundResource(0);
            imgBoi.setBackgroundResource(0);
            imgSaci.setBackgroundResource(0);
            imgCurupira.setBackgroundResource(0);
            MudarTela();
        });
        imgIara.setOnClickListener(v->{
            personagem = R.drawable.iara_p;
            imgIara.setBackgroundResource(R.drawable.border);
            imgMula.setBackgroundResource(0);
            imgBoto.setBackgroundResource(0);
            imgBoi.setBackgroundResource(0);
            imgSaci.setBackgroundResource(0);
            imgCurupira.setBackgroundResource(0);
            MudarTela();
        });
        imgBoi.setOnClickListener(v->{
            personagem =R.drawable.boi_p;
            imgBoi.setBackgroundResource(R.drawable.border);
            imgMula.setBackgroundResource(0);
            imgBoto.setBackgroundResource(0);
            imgIara.setBackgroundResource(0);
            imgSaci.setBackgroundResource(0);
            imgCurupira.setBackgroundResource(0);
            MudarTela();
        });
        imgSaci.setOnClickListener(v->{
            personagem = R.drawable.sacii_p;
            imgSaci.setBackgroundResource(R.drawable.border);
            imgMula.setBackgroundResource(0);
            imgBoto.setBackgroundResource(0);
            imgIara.setBackgroundResource(0);
            imgBoi.setBackgroundResource(0);
            imgCurupira.setBackgroundResource(0);
            MudarTela();
        });
        imgCurupira.setOnClickListener(v->{
            personagem = R.drawable.curupira_p;
            imgCurupira.setBackgroundResource(R.drawable.border);
            imgMula.setBackgroundResource(0);
            imgBoto.setBackgroundResource(0);
            imgIara.setBackgroundResource(0);
            imgBoi.setBackgroundResource(0);
            imgSaci.setBackgroundResource(0);
            MudarTela();
        });

    }

    private void MudarTela(){
        Intent intent = new Intent(getApplicationContext(), PerguntaActivity.class);
        // Adicionar dados extras
        intent.putExtra("personagem", personagem);
        // Iniciar a próxima atividade
        startActivity(intent);
    }
}