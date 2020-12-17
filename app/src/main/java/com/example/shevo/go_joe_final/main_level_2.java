package com.example.shevo.go_joe_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class main_level_2 extends AppCompatActivity {

    private ImageButton playButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_l2);

        playButton1 = (ImageButton) findViewById(R.id.play1);

        playButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(main_level_2.this,level_2.class);
                startActivity(mainIntend);
            }
        });
    }
}