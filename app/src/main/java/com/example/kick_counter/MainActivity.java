package com.example.kick_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player playerOne = new Player();
        playerOne.setScore(0);

        Player playerTwo = new Player();
        playerTwo.setScore(0);


        // 取得ID為head的元件
        Button headButton = (Button) findViewById(R.id.head);
        // 按下head按鈕 觸發事件
        headButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                playerOne.addScore(3);
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
                // 取得ID為score的元件
                TextView result = (TextView) findViewById(R.id.score);
                result.setText(playerOne.getScore() + "");
            }
        });

        Button spinheadButton = (Button) findViewById(R.id.spinhead);
        spinheadButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arge0) {

                playerOne.addScore(5);
                TextView result = (TextView) findViewById(R.id.score);
                result.setText(playerOne.getScore() + "");
            }
        });

        Button head2Button = (Button) findViewById(R.id.head2);
        head2Button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arge0) {

                playerTwo.addScore(3);
                TextView result = (TextView) findViewById(R.id.score_2);
                result.setText(playerTwo.getScore() + "");
            }
        });

        Button body2Button =(Button) (TextView) findViewById(R.id.body2);
        body2Button.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View arge0){
                playerTwo.addScore(2);
                TextView result =(TextView)findViewById(R.id.score_2);
                result.setText(playerTwo.getScore()+"");
            }
        });
        Button spin2Button=(Button)(TextView)findViewById(R.id.spin2);
        spin2Button.setOnClickListener(new Button.OnClickListener(){
            public  void onClick(View arge0){
                playerTwo.addScore(4);
                TextView result=(TextView)findViewById(R.id.score_2);
                result.setText(playerTwo.getScore()+"");
            }
        });
        Button spinhead2Button=(Button)(TextView)findViewById(R.id.spinhead2);
        spinhead2Button.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arge0){
                playerTwo.addScore(5);
                TextView result=(TextView)findViewById(R.id.score_2);
                result.setText(playerTwo.getScore()+"");
            }
        });





    }}
