package com.example.shevo.go_joe_final;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class level2_view extends View {

    private Bitmap fish[]=new Bitmap[2];
    private int fishX = 10;
    private int fishY;
    private int fishSpeed;

    private int canvasWidth , canvasheight;

    private int yellowX , yellowY , yellowSpeed = 16;
    private Paint yellowPaint = new Paint();

    private int greenX , greenY , greenSpeed = 30;
    private Paint greenPaint = new Paint();

    private int redX , redY , redSpeed = 40;
    private Paint redPaint = new Paint();

    private int brownX , brownY , brownSpeed = 5;
    private Paint brownPaint = new Paint();



    private int score , lifeCounterOFWater;

    private boolean touch  = false;

    private Bitmap BackgroundImage;
    private Paint scorePaint = new Paint();
    private Bitmap life [] = new Bitmap[2];

    public level2_view(Context context) {
        super(context);
        BackgroundImage = BitmapFactory.decodeResource(getResources(), R.drawable.xxxxx);

        fish[0] = BitmapFactory.decodeResource(getResources(), R.drawable.wwe);
        fish[1] = BitmapFactory.decodeResource(getResources(),R.drawable.ooo);


        yellowPaint.setColor(Color.BLUE);
        yellowPaint.setAntiAlias(false);

        greenPaint.setColor(Color.GREEN);
        greenPaint.setAntiAlias(false);
        redPaint.setColor(Color.RED);
        redPaint.setAntiAlias(false);
        brownPaint.setColor(Color.BLACK);
        brownPaint.setAntiAlias(false);

        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(50);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1] = BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);

        fishY = 550;
        score = 0;
        lifeCounterOFWater=3 ;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        canvasWidth = canvas.getWidth();
        canvasheight = canvas.getHeight();

        canvas.drawBitmap(BackgroundImage,0,0,null);
        int minFishY = fish[0].getHeight();
        int maxFishY = canvasheight - fish[0].getHeight()*3;
        fishY = fishY + fishSpeed;

        if(fishY < minFishY){
            fishY = minFishY;
        }
        if(fishY > maxFishY){
            fishY = maxFishY;
        }
        fishSpeed = fishSpeed + 2;

        if(touch){
            canvas.drawBitmap(fish[1],fishX , fishY ,null);
            touch = false;
        }
        else{
            canvas.drawBitmap(fish[0] , fishX , fishY , null);

        }

        yellowX = yellowX - yellowSpeed;

        if(hitBallChecker(yellowX , yellowY)){
            score = score +10;
            yellowX =-100;
        }

        if(yellowX < 0){
            yellowY = canvasWidth+21;
            yellowY = (int) Math.floor(Math.random() * (maxFishY-minFishY)) + minFishY;
        }
        canvas.drawRect(30, 30 , 80 , 80 , yellowPaint);

        greenX = greenX - greenSpeed;

        if(hitBallChecker(greenX , greenY)){
            score = score + 20;
            greenX =-100;
        }

        if(greenX < 0){
            greenX = canvasWidth+21;
            greenY = (int) Math.floor(Math.random() * (maxFishY-minFishY)) + minFishY;
        }
        canvas.drawCircle(greenX , greenY , 25,greenPaint);

        brownX =   brownX -   brownSpeed;

        if(hitBallChecker(  brownX ,   brownY)){
            score = score +50;
            brownX =-100;
        }

        if(  brownX < 0){
            brownX = canvasWidth+30;
            brownY = (int) Math.floor(Math.random() * (maxFishY-minFishY)) + minFishY;
        }
        canvas.drawRect(30, 30 , 80 , 80 ,   brownPaint);
        canvas.drawCircle(brownX , brownY , 100,greenPaint);

        redX = redX - redSpeed;

        if(hitBallChecker(redX , redY)){

            redX =-100;
            lifeCounterOFWater--;

            if(lifeCounterOFWater == 0){
                Toast.makeText(getContext(), "GAME OVER", Toast.LENGTH_SHORT).show();

                Intent gameOverIntent = new Intent(getContext(),GameOver_L2.class);
                gameOverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                gameOverIntent.putExtra("score" , score);
                getContext().startActivity(gameOverIntent);

            }
        }

        if(redX < 0){
            redX = canvasWidth+21;
            redY = (int) Math.floor(Math.random() * (maxFishY-minFishY)) + minFishY;
        }
        canvas.drawCircle(redX , redY , 35,redPaint);

        canvas.drawText("score  :"+ score,20,60,scorePaint);

        for (int i=0; i<3;i++){

            int x =(int )(380 + life[0].getWidth() * 1.5 *i);
            int y = 30;

            if(i < lifeCounterOFWater){

                canvas.drawBitmap(life[0] , x ,y,null);

            }
            else {
                canvas.drawBitmap(life[1] ,x,y,null);
            }
        }
    }

    public boolean hitBallChecker(int x, int y){
        if(fishX < x && x <(fishX + fish[0].getWidth()) && fishY < y  && y <(fishY +fish[0].getHeight())){
            return true;
        }
        return false;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            touch = true;

            fishSpeed = -22;

        }

        return true;

    }
}

