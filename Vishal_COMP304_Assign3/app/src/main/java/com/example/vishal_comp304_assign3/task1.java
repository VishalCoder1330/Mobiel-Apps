package com.example.vishal_comp304_assign3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class task1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ImageView reusableImageView;
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    private int startx = 50;
    private int starty = 50;
    private int endx=300;
    private int endy=300;
    private int stroke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        Spinner spinnerColor=(Spinner) findViewById(R.id.color);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerColor.setAdapter(adapter);
        spinnerColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinnerColor=findViewById(R.id.color);
                String color = spinnerColor.getSelectedItem().toString();
                if(color.equals("Red")){
                    paint.setColor(Color.RED);
                }
                else if(color.equals("Blue")){
                    paint.setColor(Color.BLUE);
                }
                else if(color.equals("Green")){
                    paint.setColor(Color.GREEN);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        paint = new Paint();
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.BLACK);
        reusableImageView = (ImageView)findViewById(R.id.imageView);
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);
        canvas.drawPoint(50,50,paint);
    }
    public void onClickRb1(View v){
        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
        if(rb1.isChecked()){
            stroke=5;
        }
    }
    public void onClickRb2(View v){
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        if(rb2.isChecked()){
            stroke=15;
        }
    }
    public void onClickRb3(View v){
        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        if(rb3.isChecked()){
           stroke=25;
        }
    }
    public void clearCanvas(View v)
    {
        canvas.drawColor(Color.BLACK);
        startx = 150;
        starty = 170;
        endx = 151;
        endy = 171;

    }
    public void drawLine(Canvas canvas)
    {
        paint.setStrokeWidth(stroke);
        canvas.drawLine(startx, starty, endx, endy, paint);
        reusableImageView.setImageBitmap(bitmap);
        startx=endx;
        starty=endy;

    }
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                endx = endx-10;
                drawLine(canvas);
                return true;

            case KeyEvent.KEYCODE_DPAD_UP:
                endy = endy-10;
                drawLine(canvas);
                return true;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                endy=endy+10;
                drawLine( canvas);
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                endx=endx+10;
                drawLine( canvas);
                return true;
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}