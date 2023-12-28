package com.example.retrofit_movie_app_ex.repository;


import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.retrofit_movie_app_ex.R;
import com.example.retrofit_movie_app_ex.model.Movie;
import com.example.retrofit_movie_app_ex.model.Result;
import com.example.retrofit_movie_app_ex.service.MovieApiService;
import com.example.retrofit_movie_app_ex.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){

        MovieApiService movieApiService = RetrofitInstance.getService();

        Call<Result> call = movieApiService.getResult(application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Result result = response.body();
                if (result != null && result.getResults() !=null){
                    movieArrayList = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movieArrayList);
                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {


            }
        });

        return mutableLiveData;
    }
}
