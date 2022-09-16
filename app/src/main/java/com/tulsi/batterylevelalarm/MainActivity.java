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
        mWaveLoadingView.setShapeType(WaveLoadingView.ShapeType.CIRCLE);
        //mWaveLoadingView.setTopTitle("Top Title");
        mWaveLoadingView.setCenterTitleColor(Color.GRAY);
        mWaveLoadingView.setCenterTitle("90");
        mWaveLoadingView.setBottomTitleSize(18);
        mWaveLoadingView.setProgressValue(90);
        mWaveLoadingView.setBorderWidth(10);
        mWaveLoadingView.setAmplitudeRatio(60);
        mWaveLoadingView.setWaveColor(Color.GRAY);
        mWaveLoadingView.setBorderColor(Color.GRAY);
        mWaveLoadingView.setTopTitleStrokeColor(Color.BLUE);
        mWaveLoadingView.setTopTitleStrokeWidth(3);
        mWaveLoadingView.setAnimDuration(0);
        mWaveLoadingView.pauseAnimation();
//        mWaveLoadingView.resumeAnimation();
//        mWaveLoadingView.cancelAnimation();
//        mWaveLoadingView.startAnimation();
    }
}