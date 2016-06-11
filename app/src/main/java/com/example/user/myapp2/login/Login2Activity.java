package com.example.user.myapp2.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp2.R;
import com.example.user.myapp2.member.MemberBean;
import com.example.user.myapp2.member.MemberDAO;

public class Login2Activity extends Activity implements View.OnClickListener{
    TextView tvLoginRt;
    EditText etID2, etPW2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        tvLoginRt = (TextView) findViewById(R.id.tvLoginRt);
        etID2 = (EditText) findViewById(R.id.etID2);
        etPW2 = (EditText) findViewById(R.id.etPW2);
        ((Button)findViewById(R.id.btnLogin2)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        MemberBean member = new MemberBean();
        MemberBean member2 = new MemberBean();

        member.setId(etID2.getText().toString());
        member.setPw(etPW2.getText().toString());

        MemberDAO memberDAO = new MemberDAO(this.getApplicationContext());

        member2 =memberDAO.login(member);

        if(member2.getName() == null){
            tvLoginRt.setText("로그인 결과 : 실패");
        }else{
            tvLoginRt.setText("로그인 결과 : 성공["+member2.getName()+"]");
        }

    }
}
