package com.masum035.learning_service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Provider;

public class ForeGroundService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            public void run() {
                // ... perform background task ...

                while (true){
                    // Now you want to show a Toast
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("ForeGroundService", "Printing from ForeGround Service...");
                            Toast.makeText(getApplicationContext(), "ForeGround Service is Running", Toast.LENGTH_SHORT).show();
                        }
                    });

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();

        final String CHANNEL_ID = "FOREGROUND_SERVICE_ID";
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                CHANNEL_ID,
                NotificationManager.IMPORTANCE_DEFAULT
        );
        getSystemService(NotificationManager.class).createNotificationChannel(channel);

        Notification.Builder notification = new Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("From Masum's App")
                .setContentText("ForeGround Service is Running")
                .setSmallIcon(R.drawable.ic_launcher_foreground);

        startForeground(1001, notification.build());


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
