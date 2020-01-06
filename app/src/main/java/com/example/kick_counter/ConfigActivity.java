package com.example.kick_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Spinner;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Button enterButton = (Button)findViewById(R.id.enter_button);
        enterButton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText playerOneName = (EditText)findViewById(R.id.player_one_edit);


                EditText playerTwoName = (EditText)findViewById(R.id.player_two_edit);
                playerTwoName.getText().toString();

                Spinner spinner = (Spinner) findViewById(R.id.timer_spinner);


                // new一個intent物件，並指定Activity切換的class
                Intent intent = new Intent();
                intent.setClass(ConfigActivity.this, MainActivity.class);

                // new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();
                bundle.putString("playerOneName",playerOneName.getText().toString());
                bundle.putString("playerTwoName",playerTwoName.getText().toString());
                bundle.putInt("countDownSec", Integer.parseInt(spinner.getSelectedItem().toString()));

                // 將Bundle物件assign給intent
                intent.putExtras(bundle);

                // 切換Activity
                startActivity(intent);
            }

        });

    }
}
