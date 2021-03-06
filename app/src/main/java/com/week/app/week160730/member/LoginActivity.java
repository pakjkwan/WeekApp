package com.week.app.week160730.member;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.week.app.week160730.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    EditText etID,etPW;
    TextView textResult;
    Button btLogin;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());
        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String pw = etPW.getText().toString();
        Log.d("로그인 액티비티 ID",id);
        Log.d("로그인 액티비티 PW",pw);
        MemberBean member = new MemberBean();
        member.setId(id);
        member.setPw(pw);
        if(service.login(member)){
            Toast.makeText(LoginActivity.this,"로그인성공",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LoginActivity.this,"로그인실패",Toast.LENGTH_SHORT).show();
        }
    }
}
