package com.example.user.myapp2.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberDAO{//} extends SQLiteOpenHelper {
/*chwtest
    public MemberDAO(Context context){//}, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //super(context, name, factory, version);
        super(context, null, null, 1); //page 456
                    // DB_NAME, null, DB_VERSION
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }*/

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
        MemberBean _member = new MemberBean();
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
