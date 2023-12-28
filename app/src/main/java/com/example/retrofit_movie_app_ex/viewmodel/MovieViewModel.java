package com.example.retrofit_movie_app_ex.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofit_movie_app_ex.model.Movie;
import com.example.retrofit_movie_app_ex.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    MovieRepository movieRepository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
    }


    public LiveData<List<Movie>> getAllMovie(){
        return movieRepository.getMutableLiveData();
    }

}
