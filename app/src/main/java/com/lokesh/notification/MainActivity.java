package com.lokesh.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "Msg";
    private static final int NOTIFICATION_ID = 1;
    private static  final  int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.new_icon,null);
        BitmapDrawable  bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();
        Intent iNotify = new Intent(this,MainActivity.class);

        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this, REQ_CODE,iNotify,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);

        // big piture style

        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture((
                        (BitmapDrawable) (ResourcesCompat.getDrawable(getResources(),
                                R.drawable.new_icon,null)))
                                .getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent by Lokesh")
                .setSummaryText("Image Message");


        // Inbox style

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("B")
                .addLine("c")
                .addLine("D")
                .addLine("e")
                .addLine("f")
                .addLine("g")
                .addLine("h")
                .addLine("I")
                .setBigContentTitle("Image sent by abc")
                .setSummaryText("Full Message");



        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(this)
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.new_icon)
                .setContentText("new msg ")
                .setSubText("new message from lokesh")
                .setContentIntent(pi)
                .setStyle(bigPictureStyle)
                .setChannelId(CHANNEL_ID)
                .setOngoing(true)
                .build();

        nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"new channel",NotificationManager.IMPORTANCE_HIGH));


        nm.notify(NOTIFICATION_ID,notification);
    }
}
