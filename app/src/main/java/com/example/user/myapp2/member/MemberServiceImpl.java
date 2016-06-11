package com.example.user.myapp2.member;

import android.app.Activity;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberServiceImpl extends Activity implements MemberService {
    MemberDAO memberDAO = new MemberDAO(this.getApplicationContext());
    @Override
    public String signup(MemberBean member) {
        return memberDAO.signup(member);
    }

    @Override
    public MemberBean login(MemberBean member) {
        return memberDAO.login(member);
    }

    @Override
    public MemberBean update(MemberBean member) {
        return memberDAO.update(member);
    }

    @Override
    public String delete(MemberBean member) {
        return memberDAO.delete(member);
    }


}
