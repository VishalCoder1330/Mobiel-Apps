package com.example.vishal_parekh_comp304_lab4_room;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MovieRepository {
    private final MovieDao movieDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<Movie>> movieList;

    public MovieRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        movieDao = db.movieDao();
        movieList = movieDao.getAllMovieNames();
    }
    // returns query results as LiveData object
    LiveData<List<Movie>> getAllMovie() {
        return movieList;
    }
    //inserts a person asynchronously
    public void insert(Movie movie) {
        insertAsync(movie);
    }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final Movie movie) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    movieDao.insert(movie);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}

