package com.mediclink.hassan.popularmoviestage1.Notify;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.mediclink.hassan.popularmoviestage1.FavouriteMovies;
import com.mediclink.hassan.popularmoviestage1.MainActivity;
import com.mediclink.hassan.popularmoviestage1.R;

public class ServicesTasks {

    public static final String INTENT_SERVICE_ACTION = "intent_service";

    public static void launchTasks(String action, Context context){

        if (INTENT_SERVICE_ACTION.equals(action)){
            launchIntentService(context);
        }
    }

    public static void clearAllNotifications(Context context) {
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }

    private static void launchIntentService(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(contentIntent(context))
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(R.mipmap.like)
                .setLargeIcon(setLargeBitmap(context))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getResources().getString(R.string.notification_text)))
                .setContentTitle(context.getResources().getString(R.string.notification_title))
                .setContentText(context.getResources().getString(R.string.notification_text))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true)
                .addAction(notificationAction(context))
                .addAction(startFavouriteMovies(context));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            builder.setPriority(Notification.PRIORITY_HIGH);
        }

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1138, builder.build());
    }

    private static Bitmap setLargeBitmap(Context context){
        Resources  res= context.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.mipmap.like);
        return  bitmap;
    }

    private static PendingIntent contentIntent(Context context){

        Intent intent = new Intent(context, MainActivity.class);

        return PendingIntent.getActivity(context,
                2,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT );
    }

    private static PendingIntent favouriteIntent(Context context){

        Intent intent = new Intent(context, FavouriteMovies.class);

        return PendingIntent.getActivity(context,
                2,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT );
    }

    private static NotificationCompat.Action notificationAction(Context context){
        NotificationCompat.Action action = new NotificationCompat.Action(android.R.drawable.ic_notification_clear_all, context.getResources().getString(R.string.close_notification), null);
        return action;
    }

    private static NotificationCompat.Action startFavouriteMovies(Context context){
        NotificationCompat.Action action = new NotificationCompat.Action(R.mipmap.like, context.getResources().getString(R.string.open_favourite), favouriteIntent(context));
        return action;
    }
}
