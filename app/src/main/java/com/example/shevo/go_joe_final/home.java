package com.example.shevo.go_joe_final;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends Activity {
    private ImageButton ply;
    private ImageButton exi;
    private ImageButton men;
    private ImageButton hom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ply = (ImageButton) findViewById(R.id.pl);
        exi = (ImageButton) findViewById(R.id.ex);
        hom = (ImageButton) findViewById(R.id.hm);
        men = (ImageButton) findViewById(R.id.me);

        ply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(home.this, splash_L1.class);
                startActivity(mainIntend);
            }
        });
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(home.this, soundmain.class);
                startActivity(mainIntend);
            }
        });
        hom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(home.this,loginMain.class);
                startActivity(mainIntend);
            }
        });
        exi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntend = new Intent(home.this,exitmain.class);
                startActivity(mainIntend);
            }
        });

    }
    public void clickexit(View v){
        finish();
    }
    @Override
    public  void  onBackPressed(){
        AlertDialog.Builder builder =new AlertDialog.Builder(home.this);
        builder.setMessage("Do you want to exit");
        builder.setCancelable(true);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                finish();

            }
        });
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                dialogInterface.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
