package com.masum035.learning_service;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // For Background Service
//        Intent b_seviceIntent = new Intent(this, BackgroundService.class);
//        startService(b_seviceIntent);
        // For ForeGround Service
        if(!foregroundServiceIsRunning()) {
            Intent f_seviceIntent = new Intent(this, ForeGroundService.class);
            startForegroundService(f_seviceIntent);
        }
    }

    public boolean foregroundServiceIsRunning(){
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for(ActivityManager.RunningServiceInfo serviceInfo: activityManager.getRunningServices(Integer.MAX_VALUE)){
            if (ForeGroundService.class.getName().equals(serviceInfo.service.getClassName())){
                return true;
            }
        }
        return false;

    }
}