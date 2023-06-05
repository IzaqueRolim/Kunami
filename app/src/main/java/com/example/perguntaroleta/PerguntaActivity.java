package com.example.perguntaroleta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PerguntaActivity extends AppCompatActivity {

    int random;
    Button alternativaA,alternativaB,alternativaC,btnFecharModal;
    FrameLayout modalBonus;
    ImageView sortearPergunta,btnBack,personagem, gif;
    TextView txtPergunta;
    Pergunta pergunta;
    ApiService apiService;

    private Timer timer;
    String listener = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        sortearPergunta = findViewById(R.id.sortearPergunta);
        txtPergunta = findViewById(R.id.txtPergunta);
        alternativaA = findViewById(R.id.alternativaA);
        alternativaB = findViewById(R.id.alternativaB);
        alternativaC = findViewById(R.id.alternativaC);
        btnBack = findViewById(R.id.btnBack);
        modalBonus = findViewById(R.id.modalBonus);
        btnFecharModal = findViewById(R.id.btnFecharModal);
        personagem = findViewById(R.id.Logo);
        gif = findViewById(R.id.gif);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://projeto-k-46f87-default-rtdb.firebaseio.com/Roleta/") // A url
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        sortearPergunta.setOnClickListener(view -> {
            try{
                Log.i("Tag",String.valueOf(random));
                getListener();
                setButtonsCollors();
            }
            catch(Exception e){
                Toast toast = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT);
                toast.show();
            }

        });
        alternativaA.setOnClickListener(view ->{
            verificarAlternativaCorreta(this.alternativaA,"a");
        });
        alternativaB.setOnClickListener(view ->{
            verificarAlternativaCorreta(this.alternativaB,"b");
        });
        alternativaC.setOnClickListener(view ->{
            verificarAlternativaCorreta(this.alternativaC,"c");
        });
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
            finish();
        });
        btnFecharModal.setOnClickListener(v->{
            modalBonus.setVisibility(View.GONE);
        });


        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                getListener();
                handler.postDelayed(this,2000);
            }
        };

        handler.postDelayed(runnable, 1000);

        Intent intent = getIntent();
        int valor = intent.getIntExtra("personagem",0);
        Log.i(" Valor",String.valueOf(valor));
        personagem.setImageResource(valor);




    }

    private void getPerguntasApi(int number){
        try {
//            Random gerador = new Random();
//            random = gerador.nextInt(14);
//            random = random+1;

            Call<Pergunta> call = apiService.getQuestion(number); // Caso queira mudar o cep, mude o argumento("01001000")
            call.enqueue(new Callback<Pergunta>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(Call<Pergunta> call, Response<Pergunta> response) {
                    pergunta = response.body(); // Cria uma instancia da classe pergunta e atribui a resposta da requisição a ela
                    txtPergunta.setText(pergunta.getQ());
                    if(pergunta.getA()!= ""){
                        alternativaA.setText(pergunta.getA());
                        alternativaB.setText(pergunta.getB());
                        alternativaC.setText(pergunta.getC());
                    }
                    else{
                        modalBonus.setVisibility(View.VISIBLE);
                        alternativaA.setText("Avance");
                        alternativaB.setText("Avance");
                        alternativaC.setText("Avance");
                    }
                }
                @Override
                public void onFailure(Call<Pergunta> call, Throwable t) { 	// Caso aconteça algum erro de api(404,500, etc), entra nessa função
                    txtPergunta.setText(t.toString());
                }
            });
        }
        catch (Exception e){ // Caso aconteça algum erro no Java, entra nessa função(catch).
            e.printStackTrace();
            txtPergunta.setText(e.toString());
        }
    }


    private void getListener(){
        Call<String> call = apiService.getListener();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String resposta = response.body();

                if(resposta!= null && !listener.equals(resposta)) {
                    listener = resposta;
                    modalBonus.setVisibility(View.GONE);
                    gif.setVisibility(View.GONE);
                    getPerguntasApi(Integer.parseInt(listener));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                txtPergunta.setText(call.toString());
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    public void verificarAlternativaCorreta(Button btn, String resposta){
        if(pergunta.getA()!= ""){
            btn.setTextColor(getResources().getColor(R.color.white));
            if(pergunta.getCerta().equals(resposta)){
                btn.setBackgroundColor(getResources().getColor(R.color.blue));
                alternativaA.setClickable(false);
                alternativaB.setClickable(false);
                alternativaC.setClickable(false);
                awaitSeconds(2000);
                gif.setVisibility(View.VISIBLE);
                return;
            }
            btn.setBackgroundColor(getResources().getColor(R.color.red));

            alternativaA.setClickable(false);
            alternativaB.setClickable(false);
            alternativaC.setClickable(false);

        }
    }

    @SuppressLint("ResourceAsColor")
    public void setButtonsCollors(){
        alternativaA.setBackgroundColor(getResources().getColor(R.color.button_color));
        alternativaA.setTextColor(getResources().getColor(R.color.text_color));
        alternativaB.setBackgroundColor(getResources().getColor(R.color.button_color));
        alternativaB.setTextColor(getResources().getColor(R.color.text_color));
        alternativaC.setBackgroundColor(getResources().getColor(R.color.button_color));
        alternativaC.setTextColor(getResources().getColor(R.color.text_color));
    }

    public void awaitSeconds(int milliseconds){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setButtonsCollors();
                alternativaA.setClickable(true);
                alternativaB.setClickable(true);
                alternativaC.setClickable(true);
            }
        }, milliseconds);
    }


}