package com.example.sensorapp.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerometerManager implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private OnSensorDataChanged listener;

    public interface OnSensorDataChanged {
        void onChanged(float x, float y, float z);
    }

    public AccelerometerManager(Context context, OnSensorDataChanged listener) {
        this.listener = listener;
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void start() {
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void stop() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (listener != null) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            listener.onChanged(x, y, z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used
    }
}
