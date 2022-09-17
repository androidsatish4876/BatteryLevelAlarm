package com.tulsi.batterylevelalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;

import com.tulsi.batterylevelalarm.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {
    WaveLoadingView mWaveLoadingView;
    private Ringtone ringtone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWaveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        mWaveLoadingView.setTopTitle("");
        mWaveLoadingView.setCenterTitleColor(Color.WHITE);

        mWaveLoadingView.setBottomTitleSize(18);
        mWaveLoadingView.setProgressValue(0);
        mWaveLoadingView.setBorderWidth(5);
        mWaveLoadingView.setAmplitudeRatio(100);
        mWaveLoadingView.setWaveColor(Color.parseColor("#B2DFDB"));
        mWaveLoadingView.setBorderColor(Color.parseColor("#4CAF50"));
        mWaveLoadingView.setTopTitleStrokeColor(Color.WHITE);
        mWaveLoadingView.setTopTitleStrokeWidth(3);
        mWaveLoadingView.setWaterLevelRatio(0.2f);
        mWaveLoadingView.setAnimDuration(3000);
        mWaveLoadingView.pauseAnimation();
        mWaveLoadingView.resumeAnimation();
        mWaveLoadingView.cancelAnimation();
        mWaveLoadingView.startAnimation();


        ringtone= RingtoneManager.getRingtone(getApplicationContext(),RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

        BroadcastReceiver broadcastReceiverBattery= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Integer integerBatteryLevel=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                //textView.setText(.toString());
                mWaveLoadingView.setCenterTitle(integerBatteryLevel+"%");
                mWaveLoadingView.setProgressValue(integerBatteryLevel);
                if(integerBatteryLevel>99||integerBatteryLevel<10)
                {
                    ringtone.play();
                }
            }
        };
        registerReceiver(broadcastReceiverBattery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    public void stopAlarm(View view) {
        ringtone.stop();
    }
}