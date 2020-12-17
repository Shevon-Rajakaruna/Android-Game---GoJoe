package com.example.shevo.go_joe_final;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import java.util.Timer;
import java.util.TimerTask;


public class mainAct_L1 extends Activity {

    private FlyingView_L1 gameView;
    private Handler handler =  new Handler();
    private final static long Interval = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new FlyingView_L1(this);
        setContentView(gameView);

        Timer timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });
            }
        },0,Interval);
    }
}