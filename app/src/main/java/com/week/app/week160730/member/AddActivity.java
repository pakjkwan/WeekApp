package com.week.app.week160730.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.week.app.week160730.R;

public class AddActivity extends Activity implements View.OnClickListener {
    EditText etName,etPhone;
    Button btAdd;
    MemberService service = new MemberServiceImpl(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        btAdd = (Button) findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        MemberBean guest = new MemberBean();
        guest.setName(name);
        guest.setPhone(phone);
        service.add(guest);
        startActivity(new Intent(this,GuestListActivity.class));

    }
}
