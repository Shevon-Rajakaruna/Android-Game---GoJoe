package com.example.shevo.go_joe_final;


import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import java.util.Timer;
import java.util.TimerTask;


public class Main_L3 extends Activity {

    private TextView scoreLabel;
    private TextView startLabel;
    private ImageView pic1;
    private ImageView fireball;
    private ImageView water;


    // Size
    private int frameHeight;
    private int boxSize;
    private int screenWidth;
    private int screenHeight;

    // Position
    private int pic1Y;
    private int fireballX;
    private int fireballY;
    private int waterX;
    private int waterY;


    // Speed
    private int picSpeed;
    private int fireballSpeed;
    private int waterSpeed;

    // Score
    private int score = 0;

    // Initialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private  soundplyer sound;

    // Status Check
    private boolean action_flg = false;
    private boolean start_flg = false;



    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_l3);

        sound = new soundplyer(this);

        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        startLabel = (TextView) findViewById(R.id.startLabel);
        pic1 = (ImageView) findViewById(R.id.pic1);
        fireball = (ImageView) findViewById(R.id.fireball);
        water = (ImageView) findViewById(R.id.water);


        // Get screen size.
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        // Now
        // Nexus4 Width: 768 Height:1280
        // Speed Box:20 Orange:12 Pink:20 Black:16

        picSpeed = Math.round(screenHeight / 60);  // 1280 / 60 = 21.333... => 21
        fireballSpeed = Math.round(screenWidth / 60); // 768 / 60 = 12.8 => 13
        waterSpeed = Math.round(screenWidth / 36);   // 768 / 36 = 21.333... => 21


        // Move to out of screen.
        fireball.setX(-80);
        fireball.setY(-80);
        water.setX(-80);
        water.setY(-80);

        scoreLabel.setText("Score : 0");
    }


    public void changePos() {

        hitCheck();

        // water
        waterX -= waterSpeed;
        if (waterX < 0) {
            waterX = screenWidth + 20;
            waterY = (int) Math.floor(Math.random() * (frameHeight - water.getHeight()));
        }
        water.setX(waterX);
        water.setY(waterY);


        // fireball
        fireballX -= fireballSpeed;
        if (fireballX < 0) {
            fireballX = screenWidth + 10;
            fireballY = (int) Math.floor(Math.random() * (frameHeight - fireball.getHeight()));
        }
        fireball.setX(fireballX);
        fireball.setY(fireballY);


        // Move Box
        if (action_flg == true) {
            // Touching
            pic1Y -= picSpeed;

        } else {
            // Releasing
            pic1Y += picSpeed;
        }

        // Check box position.
        if (pic1Y < 0) pic1Y = 0;

        if (pic1Y > frameHeight - boxSize) pic1Y = frameHeight - boxSize;

        pic1.setY(pic1Y);

        scoreLabel.setText("Score : " + score);

    }


    public void hitCheck() {

        // If the center of the ball is in the box, it counts as a hit.

        int waterCenterX = waterX + water.getWidth() / 2;
        int waterCenterY = waterY + water.getHeight() / 2;

        if (0 <= waterCenterX && waterCenterX <= boxSize &&
                pic1Y <= waterCenterY && waterCenterY <= pic1Y + boxSize) {

            score += 30;
            waterX = -10;
            sound.playHitSound();

        }

        int blackCenterX = fireballX + fireball.getWidth() / 2;
        int blackCenterY = fireballY + fireball.getHeight() / 2;

        if (0 <= blackCenterX && blackCenterX <= boxSize &&
                pic1Y <= blackCenterY && blackCenterY <= pic1Y + boxSize) {

            // Stop Timer!!
            timer.cancel();
            timer = null;

            sound.playOversound();

            // Show Result
            Intent intent = new Intent(getApplicationContext(), result_L3.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);

        }
    }


    public boolean onTouchEvent(MotionEvent me) {

        if (start_flg == false) {

            start_flg = true;

            // Why get frame height and box height here?
            // Because the UI has not been set on the screen in OnCreate()!!

            FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
            frameHeight = frame.getHeight();

            pic1Y = (int)pic1.getY();

            // The box is a square.(height and width are the same.)
            boxSize = pic1.getHeight();


            startLabel.setVisibility(View.GONE);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            }, 0, 30);


        } else {
            if (me.getAction() == MotionEvent.ACTION_DOWN) {
                action_flg = true;

            } else if (me.getAction() == MotionEvent.ACTION_UP) {
                action_flg = false;
            }
        }

        return true;
    }


    // Disable Return Button
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }

}