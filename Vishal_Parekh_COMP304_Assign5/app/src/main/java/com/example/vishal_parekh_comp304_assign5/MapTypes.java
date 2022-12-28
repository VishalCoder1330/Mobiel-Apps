package com.example.vishal_parekh_comp304_assign5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MapTypes extends AppCompatActivity {
    private Cities mapCity;
    private Button standard;
    private Button terrain;
    private Button satelite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_types);

        mapCity = (Cities) getIntent().getSerializableExtra("City");
        standard = findViewById(R.id.button);
        terrain = findViewById(R.id.button2);
        satelite = findViewById(R.id.button3);
        standard.setOnClickListener(v -> {
            Intent intent = new Intent(MapTypes.this, MapsActivity.class);
            intent.putExtra("city", mapCity);
            intent.putExtra("type", 1);
            startActivity(intent);
        });
        terrain.setOnClickListener(v -> {
            Intent intent = new Intent(MapTypes.this, MapsActivity.class);
            intent.putExtra("city", mapCity);
            intent.putExtra("type", 2);
            startActivity(intent);
        });
        satelite.setOnClickListener(v -> {
            Intent intent = new Intent(MapTypes.this, MapsActivity.class);
            intent.putExtra("city", mapCity);
            intent.putExtra("type", 3);
            startActivity(intent);
        });
    }
}