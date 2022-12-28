package com.example.vishalparekh_comp304_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences("mypref",
                0);
        sharedpreferences.edit().remove("text").commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movie_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String movieKey = "Movie Key";
        String movieName;
        switch (item.getItemId()) {
            case R.id.movie1:
                movieName = getString(R.string.movie1);
                editor.putString(movieKey,movieName);
                editor.commit();
                selectTime();
                break;

            case R.id.movie2:
                movieName = getString(R.string.movie2);
                editor.putString(movieKey,movieName);
                editor.commit();
                selectTime();
                break;

            case R.id.movie3:
                movieName = getString(R.string.movie3);
                editor.putString(movieKey,movieName);
                editor.commit();
                selectTime();
                break;

            case R.id.movie4:
                movieName = getString(R.string.movie4);
                editor.putString(movieKey,movieName);
                editor.commit();
                selectTime();
                break;
            case R.id.movie5:
                movieName = getString(R.string.movie5);
                editor.putString(movieKey,movieName);
                editor.commit();
                selectTime();
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;

    }
    public void selectTime(){
        Intent intent = new Intent(this, showTime.class);
        startActivity(intent);
    }
}