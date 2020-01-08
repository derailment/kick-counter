package com.example.kick_counter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // 選手
    private Player playerOne;
    private Player playerTwo;

    // 攻擊紀錄器
    private CounterStack counter;

    // 倒數計時器
    private SandClock timer;
    private boolean hasTimerStarted = false;
    private int countDownSec;
    private TextView countDownText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 取得上一頁的傳遞資料
        Bundle bundle = this.getIntent().getExtras();

        // 取得倒數秒數，再創建計時器實例
        countDownSec = bundle.getInt("countDownSec");
        countDownText = (TextView)findViewById(R.id.timer);
        resetSandClock();

        // 取得選手名字，再創建選手，並寫到畫面的文字元素
        String playerOneName = bundle.getString("playerOneName");
        String playerTwoName = bundle.getString("playerTwoName");
        playerOne = new Player(playerOneName.equals("") ? "選手一號" : playerOneName);
        playerTwo = new Player(playerTwoName.equals("") ? "選手二號" : playerTwoName);
        TextView playerOneText = (TextView) findViewById(R.id.player_one_name);
        playerOneText.setText(playerOne.getName());
        TextView playerTwoText = (TextView) findViewById(R.id.player_two_name);
        playerTwoText.setText(playerTwo.getName());

        // 選手得分歸零
        playerOne.setScore(0);
        playerTwo.setScore(0);

        // 創建攻擊紀錄器
        counter = new CounterStack();

        Button playerOneTrunkButton = (Button) findViewById(R.id.player_one_trunk);
        playerOneTrunkButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                playerOne.addScore(2);
                counter.push(new Pair<Player, Integer>(playerOne, 2));
                TextView playerScore = (TextView) findViewById(R.id.player_one_score);
                playerScore.setText(playerOne.getScore() + "");
            }
        });

        Button playerOneFaceButton = (Button) findViewById(R.id.player_one_face);
        playerOneFaceButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                playerOne.addScore(3);
                counter.push(new Pair<Player, Integer>(playerOne, 3));
                TextView playerScore = (TextView) findViewById(R.id.player_one_score);
                playerScore.setText(playerOne.getScore() + "");
            }
        });

        Button playerOneTrunkSpinButton = (Button) findViewById(R.id.player_one_trunk_spin);
        playerOneTrunkSpinButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                playerOne.addScore(4);
                counter.push(new Pair<Player, Integer>(playerOne, 4));
                TextView playerScore = (TextView) findViewById(R.id.player_one_score);
                playerScore.setText(playerOne.getScore() + "");
            }
        });

        Button playerOneFaceSpinButton = (Button) findViewById(R.id.player_one_face_spin);
        playerOneFaceSpinButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arge0) {
                playerOne.addScore(5);
                counter.push(new Pair<Player, Integer>(playerOne, 5));
                TextView playerScore = (TextView) findViewById(R.id.player_one_score);
                playerScore.setText(playerOne.getScore() + "");
            }
        });

        Button playerTwoTrunkButton =(Button) (TextView) findViewById(R.id.player_two_trunk);
        playerTwoTrunkButton.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View arge0){
                playerTwo.addScore(2);
                counter.push(new Pair<Player, Integer>(playerTwo, 2));
                TextView playerScore =(TextView)findViewById(R.id.player_two_score);
                playerScore.setText(playerTwo.getScore()+"");
            }
        });

        Button playerTwoFaceButton = (Button) findViewById(R.id.player_two_face);
        playerTwoFaceButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arge0) {
                playerTwo.addScore(3);
                counter.push(new Pair<Player, Integer>(playerTwo, 3));
                TextView playerScore = (TextView) findViewById(R.id.player_two_score);
                playerScore.setText(playerTwo.getScore() + "");
            }
        });

        Button playerTwoTrunkSpinButton=(Button)(TextView)findViewById(R.id.player_two_trunk_spin);
        playerTwoTrunkSpinButton.setOnClickListener(new Button.OnClickListener(){
            public  void onClick(View arge0){
                playerTwo.addScore(4);
                counter.push(new Pair<Player, Integer>(playerTwo, 4));
                TextView playerScore = (TextView)findViewById(R.id.player_two_score);
                playerScore.setText(playerTwo.getScore()+"");
            }
        });

        Button playerTwoFaceSpinButton=(Button)(TextView)findViewById(R.id.player_two_face_spin);
        playerTwoFaceSpinButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arge0){
                playerTwo.addScore(5);
                counter.push(new Pair<Player, Integer>(playerTwo, 5));
                TextView playerScore = (TextView)findViewById(R.id.player_two_score);
                playerScore.setText(playerTwo.getScore()+"");
            }
        });

        Button resetButton =(Button)findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 重置倒數計時器
                resetSandClock();

                // 重置攻擊紀錄器
                counter.clear();

                // 重置選手得分
                playerOne.setScore(0);
                playerTwo.setScore(0);
                TextView playerOneScore = (TextView)findViewById(R.id.player_one_score);
                TextView playerTwoScore = (TextView)findViewById(R.id.player_two_score);
                playerOneScore.setText(playerOne.getScore()+"");
                playerTwoScore.setText(playerTwo.getScore()+"");

            }
        });

        Button undoButton =(Button)findViewById(R.id.undo_button);
        undoButton.setOnClickListener(new View.OnClickListener() {
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
                TextView playerOneScore = (TextView)findViewById(R.id.player_one_score);
                TextView playerTwoScore = (TextView)findViewById(R.id.player_two_score);
                playerOneScore.setText(playerOne.getScore()+"");
                playerTwoScore.setText(playerTwo.getScore()+"");
            }
        });

        final Button countDownButton =(Button)findViewById(R.id.countdown_button);
        countDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!hasTimerStarted) {
                    timer = timer.restart();
                    hasTimerStarted = true;
                    countDownButton.setText("暫停");
                } else {
                    timer.pause();
                    hasTimerStarted = false;
                    countDownButton.setText("繼續");
                }
            }
        });

    }

    protected void resetSandClock() {
        if (this.timer != null) {
            this.timer.pause();
        }
        // 單位: 毫秒
        this.timer = new SandClock(countDownSec * 1000, 1000, countDownText);
        this.hasTimerStarted = false;
        NumberFormat f = new DecimalFormat("00");
        long min = (countDownSec * 1000 / 60000) % 60;
        long sec = (countDownSec * 1000 / 1000) % 60;
        this.countDownText.setText(f.format(min) + ":" + f.format(sec));
        Button countDownButton = (Button)findViewById(R.id.countdown_button);
        countDownButton.setText("開始");

    }

}
