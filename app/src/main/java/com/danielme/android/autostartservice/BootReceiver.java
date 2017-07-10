package com.danielme.android.autostartservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {

    private static final int PERIOD_MS = 5000;

    @Override
    public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, R.string.boot_message, Toast.LENGTH_SHORT).show();

            Intent newIntent = new Intent(context, BackgroundIntentService.class);
            PendingIntent pendingIntent = PendingIntent.getService(context, 1, newIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT);

            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            manager.setInexactRepeating(AlarmManager.RTC, System.currentTimeMillis(), PERIOD_MS,
                    pendingIntent);
    }
}
