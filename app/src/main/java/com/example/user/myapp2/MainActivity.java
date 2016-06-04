package com.example.user.myapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.myapp2.calc.CalcActivity;
import com.example.user.myapp2.kaup.KaupActivity;
import com.example.user.myapp2.login.LoginActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnKaup, btnCalc, btnLogin, btnDial,btnWeb, btnGoogle,btnSearch, btnSms,btnPhoto;

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

        ((Button) findViewById(R.id.btnKaup)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnLogin)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnDial)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnWeb)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnGoogle)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnSearch)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnSms)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnPhoto)).setOnClickListener(this);
        //btnKaup.setOnClickListener(this);
        //btnCalc.setOnClickListener(this);
        //btnLogin.setOnClickListener(this);
        //btnDial.setOnClickListener(this);
        //btnWeb.setOnClickListener(this);
        //btnGoogle.setOnClickListener(this);
        //btnSearch.setOnClickListener(this);
        //btnSms.setOnClickListener(this);
        //btnPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnKaup :
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btnCalc :
                startActivity(new Intent(this, CalcActivity.class));
                break;
            case R.id.btnLogin :
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btnDial :
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btnWeb :
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btnGoogle :
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btnSearch:
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btnSms:
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btnPhoto:
                startActivity(new Intent(this, KaupActivity.class));
                break;
        }
    }
}
