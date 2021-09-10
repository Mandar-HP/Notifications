package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    private ImageButton mainPlayBtn;
    private NotificationManager notiMngrObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    public void initialize(){
        mainPlayBtn = findViewById(R.id.PlayBtnMain);

        mainPlayBtn.setOnClickListener(new MyListener());

        notiMngrObj = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);



    }



    public class MyListener implements View.OnClickListener{



        @SuppressLint("NewApi")
        @Override
        public void onClick(View v) {
            if (v == mainPlayBtn){

                NotificationCompat.Builder notifBuildrObj = new NotificationCompat.Builder(MainActivity.this);

                // THESE ARE MUST FOR INITIALIZING NOTIFICATION :
                notifBuildrObj.setSmallIcon(R.drawable.ic_baseline_music_note_24);
                notifBuildrObj.setContentTitle("Name of Song");
                notifBuildrObj.setContentText("Name of artist"+ "\n" + "Year of Release");
                //


                notifBuildrObj.setAutoCancel(true);                             // FOR DISAPPEARING NOTIFI AFTER CLICKING

                // FOR MEDIA ACTION BUTTONS :
                //notifBuildrObj.setStyle();



                // SETTING PENDING INTENT FOR OUR NOTIFICATION :

                Intent intntObj = new Intent(MainActivity.this,IntentClickAction.class);

                PendingIntent pndIntObj = PendingIntent.getActivity(MainActivity.this,0,intntObj,PendingIntent.FLAG_UPDATE_CURRENT);

                notifBuildrObj.setContentIntent(pndIntObj);

                Notification notificationObj = notifBuildrObj.build();


                // TO EXECUTE NOTIFICATION :
                notiMngrObj.notify(0,notificationObj);
            }

        }
    }

}