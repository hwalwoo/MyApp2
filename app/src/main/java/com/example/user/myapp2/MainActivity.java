package com.example.user.myapp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnKaup;
    Button btnCalc;
    Button btnLogin;
    Button btnDial;
    Button btnWeb;
    Button btnGoogle;
    Button btnSearch;
    Button btnSms;
    Button btnPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKaup = (Button) findViewById(R.id.btnKaup);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnDial = (Button) findViewById(R.id.btnDial);
        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnGoogle = (Button) findViewById(R.id.btnGoogle);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSms = (Button) findViewById(R.id.btnSms);
        btnPhoto = (Button) findViewById(R.id.btnPhoto);

        btnKaup.setOnClickListener(this);
        btnCalc.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnSms.setOnClickListener(this);
        btnPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnKaup : break;
            case R.id.btnCalc : break;
            case R.id.btnLogin : break;
            case R.id.btnDial : break;
            case R.id.btnWeb : break;
            case R.id.btnGoogle : break;
            case R.id.btnSearch: break;
            case R.id.btnSms: break;
            case R.id.btnPhoto: break;
        }
    }
}
