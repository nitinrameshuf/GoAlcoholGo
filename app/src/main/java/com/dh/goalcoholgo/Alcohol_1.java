package com.dh.goalcoholgo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.dh.goalcoholgo.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import cn.iwgang.countdownview.CountdownView;

    public class Alcohol_1 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
        //TextView tvSplash;
        Button btnstop;
        ImageView icanchor;
        Animation roundingalone;
        FirebaseDatabase database;
        DatabaseReference reference;
        private Button Attempt;
        private Button Reset;
        private TextView counterTxt;
        private int counter;

        private View.OnClickListener clickListener = v -> {
            switch (v.getId()) {

                case R.id.Attempt:
                    AttemptCounter();
                    break;
                case R.id.Reset:
                    initCounter();
                    break;
            }


        };

        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String pickerDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
            TextView tvDatePicker = findViewById(R.id.textViewContent);
            CountdownView myCountdownView = findViewById(R.id.countdownView);

            try {
                tvDatePicker.setText(pickerDateString);
                Date now = new Date();
                long currentDate = now.getTime();
                long pickerDate = calendar.getTimeInMillis();
                long countDownToPickerDate = pickerDate - currentDate;
                myCountdownView.start(countDownToPickerDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
            btnstop.setOnClickListener(v -> {
                // passing Animation

                // Stop time
                myCountdownView.stop();
                Toast.makeText(this, "Relapse doesnot mean you fail , Not trying again means You fail", Toast.LENGTH_SHORT).show();
                icanchor.startAnimation(roundingalone);
            });

        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_alcohol_1);
            //firebase
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("Category");
            //recyclerView

            //tvSplash = findViewById(R.id.tvsplash);


            btnstop = findViewById(R.id.btnstop);
            icanchor = findViewById(R.id.icanchor);
            Attempt = findViewById(R.id.Attempt);
            Button btnDatePicker = findViewById(R.id.btnDatePicker);
            Attempt.setOnClickListener(clickListener);
            Reset = findViewById(R.id.Reset);
            Reset.setOnClickListener(clickListener);
            counterTxt = (TextView) findViewById(R.id.textView);


            // load animations
            roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);
            //import font
            Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");


            // Customize font
            //tvSplash.setTypeface(MRegular);
            btnstop.setTypeface(MRegular);
            Reset.setTypeface(MRegular);
            Attempt.setTypeface(MRegular);
            btnDatePicker.setOnClickListener(v -> {
                icanchor.startAnimation(roundingalone);
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(), "date picker");


            });
            initCounter();

        }

        public void Progress(View view) {

            Intent intent = new Intent(this, Progress.class);
            startActivity(intent);
        }

        public void Panic(View view) {

            Intent intent = new Intent(this, Panic.class);
            startActivity(intent);
        }

        public void stest(View view) {

            Intent intent = new Intent(this, stest.class);
            startActivity(intent);
        }

        @SuppressLint("SetTextI18n")
        private void initCounter() {
            counter = 0;
            counterTxt.setText(counter + "");
        }


        @SuppressLint("SetTextI18n")
        private void AttemptCounter() {
            counter++;
            Toast.makeText(this, "Don't give up You can do it try again...", Toast.LENGTH_SHORT).show();
            counterTxt.setText(counter + "");
        }

        public void Alert(View view) {

            Intent intent = new Intent(this, Alert.class);
            startActivity(intent);
        }
        public void logout(View view){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }
    }