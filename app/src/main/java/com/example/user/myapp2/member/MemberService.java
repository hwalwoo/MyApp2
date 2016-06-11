package com.example.user.myapp2.member;

/**
 * Created by USER on 2016-06-11.
 */
public interface MemberService {
    public String signup(MemberBean member);//Create  기본적으로 CRUD 4개 기본 기능 정의
    public MemberBean login(MemberBean member);//Read
    public MemberBean update(MemberBean member);//Update
    public String delete(MemberBean member); //delete
}
