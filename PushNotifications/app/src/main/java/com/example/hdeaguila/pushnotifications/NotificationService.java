package com.example.hdeaguila.pushnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by hd.eaguila on 25/07/2016.
 */
public class NotificationService extends FirebaseMessagingService {

    public static final String TAG = "firebase";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        notificacion(remoteMessage.getFrom(),remoteMessage.getNotification().getBody());
        Log.d(TAG,"From: "+ remoteMessage.getFrom());
        Log.d(TAG,"Body: "+remoteMessage.getNotification().getBody());
    }

    public void notificacion(String not,String text){
        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pending =  PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificacion =  new NotificationCompat.Builder(getApplicationContext())

                .setSmallIcon(R.mipmap.ic_notification)
                .setContentTitle(not)
                .setContentText(text)
                .setContentIntent(pending)
                .setAutoCancel(true);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificacion.build());

    }
}
