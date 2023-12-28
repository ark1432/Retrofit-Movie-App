package com.example.retrofit_movie_app_ex.service;

import com.example.retrofit_movie_app_ex.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {


    @GET("movie/popular")
    Call<Result> getResult(@Query("api_key") String apiKey);
}
