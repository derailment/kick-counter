package com.example.kick_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private Player playerOne;
    private Player playerTwo;
    private CounterStack counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = this.getIntent().getExtras();

        String playerOneName = bundle.getString("playerOneName");
        String playerTwoName = bundle.getString("playerTwoName");
        final int countDownSec = bundle.getInt("countDownSec");

        playerOne = new Player(playerOneName.equals("") ? "選手一號" : playerOneName);
        playerTwo = new Player(playerTwoName.equals("") ? "選手二號" : playerTwoName);
        TextView name_1 = (TextView) findViewById(R.id.name_1);
        name_1.setText(playerOne.getName());
        TextView name_2 = (TextView) findViewById(R.id.name_2);
        name_2.setText(playerTwo.getName());

        playerOne.setScore(0);
        playerTwo.setScore(0);

        counter = new CounterStack();

        // 取得ID為head的元件
        Button headButton = (Button) findViewById(R.id.head);
        // 按下head按鈕 觸發事件
        headButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                playerOne.addScore(3);
                counter.push(new Pair<Player, Integer>(playerOne, 3));
                // 取得ID為score的元件
                TextView result = (TextView) findViewById(R.id.score);
                result.setText(playerOne.getScore() + "");
            }
        });

        // 取得ID為head的元件
        Button bodyButton = (Button) findViewById(R.id.body);
        // 按下head按鈕 觸發事件
        bodyButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                playerOne.addScore(2);
                counter.push(new Pair<Player, Integer>(playerOne, 2));
                // 取得ID為score的元件
                TextView result = (TextView) findViewById(R.id.score);
                result.setText(playerOne.getScore() + "");
            }
        });
        // 取得ID為head的元件
        Button spinButton = (Button) findViewById(R.id.spin);
        // 按下head按鈕 觸發事件
        spinButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                playerOne.addScore(4);
                counter.push(new Pair<Player, Integer>(playerOne, 4));
                // 取得ID為score的元件
                TextView result = (TextView) findViewById(R.id.score);
                result.setText(playerOne.getScore() + "");
            }
        });

        Button spinheadButton = (Button) findViewById(R.id.spinhead);
        spinheadButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arge0) {
                playerOne.addScore(5);
                counter.push(new Pair<Player, Integer>(playerOne, 5));
                TextView result = (TextView) findViewById(R.id.score);
                result.setText(playerOne.getScore() + "");
            }
        });

        Button head2Button = (Button) findViewById(R.id.head2);
        head2Button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arge0) {
                playerTwo.addScore(3);
                counter.push(new Pair<Player, Integer>(playerTwo, 3));
                TextView result = (TextView) findViewById(R.id.score_2);
                result.setText(playerTwo.getScore() + "");
            }
        });

        Button body2Button =(Button) (TextView) findViewById(R.id.body2);
        body2Button.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View arge0){
                playerTwo.addScore(2);
                counter.push(new Pair<Player, Integer>(playerTwo, 2));
                TextView result =(TextView)findViewById(R.id.score_2);
                result.setText(playerTwo.getScore()+"");
            }
        });

        Button spin2Button=(Button)(TextView)findViewById(R.id.spin2);
        spin2Button.setOnClickListener(new Button.OnClickListener(){
            public  void onClick(View arge0){
                playerTwo.addScore(4);
                counter.push(new Pair<Player, Integer>(playerTwo, 4));
                TextView result=(TextView)findViewById(R.id.score_2);
                result.setText(playerTwo.getScore()+"");
            }
        });

        Button spinhead2Button=(Button)(TextView)findViewById(R.id.spinhead2);
        spinhead2Button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arge0){
                playerTwo.addScore(5);
                counter.push(new Pair<Player, Integer>(playerTwo, 5));
                TextView result=(TextView)findViewById(R.id.score_2);
                result.setText(playerTwo.getScore()+"");
            }
        });

        Button RT =(Button)findViewById(R.id.RT);
        RT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerOne.setScore(0);
                playerTwo.setScore(0);
		counter.clear();
                TextView result=(TextView)findViewById(R.id.score);
                TextView result2= (TextView)findViewById(R.id.score_2);
                result.setText(playerOne.getScore()+"");
                result2.setText(playerTwo.getScore()+"");
            }
        });

        Button undo =(Button)findViewById(R.id.undo);
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pair<Player, Integer> lastHit = counter.pop();

                if (lastHit != null) {
                    Player lastPlayer = lastHit.getKey();
                    Integer lastScore = lastHit.getValue();
                    if (playerOne.equals(lastPlayer)) {
                        playerOne.delScore(lastScore);
                    } else if (playerTwo.equals(lastPlayer)) {
                        playerTwo.delScore(lastScore);
                    }
                }

                TextView result=(TextView)findViewById(R.id.score);
                TextView result2= (TextView)findViewById(R.id.score_2);
                result.setText(playerOne.getScore()+"");
                result2.setText(playerTwo.getScore()+"");

            }
        });

        Button timerButton =(Button)findViewById(R.id.timer_button);
        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(countDownSec * 1000, 1000) {

                    TextView countDownText = (TextView)findViewById(R.id.countdown);

                    public void onTick(long millisUntilFinished) {

                        NumberFormat f = new DecimalFormat("00");
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;

                        countDownText.setText( f.format(min) + ":" + f.format(sec));
                    }
                    public void onFinish() {
                        countDownText.setText("Time's Up !");
                    }
                }.start();

            }
        });

    }}
