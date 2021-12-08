package com.example.refillsystem.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.refillsystem.R;
import com.google.firebase.database.annotations.NotNull;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class WaitForRefillFragment extends Fragment {

    ProgressBar orderProgress;
    TextView ordertimer;
    CountDownTimer countDownTimer;
    int count = 0;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wait_for_refill, container, false);
        orderProgress = view.findViewById(R.id.order_progress);
        ordertimer = view.findViewById(R.id.time_view);
        orderProgress.setProgress(0);
        int random = new Random().nextInt(3600001) + 120000;
        countDownTimer = new CountDownTimer(random, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                String hour = timeFormatter(millisUntilFinished);
                ordertimer.setText("Your bottle should be filled in" + hour);
                if (count < random) {
                    count++;
                    orderProgress.incrementProgressBy(count);
                }
            }

            @Override
            public void onFinish() {
                ordertimer.setText("Bottle filled!");
            }
        };

        countDownTimer.start();
        return view;

    }

    private String timeFormatter(long milliSeconds)
    {
        String hour = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hour;
    }
    }