package com.example.user.myapp2.group;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapp2.R;

public class GroupActivity extends Activity implements View.OnClickListener {
    EditText etName, etMemberCnt, etNameResult, etMemberCntResult;
    GroupDBHelper groupDBHelper = new GroupDBHelper(this);
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        etName = (EditText) findViewById(R.id.etName);
        etMemberCnt = (EditText) findViewById(R.id.etMemberCnt);
        etNameResult = (EditText) findViewById(R.id.etNameResult);
        etMemberCntResult = (EditText) findViewById(R.id.etMemberCntResult);

        ((Button)findViewById(R.id.btInit)).setOnClickListener(this);
        ((Button)findViewById(R.id.btInsert)).setOnClickListener(this);
        ((Button)findViewById(R.id.btSearch)).setOnClickListener(this);
        ((Button)findViewById(R.id.btDelete)).setOnClickListener(this);
        ((Button)findViewById(R.id.btList)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btInit:
                Toast.makeText(getApplicationContext(),"초기화", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etMemberCnt.setText("");
                etNameResult.setText("");
                etMemberCntResult.setText("");

                db = groupDBHelper.getWritableDatabase();
                db.execSQL("INSERT INTO group(name, num) VALUES('IOI', 20);");
                db.close();
                Toast.makeText(getApplicationContext(), "입력성공", Toast.LENGTH_SHORT);
                break;
            case R.id.btInsert:
                if(etName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    break;
                }else if(etMemberCnt.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"멤버수를 입력하세요.", Toast.LENGTH_SHORT).show();
                    break;
                }
                break;
            case R.id.btList:

                break;
            case R.id.btSearch:
                etNameResult.setText("그룹이름");
                etMemberCntResult.setText("멤버수");
                break;
            case R.id.btDelete:
                Toast.makeText(getApplicationContext(),"삭제", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
