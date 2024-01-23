package com.masum035.learning_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastRecieverForForegroundService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if((intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))){
            Intent serviceIntent = new Intent(context, ForeGroundService.class);
            context.startForegroundService(serviceIntent);
        }
    }
}
