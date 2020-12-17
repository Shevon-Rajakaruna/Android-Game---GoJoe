package com.example.shevo.go_joe_final;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class exitmain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
    }
    public void clickexit(View v){
        finish();
    }
    @Override
    public  void  onBackPressed(){
        AlertDialog.Builder builder =new AlertDialog.Builder(exitmain.this);
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

