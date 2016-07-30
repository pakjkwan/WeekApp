package com.week.app.week160730.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.week.app.week160730.MainActivity;
import com.week.app.week160730.R;

public class JoinActivity extends Activity implements View.OnClickListener {

    EditText etID,etPW,etName,etEmail,etPhone,etPhoto,etAddr;
    Button btJoin,btHome;
    TextView tvResult;
    MemberBean bean = new MemberBean();
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this);
        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etPhoto = (EditText) findViewById(R.id.etPhoto);
        etAddr = (EditText) findViewById(R.id.etAddr);
        btJoin = (Button) findViewById(R.id.btJoin);
        btHome = (Button) findViewById(R.id.btHome);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btJoin.setOnClickListener(this);
        btHome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String pw = etPW.getText().toString();
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        String photo = etPhoto.getText().toString();
        String addr = etAddr.getText().toString();
        bean.setId(id);
        bean.setPw(pw);
        bean.setName(name);
        bean.setEmail(email);
        bean.setPhone(phone);
        bean.setPhoto(photo);
        bean.setAddr(addr);
        switch (v.getId()){
            case R.id.btJoin:
                service.join(bean);
                this.startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.btHome:
                this.startActivity(new Intent(this,MainActivity.class));
                break;
            default : break;
        }
    }
}
