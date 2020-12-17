package com.example.shevo.go_joe_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver_L2 extends AppCompatActivity {

    private Button StartGameAgain;
    private TextView DisplayScore;
    private String score;
    private Button nextLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_over_l1);

        score = getIntent().getExtras().get("score").toString();

        nextLevel = (Button) findViewById(R.id.nextLevel);
        StartGameAgain = (Button) findViewById(R.id.play_again_btn);
        DisplayScore = (TextView) findViewById(R.id.displayScore);

        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(GameOver_L2.this, mainAct_L1.class);
                startActivity(mainIntend);
            }
        });
        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(GameOver_L2.this,Main_L3.class);
                startActivity(mainIntend);
            }
        });

        DisplayScore.setText("score ="+score);
    }

}
