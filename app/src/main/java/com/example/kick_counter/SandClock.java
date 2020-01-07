package com.example.kick_counter;

import android.os.CountDownTimer;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SandClock extends CountDownTimer {

    private long remainingTime;
    private long interval;
    private TextView countDownText;

    public SandClock(long remainingTime, long interval, TextView countDownText) {
        super(remainingTime, interval);
        this.remainingTime = remainingTime;
        this.interval = interval;
        this.countDownText = countDownText;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        this.remainingTime = millisUntilFinished;
        NumberFormat f = new DecimalFormat("00");
        long min = (millisUntilFinished / 60000) % 60;
        long sec = (millisUntilFinished / 1000) % 60;
        this.countDownText.setText( f.format(min) + ":" + f.format(sec));
    }

    @Override
    public void onFinish() {
        this.countDownText.setText("Time's Up!");
    }

    public void pause() {
        this.cancel();
    }

    public SandClock restart() {
        SandClock timer = new SandClock(this.remainingTime, this.interval, this.countDownText);
        timer.start();
        return timer;
    }

}
