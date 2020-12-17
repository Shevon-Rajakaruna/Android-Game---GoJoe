package com.example.shevo.go_joe_final;

import android.content.Intent;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;

public class start_L3 extends Activity {


    public void startGame(View view) {
        startActivity(new Intent(getApplicationContext(), Main_L3.class));
    }

    // Disable Return Button
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_UP) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }
}