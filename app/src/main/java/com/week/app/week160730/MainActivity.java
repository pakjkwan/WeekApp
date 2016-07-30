package com.week.app.week160730;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.week.app.week160730.member.AddActivity;
import com.week.app.week160730.member.CountActivity;
import com.week.app.week160730.member.FindActivity;
import com.week.app.week160730.member.JoinActivity;
import com.week.app.week160730.member.LoginActivity;
import com.week.app.week160730.member.MemberListActivity;
import com.week.app.week160730.member.UpdateActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btJoin,btAdd,btLogin,btCount,btList,
            btFind,btUpdate,btDelete,btMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btJoin = (Button) findViewById(R.id.btJoin);
        btAdd = (Button) findViewById(R.id.btAdd);
        btLogin = (Button) findViewById(R.id.btLogin);
        btCount = (Button) findViewById(R.id.btCount);
        btList = (Button) findViewById(R.id.btList);
        btFind = (Button) findViewById(R.id.btFind);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btMap = (Button) findViewById(R.id.btMap);

        btJoin.setOnClickListener(this);
        btAdd.setOnClickListener(this);
        btLogin.setOnClickListener(this);
        btCount.setOnClickListener(this);
        btList.setOnClickListener(this);
        btFind.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btJoin :
                Toast.makeText(MainActivity.this,"btJoin",Toast.LENGTH_SHORT).show();
                this.startActivity(new Intent(this,JoinActivity.class));
                break;
            case R.id.btAdd :
                Toast.makeText(MainActivity.this,"btAdd",Toast.LENGTH_SHORT).show();
                this.startActivity(new Intent(this,AddActivity.class));
                break;
            case R.id.btLogin :
                Toast.makeText(MainActivity.this,"btLogin",Toast.LENGTH_SHORT).show();
                this.startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.btCount :
                Toast.makeText(MainActivity.this,"btCount",Toast.LENGTH_SHORT).show();
                this.startActivity(new Intent(this,CountActivity.class));
                break;
            case R.id.btList :
                Toast.makeText(MainActivity.this,"btList",Toast.LENGTH_SHORT).show();
                this.startActivity(new Intent(this,MemberListActivity.class));
                break;
            case R.id.btFind :
                Toast.makeText(MainActivity.this,"btFind",Toast.LENGTH_SHORT).show();
                this.startActivity(new Intent(this,FindActivity.class));
                break;
            case R.id.btUpdate :
                Toast.makeText(MainActivity.this,"btUpdate",Toast.LENGTH_SHORT).show();
                this.startActivity(new Intent(this,UpdateActivity.class));
                break;

        }

    }
}
