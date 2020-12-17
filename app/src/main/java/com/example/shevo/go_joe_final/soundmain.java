package com.example.shevo.go_joe_final;

import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class soundmain extends AppCompatActivity {

    private  Button vibrate;
    private  Button normal;
    private  Button silent;
    private TextView feed;
    private TextView HElp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundmain);
        vibrate=(Button) findViewById(R.id.vibrate);
        normal=(Button) findViewById(R.id.normal);
        feed = (TextView) findViewById(R.id.feedb);
        HElp = (TextView) findViewById(R.id.help);

       feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(soundmain.this, sendfeedback.class);
                startActivity(mainIntend);
            }
        });
        HElp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(soundmain.this, sendfeedback.class);
                startActivity(mainIntend);
            }
        });
        final AudioManager audioManager = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);

        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        });




    }
}
