package com.example.user.myapp2.kaup;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp2.R;

public class KaupActivity extends Activity implements View.OnClickListener {
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
        btRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Toast tMsg = Toast.makeText(KaupActivity.this, "토스트연습", Toast.LENGTH_LONG);
        tMsg.show();

        String vName = etName.getText().toString();
        vWeight = Double.parseDouble(etWeight.getText().toString());
        vHeight = Double.parseDouble(etHeight.getText().toString());

        KaupService service = new KaupServiceImpl();
        rstMsg = service.getKaup(vWeight, vHeight);
        Log.d(rstMsg, "카우푸지수");// console에 나옴

        tvResult.setText(rstMsg);
    }
}
