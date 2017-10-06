package com.dwight.customsnackbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PageTwoActivity extends AppCompatActivity {

    Button btnSCSB;
    Button btnBACK;
    String pg1;
    String pg2;
    String SBmsg;
    EditText etAbout;
    Boolean vp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagetwo);

        btnSCSB = (Button)findViewById(R.id.btnSCSB);
        btnBACK = (Button)findViewById(R.id.btnBACK);

        etAbout = (EditText)findViewById(R.id.etAbout);
        pg1 = "The implementation of the Snackbars on the first page are not flexible " +
                "the disign requires too many adjustments. Example the root layout must " +
                "have the height set and each snackbar must be the same height. Because of " +
                "this the background color of the snackbar is set to Transparent. This design does not support " +
                "swipe to dismiss because the snackbar container is a Relative Layout. Using " +
                "a timer to control view duration is clever but over use of a resource";

        pg2 ="The design of the Not A Real Custom Snackbar uses a CoordinatorLayout with a TextView and Button inside the " +
                "coordinator. We feel this design provides the best overall control when moving from " +
                "one device screen size to another device screen size as individual components are styled " +
                "with the XML file and not in the Activity file. This design does not support swipe to dismiss." +
                "Perhaps this would be a good time as a developer to ask does the swipe to dismiss add a level of " +
                "unnecessary complexity to your app. For a notice that requires a button click";

        etAbout.setText(pg1);
    }//End of onCreate

    public void onNXT(View view){
        if(vp == true){
            etAbout.setText(pg2);
            vp= false;
        }else{
            if(vp == false){
                SBmsg = "Your On Page 2 Click <- For Page 1";
                showSB();
            }
        }
    }

    public void showSB(){
        Snackbar s = Snackbar.make(findViewById(android.R.id.content), SBmsg, 1);
        View snackbarView = s.getView();
        snackbarView.setBackgroundColor(Color.WHITE);
        TextView textView = snackbarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        textView.setTextSize(22);
        textView.setMaxLines(6);
        s.setDuration(4000);
        s.show();
    }

    public void onPRV(View view) {
        if (vp == false) {
            etAbout.setText(pg1);
            vp = true;
        } else {
            if (vp == true) {
                SBmsg = "Your On Page 1 Click -> For Page 2 ";
                showSB();
            }
        }
    }

    public void customSB(View view) {

        final TextView tvSB = (TextView)findViewById(R.id.tvSB);
        tvSB.setVisibility(View.VISIBLE);
        final Button btnAB = (Button)findViewById(R.id.btnAB);
        btnAB.setVisibility(View.VISIBLE);
        final View custom;

        custom = findViewById(R.id.SB_CUSTOM);
        custom.setVisibility(View.VISIBLE);
        Snackbar.make(custom, R.string.csb_text, Snackbar.LENGTH_INDEFINITE);

            btnAB.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    tvSB.setVisibility(View.INVISIBLE);
                    btnAB.setVisibility(View.INVISIBLE);
                    custom.setVisibility(View.INVISIBLE);

                    Intent intent = new Intent(PageTwoActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }

    public void onNEXT(View v){
        Intent intent = new Intent(PageTwoActivity.this, PageThreeActivity.class);
        startActivity(intent);
    }

}//End of Class