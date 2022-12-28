package com.example.vishal_parekh_comp304_lab4_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    private MovieViewModel movieViewModel;
    public static final String mypreference = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences("mypref",
                0);

        sharedpreferences.edit().remove("text").commit();
    }
    public void OnClick(View v){
        Intent intent = new Intent(this, Login.class);
        String movieName;
        SharedPreferences.Editor editor = sharedpreferences.edit();
        int movieId;
        String movieKey = "Movie Key";
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        Movie movie = new Movie();
        TextView txt;
        String id;
        switch(v.getId()) {
            case R.id.textView3:
                txt = (TextView) findViewById(R.id.textView3);
                movieId = 1;
                movieName = txt.getText().toString();
                id = Integer.toString(movieId);
                editor.putString("movieId",id);
                editor.putString(movieKey,movieName);
                editor.commit();
                movie.setMovieId(movieId);
                movie.setMovieName(movieName);
                movieViewModel.insert(movie);
                break;
            case R.id.textView4:
                txt = (TextView) findViewById(R.id.textView4);
                movieId = 2;
                movieName = txt.getText().toString();
                id = Integer.toString(movieId);
                editor.putString("movieId",id);
                editor.putString(movieKey,movieName);
                editor.commit();
                movie.setMovieId(movieId);
                movie.setMovieName(movieName);
                movieViewModel.insert(movie);
                break;
            case R.id.textView5:
                txt = (TextView) findViewById(R.id.textView5);
                movieId = 3;
                movieName = txt.getText().toString();
                id = Integer.toString(movieId);
                editor.putString("movieId",id);
                editor.putString(movieKey,movieName);
                editor.commit();
                movie.setMovieId(movieId);
                movie.setMovieName(movieName);
                movieViewModel.insert(movie);
                break;
            case R.id.textView6:
                txt = (TextView) findViewById(R.id.textView6);
                movieId = 4;
                movieName = txt.getText().toString();
                id = Integer.toString(movieId);
                editor.putString("movieId",id);
                editor.putString(movieKey,movieName);
                editor.commit();
                movie.setMovieId(movieId);
                movie.setMovieName(movieName);
                movieViewModel.insert(movie);
                break;
            case R.id.textView7:
                txt = (TextView) findViewById(R.id.textView7);
                movieId = 5;
                movieName = txt.getText().toString();
                id = Integer.toString(movieId);
                editor.putString("movieId",id);
                editor.putString(movieKey,movieName);
                editor.commit();
                movie.setMovieId(movieId);
                movie.setMovieName(movieName);
                movieViewModel.insert(movie);
                break;
            case R.id.textView8:
                txt = (TextView) findViewById(R.id.textView8);
                movieId = 6;
                movieName = txt.getText().toString();
                id = Integer.toString(movieId);
                editor.putString("movieId",id);
                editor.putString(movieKey,movieName);
                editor.commit();
                movie.setMovieId(movieId);
                movie.setMovieName(movieName);
                movieViewModel.insert(movie);
                break;
        }
        startActivity(intent);
    }
}