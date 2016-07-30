package com.week.app.week160730.member;

import java.util.ArrayList;

/**
 * Created by hb on 2016-07-30.
 */
public interface MemberService {
    /*Create : DB에 정보를 생성,입력*/
    public void join(MemberBean bean);
    public void add(MemberBean bean);
    /*Read : DB정보를 조회*/
    public boolean login(MemberBean bean);
    public int count();
    public ArrayList<MemberBean> list();
    public ArrayList<MemberBean> findByName(String name);
    public MemberBean findById(String id);
    /*update : DB정보를 수정*/
    public void update(MemberBean bean);
    /*delete : DB정보를 삭제*/
    public void delete(String id);

}
