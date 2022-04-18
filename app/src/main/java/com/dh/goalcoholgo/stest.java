package com.dh.goalcoholgo;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class stest extends AppCompatActivity implements SensorEventListener {


    float x_axis;
    float y_axis;
    float z_axis;
    float x_aggregate = 0.0f;
    float y_aggregate = 0.0f;
    float z_aggregate = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceSatte) {
        super.onCreate(savedInstanceSatte);
        setContentView((R.layout.activity_stest));

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager != null) {
            Sensor accelsensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accelsensor!=null){
                sensorManager.registerListener(this, accelsensor, SensorManager.SENSOR_DELAY_NORMAL);
            }

        }
        else {
            Toast.makeText(this,"Sensor service not detected",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            x_axis = event.values[0];
            y_axis = event.values[1];
            z_axis = event.values[2];
            ((TextView)findViewById(R.id.txtValues)).setText("X: "+ event.values[0] + ", Y: "+ event.values[1]+ ", Z: "+ event.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //null
    }

    public void stest_button(View view) {
        ((TextView)findViewById(R.id.txtValues7)).setText("Result: Starting");

        CountDownTimer Count = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                long str = millisUntilFinished / 1000;
                String TimeFinished = String.valueOf(str);
                x_aggregate = x_aggregate + x_axis;
                y_aggregate = y_aggregate + y_axis;
                z_aggregate = z_aggregate + z_axis;
                ((TextView)findViewById(R.id.txtValues7)).setText("Result: " +TimeFinished);
    //            ((TextView)findViewById(R.id.txtValues7)).setText(String.valueOf(y_axis) + " " + String.valueOf(y_aggregate));
            }
            public void onFinish() {

                x_aggregate = x_aggregate/10;
                y_aggregate = y_aggregate/10;
                z_aggregate = z_aggregate/10;
                if(y_aggregate < 9 || y_aggregate > 10.5f) {
                    ((TextView)findViewById(R.id.txtValues7)).setText("Result: Unsteady");
                    x_aggregate = 0.0f;
                    y_aggregate = 0.0f;
                    z_aggregate = 0.0f;
                    //Toast.makeText(this,"Take a cab",Toast.LENGTH_SHORT).show();
                }
                else{
                    x_aggregate = 0.0f;
                    y_aggregate = 0.0f;
                    z_aggregate = 0.0f;
                    ((TextView)findViewById(R.id.txtValues7)).setText("Result: Steady");
                }
                //((TextView)findViewById(R.id.txtValues7)).setText(String.valueOf(y_aggregate));
            }
        };
        Count.start();
    }
}
