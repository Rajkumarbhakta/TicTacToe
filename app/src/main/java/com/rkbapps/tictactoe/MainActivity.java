package com.rkbapps.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    TextView player;
    String ts1, ts2, ts3, ts4, ts5, ts6, ts7, ts8, ts9;
    //String winnerString;
    Button reload, exit;
    int flag = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);
        t4 = findViewById(R.id.text4);
        t5 = findViewById(R.id.text5);
        t6 = findViewById(R.id.text6);
        t7 = findViewById(R.id.text7);
        t8 = findViewById(R.id.text8);
        t9 = findViewById(R.id.text9);
        player = findViewById(R.id.textView);
        reload = findViewById(R.id.btnReload);
        exit = findViewById(R.id.btnExit);
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    public void click(View view) {
        TextView currentView = (TextView) view;

        if (currentView.getText().toString().equals("")) {
            count++;
            if (count % 2 == 0) {
                player.setText("Player X");
            } else {
                player.setText("Player O");
            }

            if (flag == 0) {
                currentView.setBackground(getDrawable(android.R.color.holo_blue_light));
                currentView.setText("X");
                flag = 1;
            } else {
                currentView.setBackground(getDrawable(android.R.color.holo_orange_light));
                currentView.setText("O");
                flag = 0;
            }
            if (count > 4) {
                ts1 = t1.getText().toString();
                ts2 = t2.getText().toString();
                ts3 = t3.getText().toString();
                ts4 = t4.getText().toString();
                ts5 = t5.getText().toString();
                ts6 = t6.getText().toString();
                ts7 = t7.getText().toString();
                ts8 = t8.getText().toString();
                ts9 = t9.getText().toString();
                if (ts1.equals(ts2) && ts2.equals(ts3) && !ts3.equals("")) {
                    //1
                    showWinner("Winner is : " + ts1);
                } else if (ts4.equals(ts5) && ts5.equals(ts6) && !ts6.equals("")) {
                    //2
                    showWinner("Winner is : " + ts4);
                } else if (ts7.equals(ts8) && ts8.equals(ts9) && !ts9.equals("")) {
                    //3
                    showWinner("Winner is : " + ts7);
                } else if (ts1.equals(ts4) && ts4.equals(ts7) && !ts7.equals("")) {
                    //4
                    showWinner("Winner is : " + ts1);
                } else if (ts2.equals(ts5) && ts5.equals(ts8) && !ts8.equals("")) {
                    //5
                    showWinner("Winner is : " + ts2);
                } else if (ts3.equals(ts6) && ts6.equals(ts9) && !ts9.equals("")) {
                    //6
                    showWinner("Winner is : " + ts1);
                } else if (ts1.equals(ts5) && ts5.equals(ts9) && !ts9.equals("")) {
                    //7
                    showWinner("Winner is : " + ts1);
                } else if (ts3.equals(ts5) && ts5.equals(ts7) && !ts7.equals("")) {
                    //8
                    showWinner("Winner is : " + ts3);
                } else {
                    if (count > 8) {
                        showWinner("Draw");
                    }
                }
            }
        }
    }

    private void showWinner(String winnerText) {
        new AlertDialog.Builder(this).setTitle(winnerText).setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent restart = new Intent(MainActivity.this, MainActivity.class);
                startActivity(restart);
                finish();
            }
        }).show();
    }
}