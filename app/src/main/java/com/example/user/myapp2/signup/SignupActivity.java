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

import com.example.user.myapp2.R;

public class SignupActivity extends Activity implements View.OnClickListener{
    EditText etID,etPW,etName, etEmail;
    Button btSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etEmail = (EditText) findViewById(R.id.etEmail);

        ((Button) findViewById(R.id.btSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}