package com.example.user.myapp2.kaup;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp2.R;

public class KaupActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_kaup);
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

                KaupService service = new KaupService();
                rstMsg = service.getKaup(vWeight, vHeight);

                tvResult.setText(rstMsg);
                return false;
            }
        });
    }

}
