package com.example.sensorapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sensorapp.sensor.AccelerometerManager;

public class MainActivity extends AppCompatActivity {

    private TextView tvX, tvY, tvZ;
    private AccelerometerManager accelerometerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvX = findViewById(R.id.tvX);
        tvY = findViewById(R.id.tvY);
        tvZ = findViewById(R.id.tvZ);

        accelerometerManager = new AccelerometerManager(this, new AccelerometerManager.OnSensorDataChanged() {
            @Override
            public void onChanged(float x, float y, float z) {
                tvX.setText("X: " + x);
                tvY.setText("Y: " + y);
                tvZ.setText("Z: " + z);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        accelerometerManager.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        accelerometerManager.stop();
    }
}