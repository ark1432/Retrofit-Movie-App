package com.example.retrofit_movie_app_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.retrofit_movie_app_ex.databinding.ActivityMainBinding;
import com.example.retrofit_movie_app_ex.databinding.ActivityMovieDetailedBinding;
import com.example.retrofit_movie_app_ex.model.Movie;

public class MovieDetailedActivity extends AppCompatActivity {

    ActivityMovieDetailedBinding activityMovieDetailedBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detailed);

        activityMovieDetailedBinding= DataBindingUtil.setContentView(this,R.layout.activity_movie_detailed);


        Intent intent= getIntent();
        Movie movie= intent.getParcelableExtra("movie");
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String voteAverage=getIntent().getStringExtra("voteAverage");
        String posterPath=getIntent().getStringExtra("posterPath");
        String imgPath = "https://image.tmdb.org/t/p/w500/" + posterPath;
        Glide.with(this).load(imgPath).into(activityMovieDetailedBinding.posterPath);


        activityMovieDetailedBinding.setTitle(title);
        activityMovieDetailedBinding.setDescription(description);
        activityMovieDetailedBinding.setVoteAverage(voteAverage);
        activityMovieDetailedBinding.executePendingBindings();

    }
}