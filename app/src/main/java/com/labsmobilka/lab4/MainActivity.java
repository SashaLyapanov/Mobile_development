package com.labsmobilka.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {

    TextView accelerometerX;
    TextView accelerometerY;
    TextView accelerometerZ;
    TextView magneticX;
    TextView magneticY;
    TextView magneticZ;
    TextView proximity;
    TextView light;
    Button goToCompas;
    SensorManager sensorManager;
    Sensor accelerometerSensor;
    Sensor proximitySensor;
    Sensor magneticSensor;
    Sensor lightSensor;
    Float value;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToCompas = (Button) findViewById(R.id.goToCompas);
        accelerometerX = (TextView) findViewById(R.id.acc1);
        accelerometerY = (TextView) findViewById(R.id.acc2);
        accelerometerZ = (TextView) findViewById(R.id.acc3);
        magneticX = (TextView) findViewById(R.id.mag1);
        magneticY = (TextView) findViewById(R.id.mag2);
        magneticZ = (TextView) findViewById(R.id.mag3);
        light = (TextView) findViewById(R.id.light1);
        proximity = (TextView) findViewById(R.id.prox1);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        goToCompas.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelerometerX.setText(Float.toString(sensorEvent.values[0]));
            accelerometerY.setText(Float.toString(sensorEvent.values[1]));
            accelerometerZ.setText(Float.toString(sensorEvent.values[2]));
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            magneticX.setText(Float.toString(sensorEvent.values[0]));
            magneticY.setText(Float.toString(sensorEvent.values[1]));
            magneticZ.setText(Float.toString(sensorEvent.values[2]));
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            proximity.setText(Float.toString(sensorEvent.values[0]));
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            light.setText(Float.toString(sensorEvent.values[0]));
            value = sensorEvent.values[0];
            WindowManager.LayoutParams layoutParams =getWindow().getAttributes();
            layoutParams.screenBrightness = (value / 100);
            getWindow().setAttributes(layoutParams);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magneticSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this, accelerometerSensor);
        sensorManager.unregisterListener(this, magneticSensor);
        sensorManager.unregisterListener(this, proximitySensor);
        sensorManager.unregisterListener(this, lightSensor);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.goToCompas) {
            Intent intent = new Intent(this, Compas.class);
            startActivity(intent);
        }
    }
}