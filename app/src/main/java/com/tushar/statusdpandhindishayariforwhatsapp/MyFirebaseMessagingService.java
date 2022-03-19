package com.tushar.statusdpandhindishayariforwhatsapp;

import android.app.Service;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        disMsg(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());

    }

    public void disMsg(String title, String msg)
    {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"myfirebasemsg")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(101,builder.build());

    }
}
