package com.danielme.android.autostartservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


public class BackgroundIntentService extends IntentService {

    public BackgroundIntentService() {
        super(BackgroundIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(this.getClass().getSimpleName(),"onHandleIntent");
        Handler mHandler = new Handler(getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),R.string.service_message, Toast.LENGTH_SHORT).show();

            }
        });
    }

}
