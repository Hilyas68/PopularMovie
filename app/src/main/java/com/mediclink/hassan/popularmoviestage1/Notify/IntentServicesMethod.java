package com.mediclink.hassan.popularmoviestage1.Notify;


import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;


public class IntentServicesMethod extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntentServicesMethod() {

        super("IntentServicesMethod");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getAction();
        ServicesTasks.launchTasks(action, this);
    }
}
