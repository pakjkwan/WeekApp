package com.week.app.week160730.member;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by hb on 2016-07-30.
 */
public class MemberServiceImpl implements MemberService {
    MemberDAO dao;
    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    @Override
    public void join(MemberBean bean) {
        String id = bean.getId();
        String pw = bean.getPw();
        String name = bean.getName();
        String email = bean.getEmail();
        Log.d("넘어온 ID : ",id);
        Log.d("넘어온 PW : ",pw);
        Log.d("넘어온 이름 : ",name);
        Log.d("넘어온 이메일 : ",email);
        dao.insert(bean);

    }

    @Override
    public void add(MemberBean bean) {
        dao.insert(bean);
    }

    @Override
    public boolean login(MemberBean bean) {
        boolean loginOK = false;
        String id = bean.getId();
        String pw = bean.getPw();
        Log.d("서비스로 넘어온 ID : ",id);
        Log.d("서비스로 넘어온 PW : ",pw);
        MemberBean member = dao.login(bean);
        if(member.getId().equals("fail")){
            loginOK = false;
        }else{
            loginOK = true;
        }
        Log.d("DAO에서 반환한 ID",member.getId());
        return loginOK;
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public ArrayList<MemberBean> list() {
        return dao.list();
    }

    @Override
    public ArrayList<MemberBean> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public MemberBean findById(String id) {
        return dao.findById(id);
    }

    @Override
    public void update(MemberBean bean) {
        dao.update(bean);
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
    }
}
