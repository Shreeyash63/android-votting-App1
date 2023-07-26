package com.example.vottingapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class mydatabase {

    SQLiteDatabase sbd;
    Cursor cursor;
    myhelper mh;
    public static final String MY_DB="user_DB";
    Context mycontext;

    public mydatabase(Context context){
        this.mycontext=context;
        mh=new myhelper(mycontext,MY_DB,null,2);
    }

   public mydatabase() {

}

    public void insertvoter(ContentValues cv){
       sbd.insert("VOTER",null,cv);
        sbd=mh.getWritableDatabase();

    }

   public Cursor getData(){
        sbd=mh.getReadableDatabase();
        cursor=sbd.query("VOTER",null,null,null,null,null,null);

        return cursor;
   }

}
