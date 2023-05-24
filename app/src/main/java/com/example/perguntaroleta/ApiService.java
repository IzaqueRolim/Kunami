package com.example.perguntaroleta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("Casa_{number}/Pergunta.json")
    Call<Pergunta> getQuestion(@Path("number") int number);

    @GET("Listener.json")
    Call<String> getListener();
}
