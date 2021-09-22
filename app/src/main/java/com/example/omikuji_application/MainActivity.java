package com.example.omikuji_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 占うボタン
    Button buttonUranau;
    // Clearボタン
    Button buttonClear;
    ImageView imageResult;
    Animation animationVisible;
    Animation animationHide;

    int[] omikujiArray = new int[]{R.drawable.kyo, R.drawable.shokichi, R.drawable.chukichi, R.drawable.daikichi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonUranau = findViewById(R.id.button_uranau);
        buttonClear = findViewById(R.id.button_clear);
        imageResult = findViewById(R.id.uranai_kekka);

        buttonUranau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int resultIdx = random.nextInt(4);
                int resultImgNum = omikujiArray[resultIdx];
                imageResult.setImageResource(resultImgNum);
                //imageResult.setVisibility(View.VISIBLE);
                imageResult.startAnimation(animationVisible);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageResult.setVisibility(View.GONE);
                imageResult.startAnimation(animationHide);
            }
        });

        animationVisible = AnimationUtils.loadAnimation(this, R.anim.omikuji_visible);
        animationHide = AnimationUtils.loadAnimation(this, R.anim.omikuji_hide);
    }

}