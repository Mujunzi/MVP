package com.example.app2.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app2.R;

import java.util.Timer;
import java.util.TimerTask;

public class AnimationActivity extends AppCompatActivity {

    private ImageView img;
    private TextView count;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();

    }

    int c = 3;

    private void initView() {
        img = findViewById(R.id.img);
        count = findViewById(R.id.count);

        ObjectAnimator aFloat = ObjectAnimator.ofFloat(img, View.TRANSLATION_X, 0, 200);
        ObjectAnimator aFloat1 = ObjectAnimator.ofFloat(img, View.ROTATION, 0, 360);
        ObjectAnimator aFloat2 = ObjectAnimator.ofFloat(img, View.ALPHA, 0, 1);
        ObjectAnimator aFloat3 = ObjectAnimator.ofFloat(img, View.SCALE_X, 0, 2);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(aFloat, aFloat1, aFloat2, aFloat3);
        animatorSet.setDuration(3000);
        animatorSet.start();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                c--;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        count.setText(c + "秒");
                    }
                });
                if (c == 0) {
                    timer.cancel();
                    startActivity(new Intent(AnimationActivity.this, LoginActivity.class));
                }
            }
        }, 1000, 1000);
    }
}