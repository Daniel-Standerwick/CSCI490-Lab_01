package com.example.simpletimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CountDownTimer myCountDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;
    private final long startTime = 50 * 1000;
    final long interval = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startB = (Button) this.findViewById(R.id.button);
        startB.setOnClickListener(this);
        text = this.findViewById(R.id.timer);
        timeElapsedView = this.findViewById(R.id.timeElapsed);
        myCountDownTimer = new CountDownTimer(startTime, interval);
        String textToReturn = (text.getText() + String.valueOf(startTime));
        text.setText(textToReturn);
    }


    @Override
    public void onClick(View view)
    {
        if(!timerHasStarted)
        {

            myCountDownTimer.start();
            timerHasStarted = true;
            startB.setText(R.string.Stop);

        }
        else
        {

            myCountDownTimer.cancel();
            timerHasStarted = false;
            startB.setText(R.string.Reset);
        }

    }


    public class CountDownTimer extends android.os.CountDownTimer {

        public CountDownTimer(long millisInFuture, long countDownInterval) {

            super(millisInFuture, countDownInterval);

        }

        public void onFinish() {

            text.setText(R.string.Timesup);
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));

        }

        public void onTick(long millisUntilFinished)
        {

            text.setText("Time remain: " + String.valueOf(startTime));
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedView.setText("Time Elapsed: " + String.valueOf(timeElapsed));

        }

    }

}

