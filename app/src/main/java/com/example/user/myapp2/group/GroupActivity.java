package com.example.user.myapp2.group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.myapp2.R;

public class GroupActivity extends Activity implements View.OnClickListener {
    EditText etName, etMemberCnt, etResult;
    GroupDBHelper groupDBHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        etName = (EditText) findViewById(R.id.etName);
        etMemberCnt = (EditText) findViewById(R.id.etMemberCnt);
        etResult = (EditText) findViewById(R.id.etResult);

        ((Button)findViewById(R.id.btInit)).setOnClickListener(this);
        ((Button)findViewById(R.id.btInsert)).setOnClickListener(this);
        ((Button)findViewById(R.id.btSearch)).setOnClickListener(this);
        ((Button)findViewById(R.id.btDelete)).setOnClickListener(this);
        ((Button)findViewById(R.id.btList)).setOnClickListener(this);
        ((Button)findViewById(R.id.btCount)).setOnClickListener(this);
        ((Button)findViewById(R.id.btUpdate)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        groupDBHelper = new GroupDBHelper(this);
        Cursor cursor = null;
        String id = null;
        String name = null;
        String num = null;
        String headeStr = "";
        String bodyStr = "";

        switch (v.getId()){
            case R.id.btInit://초기화
                db = groupDBHelper.getWritableDatabase();
                groupDBHelper.onUpgrade(db, 1,2);
                db.close();
                Toast.makeText(getApplicationContext(),"초기화", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etMemberCnt.setText("");
                etResult.setText("");


                break;
            case R.id.btInsert://입력
                if(etName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    etName.requestFocus();
                    return;
                }
                if(etMemberCnt.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"멤버수를 입력하세요.", Toast.LENGTH_SHORT).show();
                    etMemberCnt.requestFocus();
                    return;
                }
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("INSERT INTO girlgroup (name, num) VALUES('"+etName.getText().toString()+"', "+etMemberCnt.getText().toString()+");");
                Toast.makeText(getApplicationContext(), "입력되었습니다", Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btList: //리스트
                db = groupDBHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM girlgroup;", null);
                if(cursor.getCount() == 0){
                    Toast.makeText(getApplicationContext(),"조회된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                headeStr = "NO" + "\t\t" + "그룹이름" +"\t\t"+ "멤버수" + "\r\n";
                headeStr += "-------------------------------------------" + "\r\n";
                while (cursor.moveToNext()){
                    id = cursor.getInt(0)+"";
                    name = cursor.getString(1);
                    num = cursor.getInt(2)+"";
                    bodyStr += id + "\t\t\t" + name +"\t\t\t\t"+num + "\r\n";
                }

                etResult.setText(headeStr+bodyStr);
                cursor.close();
                db.close();
                break;
            case R.id.btSearch: //조회
                if(etName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    etName.requestFocus();
                    return;
                }
                db = groupDBHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM girlgroup WHERE name ='"+etName.getText().toString()+"';", null);
                if(cursor.getCount() == 0){
                    Toast.makeText(getApplicationContext(),"조회된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                headeStr = "NO" + "\t\t" + "그룹이름" +"\t\t"+ "멤버수" + "\r\n";
                headeStr += "-------------------------------------------" + "\r\n";
                while (cursor.moveToNext()){
                    id = cursor.getInt(0)+"";
                    name = cursor.getString(1);
                    num = cursor.getInt(2)+"";
                    bodyStr += id + "\t\t\t" + name +"\t\t\t\t"+num + "\r\n";
                }

                etResult.setText(headeStr+bodyStr);
                cursor.close();
                db.close();
                break;
            case R.id.btUpdate://수정
                if(etName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"수정 대상 이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    etName.requestFocus();
                    return;
                }
                if(etMemberCnt.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"멤버수 수정값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    etMemberCnt.requestFocus();
                    return;
                }
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("UPDATE girlgroup SET num ="+ etMemberCnt.getText().toString()+" WHERE name ='"+etName.getText().toString()+"';");
                db.close();
                Toast.makeText(getApplicationContext(),"수정되었습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btCount:
                db = groupDBHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM girlgroup;", null);
                if(cursor.getCount() == 0){
                    Toast.makeText(getApplicationContext(),"조회된 값이 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                num = "멤버수" + "\r\n" + "----------" + "\r\n";
                num += cursor.getCount() + "\r\n";
                etResult.setText(num);
                cursor.close();
                db.close();
                break;
            case R.id.btDelete://삭제
                if(etName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    etName.requestFocus();
                    return;
                }
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("DELETE FROM girlgroup  WHERE name ='"+etName.getText().toString()+"';");
                db.close();
                Toast.makeText(getApplicationContext(),"삭제되었습니다", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
