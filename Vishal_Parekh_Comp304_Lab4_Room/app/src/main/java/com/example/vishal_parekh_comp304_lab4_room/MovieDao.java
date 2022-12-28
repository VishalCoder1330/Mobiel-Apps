package com.example.vishal_parekh_comp304_lab4_room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert
    void insert(Movie movie);

    @Query("select * from Movie order by movieName")
    abstract LiveData<List<Movie>> getAllMovieNames();
}
