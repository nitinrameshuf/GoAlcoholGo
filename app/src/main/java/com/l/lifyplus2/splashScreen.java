package com.l.lifyplus2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import static java.lang.Thread.sleep;
import android.os.PowerManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

public class splashScreen extends AppCompatActivity {
    ImageView SplashImage;

    @SuppressLint("BatteryLife")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SplashImage= findViewById(R.id.imagesplash);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.myanimation);
        SplashImage.startAnimation(myanim);

        Thread mythread =new Thread(() -> {
            try {
                sleep(5000);
                Intent i=new Intent(splashScreen.this,RegisterActivity.class);
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        mythread.start();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent();
            String packageName = getPackageName();
            PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setData(Uri.parse("package:" + packageName));
                startActivity(intent);
            }
        }
    }

}