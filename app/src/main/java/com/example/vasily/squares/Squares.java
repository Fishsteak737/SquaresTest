package com.example.vasily.squares;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class Squares extends Activity {

    TextView square1;
    int selected = 0;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squares);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_squares, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSquareClick(View view)
    {
        final TextView square = (TextView) view;
        square.setBackgroundColor(0xff00ff00);
        selected++;
        if (selected == 4) {
            selected = 0;
            TextView scoreText = (TextView) findViewById(R.id.Score);
            score++;
            scoreText.setText("Score: " + score);
        }
        TimerTask reset = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        square.setBackgroundColor(0xffff0000);
                        if(selected > 0)
                            selected--;
                    }
                });

            }
        };
        Timer timer = new Timer();
        timer.schedule(reset,2500);
    }
}
