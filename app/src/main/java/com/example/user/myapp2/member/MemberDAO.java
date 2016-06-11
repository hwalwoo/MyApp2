package com.example.user.myapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper {

    public MemberDAO(Context context){//}, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //super(context, name, factory, version);
        super(context, "hanbitDB", null, 1); //page 456
                    // DB_NAME, null, DB_VERSION
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table member2(id text, pw text, name text, email text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String signup(MemberBean member) {

        String name = member.getName();
        String id = member.getId();
        String pw = member.getPw();
        String email = member.getEmail();

        Log.i("name", name);
        Log.i("id", id);
        Log.i("pw", pw);
        Log.i("email", email);
        return "회원가입 축하 합니다";
    }

    public MemberBean login(MemberBean member) {
        //ArrayList<MemberBean> list = new ArrayList<MemberBean>();////멀티 row처리
        SQLiteDatabase db = this.getReadableDatabase();

        MemberBean _member = new MemberBean();

       /* _member.setId(member.getId());
        _member.setName("홍길동");
        _member.setPw(member.getPw());
        _member.setEmail("hong@naver.com");
       */
       // Log.i("name", member.getName());
        Log.i("id", member.getId());
        Log.i("pw", member.getPw());
        //Log.i("email", member.getEmail());

        Cursor cursor = db.rawQuery("select * from member where id= '"+ member.getId() +"' and pw ='"+member.getPw()+"';", null);

        while (cursor.moveToNext()){
            _member.setId(cursor.getString(0));
            _member.setPw(cursor.getString(1));
            _member.setName(cursor.getString(2));
            _member.setEmail(cursor.getString(3));
            //list.add(_member); //멀티 row처리
        }
/*
        Log.i("name", _member.getName());
        Log.i("id", _member.getId());
        Log.i("pw", _member.getPw());
        Log.i("email", _member.getEmail());
*/
        cursor.close();
        db.close();
        return _member;
    }

    public MemberBean update(MemberBean member) {
        MemberBean _member = new MemberBean();
        return _member;
    }

    public String delete(MemberBean member) {
        return "삭제완료";
    }


}
