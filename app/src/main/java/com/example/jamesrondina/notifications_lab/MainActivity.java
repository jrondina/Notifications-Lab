package com.example.jamesrondina.notifications_lab;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    private int requestCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, 0);

        final NotificationCompat.Builder nb = new NotificationCompat.Builder(this);
        nb.setSmallIcon(android.R.drawable.ic_dialog_alert);
        nb.setContentTitle("Connection Alert");
        nb.setContentText("Finding Connection");


        if (ni.isConnected()) {
            final NotificationCompat.BigPictureStyle gangnamStyle = new NotificationCompat.BigPictureStyle();
            gangnamStyle.bigPicture(BitmapFactory.decodeResource(getResources(),
                    R.drawable.gangnamconnect));
            nb.setPriority(Notification.PRIORITY_MAX);
            nb.setAutoCancel(true);
            nb.setContentIntent(pIntent);

            nb.setStyle(gangnamStyle);
        }
        else {
            final NotificationCompat.BigPictureStyle gangnamStyle = new NotificationCompat.BigPictureStyle();
            gangnamStyle.bigPicture(BitmapFactory.decodeResource(getResources(),
                    R.drawable.gangnamdisconnect));
            nb.setPriority(Notification.PRIORITY_MAX);
            nb.setAutoCancel(false);
            nb.setContentIntent(pIntent);

            nb.setStyle(gangnamStyle);
        }








    }
}
