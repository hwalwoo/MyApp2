package com.example.user.myapp2.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.myapp2.R;
import com.example.user.myapp2.member.MemberBean;
import com.example.user.myapp2.member.MemberDAO;

public class Login2Activity extends Activity implements View.OnClickListener{
    TextView tvLoginRt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        MemberBean member = new MemberBean();
        MemberDAO memberDAO = new MemberDAO(this.getApplicationContext());

        tvLoginRt = (TextView) findViewById(R.id.tvLoginRt);
        ((Button)findViewById(R.id.btnLogin2)).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        tvLoginRt.setText("로그인 결과 : 성공");
    }
}
