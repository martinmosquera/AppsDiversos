package com.semana07.simpledb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SimpleDBWrapper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Student.db";
    private static final int DB_VERSION =1;

    public static final String TABLE_NAME = "students";
    public static final String STUDENT_ID = "id";
    public static final String STUDENT_NAME = "name";

    // statement para criacao da tabela
    private static final String DB_CREATE = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME+"("+STUDENT_ID+" integer primary key autoincrement,"+STUDENT_NAME+" text not null);";

    public SimpleDBWrapper(Context context){
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
