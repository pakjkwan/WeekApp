package com.week.app.week160730.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by hb on 2016-07-30.
 */
public class GuestDAO  extends SQLiteOpenHelper {
    public GuestDAO(Context context) {
        super(context, "hanbitdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public void add(MemberBean guest){
        String sql = "insert into guest(name, phone)" +
                String.format("values('%s','%s');",guest.getName(),guest.getPhone());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
    public ArrayList<MemberBean> list(){
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql = "select _id as id, name, phone from guest;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        if(cursor != null){
            Log.d("친구목록 조회","SUCCESS");
            cursor.moveToFirst();
            do{
                MemberBean temp = new MemberBean();
                temp.setId(String.valueOf(cursor.getInt(0)));
                temp.setName(cursor.getString(1));
                temp.setPhone(cursor.getString(2));
                list.add(temp);
            }while(cursor.moveToNext());
        }else{
            Log.d("친구목록 조회","FAIL");
        }
        return list;

    }
}
