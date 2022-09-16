package com.tulsi.batterylevelalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.tulsi.batterylevelalarm.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {
    WaveLoadingView mWaveLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWaveLoadingView = (WaveLoadingView) findViewById(R.id.waveLoadingView);
        mWaveLoadingView.setTopTitle("");
        mWaveLoadingView.setCenterTitleColor(Color.WHITE);
        mWaveLoadingView.setCenterTitle(10+"%");
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
        mWaveLoadingView.setProgressValue(50);
    }
}