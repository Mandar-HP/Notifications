package com.example.notifications;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class IntentClickAction extends AppCompatActivity {

    private Button backBtn;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_click_action);

        init();
    }

    public void init(){

        backBtn = findViewById(R.id.Backbtn);
        backBtn.setOnClickListener(new ClickListener());


        Snackbar snackbarObj = Snackbar.make(backBtn, "Notification is Clicked !", Snackbar.LENGTH_SHORT);
        snackbarObj.show();

        //Toast.makeText(this, "Notification is Clicked !", Toast.LENGTH_SHORT).show();
    }



    public class ClickListener  implements View.OnClickListener{


        @Override
        public void onClick(View v) {

            if (v == backBtn){

                finishAffinity();

            }
        }

    }



}
