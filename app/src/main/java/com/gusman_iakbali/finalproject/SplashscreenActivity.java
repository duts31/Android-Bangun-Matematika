package com.gusman_iakbali.finalproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashscreenActivity extends AppCompatActivity {

    private static int splashDelay = 5500;
    //Deklarasi variabel img dan animasi
    ImageView img, img2;
    Animation fade_out, fade_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        //Inisialisasi image dan animasi
        img = (ImageView)findViewById(R.id.imgSplash);
        img2 = (ImageView)findViewById(R.id.imgSplash2);

        fade_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        fade_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                img.startAnimation(fade_out);
                img.setVisibility(View.INVISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        img2.startAnimation(fade_in);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                img2.startAnimation(fade_out);

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);
                                        startActivity(intent);

                                    }
                                },2500);

                            }
                        },2400);

                    }
                },2100);

            }
        },500);
    }
}
