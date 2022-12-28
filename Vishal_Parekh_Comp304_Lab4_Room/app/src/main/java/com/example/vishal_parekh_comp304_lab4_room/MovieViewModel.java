package com.example.vishal_parekh_comp304_lab4_room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository movieRepo;
    private androidx.lifecycle.LiveData<Integer> insertResult;
    private androidx.lifecycle.LiveData<List<Movie>> allMovie;
    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieRepo = new MovieRepository(application);
        insertResult = movieRepo.getInsertResult();
        allMovie = movieRepo.getAllMovie();
    }
    public void insert(Movie movie) {movieRepo.insert(movie);}
}
