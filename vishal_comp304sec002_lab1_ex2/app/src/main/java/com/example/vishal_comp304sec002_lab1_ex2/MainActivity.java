package com.example.vishal_comp304sec002_lab1_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void activityMethod(View view) {
            // Do something in response to button
            Intent intent = new Intent(this, lab1_ex2.class);
            startActivity(intent);
        }

        public void preferences(View view){
            Intent intent = new Intent(this, lab1_ex2_Pref.class);
            startActivity(intent);
        }
    }