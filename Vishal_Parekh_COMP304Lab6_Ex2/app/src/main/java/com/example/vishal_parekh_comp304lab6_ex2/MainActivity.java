package com.example.vishal_parekh_comp304lab6_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    Button buttonStart;
    Button buttonStop;

    public static final String INFO_INTENT = "com.example.vishal_parekh_comp304lab6_ex2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        buttonStart = (Button) findViewById(R.id.btnStartService);
        buttonStop = (Button) findViewById(R.id.btnStopService);
    }
    public void startService(View view) {

        startService(new Intent(getBaseContext(), MusicService.class));


        Intent intent = getIntent();
        String name = intent.getStringExtra(INFO_INTENT);
        textView.setText(name);

    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(),
                MusicService.class));
    }

    public BroadcastReceiver receiver = new BroadcastReceiver() {
        //@Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(MainActivity.INFO_INTENT)) {
                String info = intent.getStringExtra(INFO_INTENT);
                textView.setText(info);
            }
        }
    };






    public void onResume()
    {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(INFO_INTENT));

    }


}

