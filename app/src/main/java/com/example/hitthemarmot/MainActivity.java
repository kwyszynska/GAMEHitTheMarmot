package com.example.hitthemarmot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mTime;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();

    Handler handler1 = new Handler();
    List<View> marmots = new ArrayList<View>();
    int marmot = 5;
    Button StartButton;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        marmots.add(findViewById(R.id.m1));
        marmots.add(findViewById(R.id.m2));
        marmots.add(findViewById(R.id.m3));
        marmots.add(findViewById(R.id.m4));
        marmots.add(findViewById(R.id.m5));
        marmots.add(findViewById(R.id.m6));
        marmots.add(findViewById(R.id.m7));
        marmots.add(findViewById(R.id.m8));
        marmots.add(findViewById(R.id.m9));

        for (View v: marmots)
        {
          v.setVisibility(View.INVISIBLE);
        }

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mTime = (TextView) findViewById(R.id.Time);




    }

    public void MarmotOnClick(View view) throws InterruptedException {
        this.score++;
        view.setVisibility(View.INVISIBLE);
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText(String.valueOf(score));
    }

    public void StartGame(View view) throws InterruptedException {
        Button startButton = findViewById(R.id.StartButton);
        startButton.setVisibility(View.INVISIBLE);


        Random rand = new Random();

        int max = 100;
        int current = 0;
        score = 0;

        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText(String.valueOf(score));

        do {
            handler1.postDelayed(new Runnable() {

                @Override
                public void run() {
                    ProgressBar simpleProgressBar=(ProgressBar) findViewById(R.id.progressBar);
                    mProgressBar.setMax(100);
                    mProgressBar.setProgress(mProgressStatus+1);
                    mProgressStatus = mProgressStatus+1;
                    int i = rand.nextInt(9);
                    View marmot = marmots.get(i);

                    if(marmot.getVisibility() == View.VISIBLE) {
                        marmot.setVisibility(View.INVISIBLE);
                    } else if (marmot.getVisibility() == View.INVISIBLE) {
                        marmot.setVisibility(View.VISIBLE);
                    }

                }
            }, 300 * current);
            current++;
            mProgressBar.setVisibility(View.VISIBLE);


        } while(current < max);
        startButton.setVisibility(View.VISIBLE);

        //mProgressBar.setVisibility(View.INVISIBLE);

    }

}