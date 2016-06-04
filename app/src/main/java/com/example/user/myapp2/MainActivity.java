package com.example.user.myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText etName;
    EditText etWeight;
    EditText etHeight;
    Button btRun;
    TextView tvResult;
    double vWeight, vHeight;
    String rstMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("비만지수 계산 프로그램(Kaup)");

        etName = (EditText) findViewById(R.id.etName);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        btRun = (Button) findViewById(R.id.btRun);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btRun.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String vName = etName.getText().toString();
                vWeight = Double.parseDouble(etWeight.getText().toString());
                vHeight = Double.parseDouble(etHeight.getText().toString());
                int idx = (int)(vWeight/(vHeight*vHeight)*10000);

                if(idx > 30){
                    rstMsg = "비만";
                }else if(idx >= 24){
                    rstMsg = "과체중";
                }else if(idx >= 20){
                    rstMsg = "정상";
                }else if(idx >= 15){
                    rstMsg = "저체중";
                }else if(idx >= 13){
                    rstMsg = "마름";
                }else if(idx >= 10){
                    rstMsg = "영양실조";
                }else if(idx < 10){
                    rstMsg = "소모증";
                }else{
                    rstMsg = "측정불가";
                }
                tvResult.setText(rstMsg);
                return false;
            }
        });
    }

}
