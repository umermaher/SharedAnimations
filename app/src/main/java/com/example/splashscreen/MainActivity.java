package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView title;
    public static int SPLASH_SCREEN=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.botton_anim);

        image=findViewById(R.id.icon);
        title=findViewById(R.id.title);

        image.setAnimation(topAnim);
        title.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Pair[] pairs=new Pair[2];
                androidx.core.util.Pair pairs[]=new androidx.core.util.Pair[2];
                pairs[0]= new androidx.core.util.Pair(image,"anim_icon");
                pairs[1]= new androidx.core.util.Pair(image,"anim_text");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(new Intent(MainActivity.this,Login.class),options.toBundle());
                    finish();
                    getWindow().setExitTransition(null);
                }
            }
        },SPLASH_SCREEN);
    }
}