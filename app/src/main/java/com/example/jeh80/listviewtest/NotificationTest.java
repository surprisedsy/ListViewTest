package com.example.jeh80.listviewtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationTest extends BroadcastReceiver {

    String INTENT_ACTION = Intent.ACTION_BOOT_COMPLETED;

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);

        builder.setSmallIcon(R.drawable.apple).setTicker("HETT").setWhen(System.currentTimeMillis())
                .setNumber(1)
                .setContentTitle("유통기한 알림")
                .setContentText("며칠 안남았음 빨리 드셈")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)         // setDefaults 삭제된 함수인듯. 나중에 지우고 써보기
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationManager.notify(1, builder.build());
    }
}
