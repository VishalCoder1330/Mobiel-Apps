package com.example.vishalparekh_comp304_assign2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class showTime extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time);
        sharedpreferences = getSharedPreferences("mypref",
                0);
        String movie = sharedpreferences.getString("Movie Key","");
        ImageView imageView;
        TextView textView;
        textView = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        if(movie== getString(R.string.movie1)){
            textView.setText(movie);
            imageView.setImageResource(R.drawable.the_woman_king);
            imageView.setMaxHeight(100);
            imageView.setMaxWidth(104);
        }
        else if(movie==getString(R.string.movie2)){
            textView.setText(movie);
            imageView.setImageResource(R.drawable.top_gun_maverick);
        }
        else if(movie==getString(R.string.movie3)){
            textView.setText(movie);
            imageView.setImageResource(R.drawable.pearl);
        }
        else if(movie==getString(R.string.movie4)){
            textView.setText(movie);
            imageView.setImageResource(R.drawable.minions_the_rise_of_gru_poster);
        }
        else if(movie==getString(R.string.movie5)){
            textView.setText(movie);
            imageView.setImageResource(R.drawable.bullet_train);
        }
        RadioButton time1 = (RadioButton) findViewById(R.id.rdb1);
        RadioButton time2 = (RadioButton) findViewById(R.id.rdb2);
        RadioButton time3 = (RadioButton) findViewById(R.id.rdb3);
        RadioButton time4 = (RadioButton) findViewById(R.id.rdb4);
        RadioButton time5 = (RadioButton) findViewById(R.id.rdb5);
        Button selectTicket = (Button) findViewById(R.id.button2);
        selectTicket.setOnClickListener(new View.OnClickListener(){
            SharedPreferences.Editor editor = sharedpreferences.edit();
            String timeKey = "timeKey";
            String timeValue;
            @Override
            public void onClick(View V){
                if(time1.isChecked()){
                    timeValue = getString(R.string.time1);
                    editor.putString(timeKey,timeValue);
                    editor.commit();
                    selectTicket();
                }
                else if(time2.isChecked()){
                    timeValue = getString(R.string.time2);
                    editor.putString(timeKey,timeValue);
                    editor.commit();
                    selectTicket();
                }
                else if(time3.isChecked()){
                    timeValue = getString(R.string.time3);
                    editor.putString(timeKey,timeValue);
                    editor.commit();
                    selectTicket();
                }
                else if(time4.isChecked()){
                    timeValue = getString(R.string.time4);
                    editor.putString(timeKey,timeValue);
                    editor.commit();
                    selectTicket();
                }
                else if(time5.isChecked()){
                    timeValue = getString(R.string.time5);
                    editor.putString(timeKey,timeValue);
                    editor.commit();
                    selectTicket();
                }
            }
        });
    }
    public void selectTicket(){
        Intent intent = new Intent(this, ticketTypes.class);
        startActivity(intent);
    }
}