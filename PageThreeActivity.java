package com.dwight.customsnackbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PageThreeActivity extends AppCompatActivity {

    Button btnRPSB;
    Button btnRASB;
    String pg3;
    EditText etAbout;

    private Context context = this;
    private CoordinatorLayout myLayout;
    Snackbar sb = null;
    private CoordinatorLayout noActLayout;
    Snackbar sbNoAct = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagethree);

        btnRPSB = (Button)findViewById(R.id.btnRPSB);
        btnRASB = (Button)findViewById(R.id.btnRASB);
        etAbout = (EditText)findViewById(R.id.etAbout);
        pg3 ="These two Snackbars Plain and Plain with an Action Button utlize a single CoordinatorLayout " +
                "in the cooresponding Activity XML file. All styling of these snackbars are managed by declaring a View in the " +
                "routine that creates the snackbar with the MAKE method. While styling is adequate when moveing from " +
                "one device screen size to another this paradigm is very inflexable. Using a CoordinatorLayout " +
                "this design does support swipe to dismiss. Since the author sees very little value in this " +
                "property we still favor the Snackbar design pattern on Page two of this demo application. ";

        etAbout.setText(pg3);
    }

    public void onPLAIN(View view){

        noActLayout = (CoordinatorLayout)findViewById(R.id.USE_ME_TWICE);

        sbNoAct = Snackbar.make(noActLayout,R.string.real_csb_noaction_text,1);// any interger will make it happy
        sbNoAct.setDuration(4000);// 4 sec // OR Snackbar.LENGTH_LONG matters NOT you are setting duration here

        View sbView = sbNoAct.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.color_lightBlue));
        TextView textViewNoAct = sbView.findViewById(android.support.design.R.id.snackbar_text);
        //set text color
        textViewNoAct.setTextColor(ContextCompat.getColor(this,R.color.color_White));
        textViewNoAct.setMaxLines(10);
        textViewNoAct.setTextSize(20);
        //increase max lines of text in snackbar. default is 2.
        sbNoAct.show();
    }

    public void onWithAct(View view){

        myLayout = (CoordinatorLayout) findViewById(R.id.USE_ME_TWICE);

        sb = Snackbar.make(myLayout, R.string.real_csb_text, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.real_csb_action, myOnClickListener)
                .setActionTextColor(ContextCompat.getColor(context, R.color.color_Red));

        View sbView = sb.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.color_White));
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        //set text color
        textView.setTextColor(ContextCompat.getColor(this,R.color.color_deepBlue));
        textView.setTextSize(20);
        //increase max lines of text in snackbar. default is 2.
        textView.setMaxLines(10);
        // NOTE new View
        TextView textAction = sbView.findViewById(android.support.design.R.id.snackbar_action);
        //set Action text color
        textAction.setTextColor(ContextCompat.getColor(this,R.color.color_Red));
        textAction.setTextSize(20);
        sb.show();
    }
        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sb.dismiss();
                System.out.println("=== I WAS DISMISSED OR SENT TO MainActivity===");
                // OR use and Intent to go somewhere have a nice trip
                Intent intent = new Intent(PageThreeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }
