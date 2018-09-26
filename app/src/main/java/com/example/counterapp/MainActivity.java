package com.example.counterapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mycounter;
    Counter ct;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mycounter = findViewById(R.id.txt_count);

    }

    public void start_btn(View view) {
        starttime();
    }


    public void stop_btn(View view) {
        ct.cancel();
    }

    void starttime() {
        ct = new Counter(10000, 1000);
        ct.start();
    }

    class Counter extends CountDownTimer {


        public Counter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisfinished) {
            mycounter.setText(String.valueOf(count));
            count++;
        }

        @Override
        public void onFinish() {
            starttime();
        }
    }
}

