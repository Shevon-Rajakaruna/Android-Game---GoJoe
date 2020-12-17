package com.example.shevo.go_joe_final;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class soundplyer  {



private  static SoundPool soundPool;
private static int hitsound;
private  static int overSound;

public soundplyer(Context context){


    soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
    hitsound = soundPool.load(context,R.raw.hit,1);
    overSound = soundPool.load(context,R.raw.over,1);

    }

public  void playHitSound(){
    soundPool.play(hitsound,1.0f,1.0f,1,0,1.0f);

}
    public  void playOversound(){
        soundPool.play(overSound,1.0f,1.0f,1,0,1.0f);

    }
}


