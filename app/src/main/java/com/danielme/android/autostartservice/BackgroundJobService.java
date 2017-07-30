package com.danielme.android.autostartservice;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class BackgroundJobService extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(this.getClass().getSimpleName(),"onStartJob");
        Handler mHandler = new Handler(getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),R.string.service_message, Toast.LENGTH_SHORT).show();
            }
        });

        BootReceiver.scheduleJob(getApplicationContext());
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

}
