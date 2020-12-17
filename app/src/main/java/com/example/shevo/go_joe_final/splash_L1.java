package com.example.shevo.go_joe_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class splash_L1 extends AppCompatActivity {

    private ImageButton playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        playButton = (ImageButton) findViewById(R.id.play);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(splash_L1.this, mainAct_L1.class);
                startActivity(mainIntend);
            }
        });
    }
}