package com.utp.petfriendly.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.utp.petfriendly.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private TextView txtRestPassword, txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setup();
    }

    private void setup(){
        btnLogin = findViewById(R.id.btnLogin);
        txtRestPassword = findViewById(R.id.txtRestPassword);
        txtRegister = findViewById(R.id.txtRegister);

        btnLogin.setOnClickListener(this);
        txtRestPassword.setOnClickListener(this);
        txtRegister.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                Intent myIntent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(myIntent);
            case R.id.txtRestPassword:
                Log.e("REST","reset password");
                //casa
            case R.id.txtRegister:
                Intent itentResgister = new Intent(LoginActivity.this, RegisterUserActivity.class);
                startActivity(itentResgister);
        }
    }
}