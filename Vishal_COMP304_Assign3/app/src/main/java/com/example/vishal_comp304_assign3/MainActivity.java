package com.example.vishal_comp304_assign3;

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

    public void onTask1(View view){
        Intent intent = new Intent(this, task1.class);
        startActivity(intent);
    }

    public void onTask2(View view){
        Intent intent = new Intent(this, task2.class);
        startActivity(intent);
    }
    public void onTask3(View view){
        Intent intent = new Intent(this, task3.class);
        startActivity(intent);
    }
}