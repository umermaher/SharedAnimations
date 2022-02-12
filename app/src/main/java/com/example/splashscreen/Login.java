package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    AppCompatButton signUpBtn,loginBtn;
    ImageView icon;
    TextView title,slogan;
    TextInputLayout userName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(null);
        }
        signUpBtn=findViewById(R.id.call_signup);
        loginBtn=findViewById(R.id.call_signin);
        icon=findViewById(R.id.icon);
        title=findViewById(R.id.title);
        slogan=findViewById(R.id.slogan_text);
        userName=findViewById(R.id.username_text);
        password=findViewById(R.id.password);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair[] pairs=new Pair[7];
                pairs[0]=new Pair<View,String>(icon,"anim_icon");
                pairs[1]=new Pair<View,String>(title,"anim_text");
                pairs[2]=new Pair<View,String>(slogan,"anim_text");
                pairs[3]=new Pair<View,String>(userName,"username_tran");
                pairs[4]=new Pair<View,String>(password,"password_tran");
                pairs[5]=new Pair<View,String>(signUpBtn,"signup_tran");
                pairs[6]=new Pair<View,String>(loginBtn,"signin_tran");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                    startActivity(new Intent(Login.this,SignUp.class),options.toBundle());

                }
            }
        });
    }
}