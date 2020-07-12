package com.example.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.animation.Animator;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


public class MainActivity extends AppCompatActivity {

    ImageView news;
    TextView newstextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        news=findViewById(R.id.news);

        newstextview=findViewById(R.id.newstextview);


        YoYo.with(Techniques.ZoomIn).duration(2000).withListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).playOn(news);
        new Thread(new Runnable(){

            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    finish();

                    startActivity(new Intent(MainActivity.this,NewsForYou.class));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
