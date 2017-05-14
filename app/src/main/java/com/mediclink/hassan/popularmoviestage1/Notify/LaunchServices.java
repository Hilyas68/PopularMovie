package com.mediclink.hassan.popularmoviestage1.Notify;

import android.content.Context;
import android.content.Intent;

public class LaunchServices {

    public static void startIntentService(Context context){

        Intent intent = new Intent(context, IntentServicesMethod.class);
        intent.setAction(ServicesTasks.INTENT_SERVICE_ACTION);
        context.startService(intent);
    }
}
