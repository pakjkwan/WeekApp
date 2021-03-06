package com.week.app.week160730.member;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by hb on 2016-07-30.
 */
public class MemberServiceImpl implements MemberService {
    MemberDAO dao;
    GuestDAO gDao;
    MemberBean session;
    public MemberServiceImpl(Context context) {

        dao = new MemberDAO(context);
        gDao = new GuestDAO(context);
        session = new MemberBean();
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

        gDao.add(bean);
    }

    @Override
    public boolean login(MemberBean bean) {
        boolean loginOK = false;
        String id = bean.getId();
        String pw = bean.getPw();
        Log.d("서비스로 넘어온 ID : ",id);
        Log.d("서비스로 넘어온 PW : ",pw);
        session = dao.login(bean);
        if(session.getId().equals("fail")){
            loginOK = false;
        }else{
            loginOK = true;
        }
        Log.d("DAO에서 반환한 ID",session.getId());
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
        if(dao.findById(id)==null){
            Log.d("DAO 에서 넘어온 값 : ","null");
        }else{
            Log.d("DAO 에서 넘어온 값 : ","not null");
        }
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
