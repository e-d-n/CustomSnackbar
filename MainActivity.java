package com.dwight.customsnackbar;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnONE;
    Button btnTWO;
    Button btnFOUR;
    Button btnSBAction;
    EditText etCount;
    CountDownTimer cdt = null;
    View subViewGroup;
    RelativeLayout RL;

    /*
     This RL code is commented out it is a way to programmatically set the height
     of a RelativeLayout the issues is the setting is in Pixels. I am sure there
     is a way to convert Pixels to dp it was a real pain to implement with out
     a lot of other code. Idea here was to keep it fast and simple and to create
     a fast and simple Snackbar that was Controllable and CUSTOM
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnONE = (Button)findViewById(R.id.btnONE);
        btnTWO = (Button)findViewById(R.id.btnTWO);
        btnFOUR = (Button)findViewById(R.id.btnFOUR);
        btnSBAction = (Button)findViewById(R.id.btnSBAction);
        etCount = (EditText)findViewById(R.id.etCount);
    }

    public void showONE(View view){
        cdt = new CountDownTimer(5000, 100) {
            //  5 sec  5000,100
            //  8 sec  8000,100
            // 10 sec 10000,100
            @Override
            public void onTick(long secsUntilFinished) {
                etCount.setText(String.valueOf(secsUntilFinished / 1000 +" sec"));
                subViewGroup = findViewById(R.id.ONE_LINE_SB);
                subViewGroup.setVisibility(View.VISIBLE);
                btnTWO.setEnabled(false);   /* We did this because two timers running at the same
                                            time makes the timer thread crazy */
                btnFOUR.setEnabled(false);
                btnSBAction.setEnabled(false);
            }

            @Override
            public void onFinish() {
                etCount.setText("Counter Done");
                btnTWO.setEnabled(true);
                btnFOUR.setEnabled(true);
                btnSBAction.setEnabled(true);
                subViewGroup.setVisibility(View.GONE);

            }
        };
        cdt.start();
    }

    public void showTWO(View view){
        cdt = new CountDownTimer(8000, 100) {

            @Override
            public void onTick(long secsUntilFinished) {
                etCount.setText(String.valueOf(secsUntilFinished / 1000 +" sec"));
                subViewGroup = findViewById(R.id.TWO_LINE_SB);
                subViewGroup.setVisibility(View.VISIBLE);
                btnONE.setEnabled(false);
                btnFOUR.setEnabled(false);
                btnSBAction.setEnabled(false);
            }

            @Override
            public void onFinish() {
                etCount.setText("Counter Done");
                btnONE.setEnabled(true);
                btnFOUR.setEnabled(true);
                btnSBAction.setEnabled(true);
                subViewGroup.setVisibility(View.GONE);
            }
        };
        cdt.start();
    }

    public void showFOUR(View view){
        cdt = new CountDownTimer(10000, 100) {

            @Override
            public void onTick(long secsUntilFinished) {
                etCount.setText(String.valueOf(secsUntilFinished / 1000 +" sec"));
                subViewGroup = findViewById(R.id.FOUR_LINE_SB);
                subViewGroup.setVisibility(View.VISIBLE);
                btnONE.setEnabled(false);
                btnTWO.setEnabled(false);
                btnSBAction.setEnabled(false);
            }

            @Override
            public void onFinish() {
                etCount.setText("Counter Done");
                btnONE.setEnabled(true);
                btnTWO.setEnabled(true);
                btnSBAction.setEnabled(true);
                subViewGroup.setVisibility(View.GONE);
            }
        };
        cdt.start();
    }

    public void makeSB(View view){
        subViewGroup = findViewById(R.id.ACTION_BTN_SNACKBAR);
        subViewGroup.setVisibility(View.VISIBLE);
        seeSBAction();
        etCount.setText("Send Money");

    }

    public void seeSBAction(){
        btnONE.setEnabled(false);
        btnTWO.setEnabled(false);
        btnFOUR.setEnabled(false);
        //RL = (RelativeLayout) findViewById(R.id.mainRL);
        //RL.getLayoutParams().height = 1426;

        Button btnAB = (Button) findViewById(R.id.btnAB);
        btnAB.setOnClickListener(new View.OnClickListener() {
        /* NOTE this Button lives inside the XML file under the subViewGroup ACTION_BTN_SNACKBAR */
        /* To implement an action when you need to define the Button and add a listener for it*/
            @Override
            public void onClick(View v) {
                btnONE.setEnabled(true);
                btnTWO.setEnabled(true);
                btnFOUR.setEnabled(true);
                etCount.setText("Money Sent");
                //RL.getLayoutParams().height = 1070;
                subViewGroup.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, PageTwoActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "No More Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
