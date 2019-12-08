package com.example.quiznightt.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class sql {
    private final int DB_VR=1;
    private final String DATABASENAME="MyQUIZ.db";
    private Context context;
    private String TABLENAME="QUSns";
    private SQLiteDatabase database;
    private String c1="Question";
    private String c2="ANS1";
    private String c3="ANS2";
    private String c4="ANS3";
    private String c5="ANS4";
    private String c6="RightAns";

    private  sql(){}
    private static sql obj;

    public static synchronized sql getInstance(){
        if (obj==null){
            obj=new sql();

        }
        return obj;
    }

    public sql Start(Context context){
         if (obj !=null){
             helper=new myhelper(context);
             database=helper.getReadableDatabase();
         }
        return obj;
    }

    myhelper helper;
    public boolean AddToDataBase(QuModule module){
        ContentValues values=new ContentValues();

        values.put(c1,module.getQus());
        values.put(c2,module.getAns1());
        values.put(c3,module.getAns2());
        values.put(c4,module.getAns3());
        values.put(c5,module.getAns4());
        values.put(c6,module.getR_ans());
        return database.insert(TABLENAME,null,values)!=-1;

    }
    public List<QuModule> getAllQus(){
        List<QuModule> returnedlist=new ArrayList<>();
        QuModule m;

        Cursor cr=database.rawQuery("SELECT * FROM "+ TABLENAME,null);
        while (cr.isAfterLast()){
            m=new QuModule();
            m.setQus(cr.getString(cr.getColumnIndex(c1)));
            m.setAns1(cr.getString(cr.getColumnIndex(c2)));
            m.setAns2(cr.getString(cr.getColumnIndex(c3)));
            m.setAns3(cr.getString(cr.getColumnIndex(c4)));
            m.setAns4(cr.getString(cr.getColumnIndex(c5)));
            m.setR_ans(cr.getString(cr.getColumnIndex(c6)));
            returnedlist.add(m);
            cr.moveToNext();
        }
        cr.close();

        return returnedlist;
    }



    class myhelper extends SQLiteOpenHelper {
        myhelper(Context context){
      super(context,DATABASENAME,null,DB_VR);}

        @Override

        public void onCreate(SQLiteDatabase db) {
            String sql ="CREATE TABLE IF NOT EXISTS "+TABLENAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT ,Qusetion TEXT" + " ,ANS1 TEXT, ANS2 TEXT,ANS3 TEXT, ANS4 TEXT,RightAns TEXT)";
        db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
