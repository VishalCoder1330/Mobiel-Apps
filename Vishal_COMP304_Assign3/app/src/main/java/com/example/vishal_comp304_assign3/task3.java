package com.example.vishal_comp304_assign3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class task3 extends AppCompatActivity {
    private ImageView marsImageView;
    private ImageView earthImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);
        earthImageView = findViewById(R.id.earthImgView);
        marsImageView = findViewById(R.id.marsImgView);
        findViewById(R.id.startAnimBtn).setOnClickListener(v -> startAnimation());
        findViewById(R.id.stopAnimBtn).setOnClickListener(v -> stopAnimation());
    }
    private void startAnimation() {

        earthImageView.setImageResource(R.drawable.img1);
        marsImageView.setImageResource(R.drawable.img3);

        Animation earthAnim = AnimationUtils.loadAnimation(this, R.anim.earth_spin);
        Animation marsAnim = AnimationUtils.loadAnimation(this, R.anim.mars_spin);

        earthAnim.setRepeatCount(Animation.INFINITE);
        marsAnim.setRepeatMode(Animation.RESTART);
        marsAnim.setRepeatCount(Animation.INFINITE);
        marsImageView.startAnimation(marsAnim);
        earthImageView.startAnimation(earthAnim);
    }

    private void stopAnimation() {
        earthImageView.clearAnimation();
        marsImageView.clearAnimation();
       }
}