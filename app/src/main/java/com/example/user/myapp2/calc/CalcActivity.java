package com.example.user.myapp2.calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp2.MainActivity;
import com.example.user.myapp2.R;
import com.example.user.myapp2.login.LoginActivity;

public class CalcActivity extends Activity implements View.OnClickListener{

    CalcService service;

    EditText etVal1;
    EditText etVal2;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5, btnMain;

    TextView tvResult;

    int num1, num2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        setTitle("==계산기 프로그램==");

        service = new CalcServiceImpl();

        etVal1 = (EditText) findViewById(R.id.etVal1);
        etVal2 = (EditText) findViewById(R.id.etVal2);

        //btn1 = (Button) findViewById(R.id.btn1);
        //btn2 = (Button) findViewById(R.id.btn2);
        //btn3 = (Button) findViewById(R.id.btn3);
        //btn4 = (Button) findViewById(R.id.btn4);
        //btn5 = (Button) findViewById(R.id.btn5);
        //btnMain = (Button) findViewById(R.id.btnMain);

        tvResult = (TextView) findViewById(R.id.tvResult);

        ((Button) findViewById(R.id.btn1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnMain)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

       if(v.getId() == R.id.btnMain){
           startActivity(new Intent(this, MainActivity.class));
       }else{
           num1 = Integer.parseInt(etVal1.getText().toString());
           num2 = Integer.parseInt(etVal2.getText().toString());

           switch (v.getId()){
               case R.id.btn1: result = service.plus(num1, num2); break;
               case R.id.btn2: result = service.minus(num1, num2); break;
               case R.id.btn3: result = service.multi(num1, num2); break;
               case R.id.btn4: result = service.divide(num1, num2); break;
               case R.id.btn5: result = service.nmg(num1, num2); break;
           }
           tvResult.setText(result+"");
       }

    }
}
