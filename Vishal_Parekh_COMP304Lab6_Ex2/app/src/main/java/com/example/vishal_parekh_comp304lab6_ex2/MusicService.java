package com.example.vishal_parekh_comp304lab6_ex2;

import android.app.Service;
import android.content.Intent;
import java.util.Timer;
import android.os.IBinder;
import android.widget.Toast;
import android.media.MediaPlayer;

import java.io.IOException;

public class MusicService extends Service{
    MediaPlayer mp;
    MediaPlayer mp1;

    public static final String INFO_INTENT = "com.example.vishal_parekh_comp304lab6_ex2";


    public MusicService() {

    }
    @Override
    public void onCreate() {
        super.onCreate();
        Timer timer = new Timer();

        mp = MediaPlayer.create(this,R.raw.iphone_sound);
        mp1 = MediaPlayer.create(this,R.raw.notification_sound);
        mp.setVolume(100,100);
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        mp.start();
        mp1.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
        mp1.stop();
        mp1.release();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

}