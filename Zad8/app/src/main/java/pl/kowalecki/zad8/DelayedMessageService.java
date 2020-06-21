package pl.kowalecki.zad8;


import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;

import android.support.v4.app.NotificationCompat;


public class DelayedMessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "Przykładowa wiadomość w powiadomieniu";
    public static final int NOTIFICATION_ID = 1;
    String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";


    public DelayedMessageService(){
        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    synchronized (this){
        try{
            wait(1000); // 1000 = 1s
            System.out.println("onHandle");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    showText();

    }

    private void showText() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.button_text))
                .setContentText(EXTRA_MESSAGE)
                .setContentInfo("Information");

        Intent actionIntent = new Intent(this, MainActivity.class);
        PendingIntent actionPendingIntent = PendingIntent.getActivity(
                this, 0, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(actionPendingIntent);
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }
}



