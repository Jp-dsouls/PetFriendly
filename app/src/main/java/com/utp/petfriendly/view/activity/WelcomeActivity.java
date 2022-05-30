package com.utp.petfriendly.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.utp.petfriendly.R;

public class WelcomeActivity extends AppCompatActivity {

    private CardView cardStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        cardStart = findViewById(R.id.cardStart);
        cardStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(myIntent);
            }
        });
    }
}