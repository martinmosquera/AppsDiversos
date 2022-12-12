package com.semana08.todolist.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static int DB_VERSION = 1;
    public static String DB_NAME = "TODO.DB";
    public static String TABLE_NAME = "todos";

    public DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_SQL = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(id integer primary key autoincrement, name text not null);";
        try{
            sqLiteDatabase.execSQL(CREATE_SQL);
            Log.i("INFO_DB","Tabela Criada");
        }catch (Exception e){
            Log.i("INFO_DB","Erro ao criar a tabela "+e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS "+ TABLE_NAME+";";
        try{
            sqLiteDatabase.execSQL(sql);
            onCreate(sqLiteDatabase);
            Log.i("INFO_DB","Tabela Atualizada");
        }catch(Exception e){
            Log.i("INFO_DB","Erro ao atualizar a tabela "+e.getMessage());
        }
    }
}
