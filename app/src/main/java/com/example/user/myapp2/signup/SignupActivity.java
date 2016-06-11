package com.example.user.myapp2.signup;

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
import com.example.user.myapp2.member.MemberService;
import com.example.user.myapp2.member.MemberServiceImpl;

public class SignupActivity extends Activity implements View.OnClickListener{
    EditText etID,etPW,etName, etEmail;
    Button btSignup;
    TextView tvMemberRt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etName = (EditText) findViewById(R.id.etName);
        tvMemberRt = (TextView) findViewById(R.id.tvMemberRt);

        ((Button) findViewById(R.id.btSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String id = etID.getText().toString();
        String pw = etPW.getText().toString();
        String email = etEmail.getText().toString();
        MemberBean member = new MemberBean();
        MemberService service = new MemberServiceImpl();

        member.setId(id);
        member.setPw(pw);
        member.setEmail(name);
        member.setEmail(email);

        String msg = service.signup(member);
        tvMemberRt.setText("회원가입 결과 : "+ msg);

    }
}