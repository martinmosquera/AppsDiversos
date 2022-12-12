package com.semana07.simpledb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentOperations {

    private SimpleDBWrapper dbHelper;
    private String[] STUDENT_TABLE_COLUMNS = {SimpleDBWrapper.STUDENT_ID,SimpleDBWrapper.STUDENT_NAME};
    private SQLiteDatabase db;

    public StudentOperations(Context context){
        dbHelper = new SimpleDBWrapper(context);
    }
    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Student addStudent(String name){
        ContentValues values = new ContentValues();
        values.put(SimpleDBWrapper.STUDENT_NAME,name);
        long studentID = db.insert(SimpleDBWrapper.TABLE_NAME,null,values);
        Cursor cursor = db.query(SimpleDBWrapper.TABLE_NAME,STUDENT_TABLE_COLUMNS,SimpleDBWrapper.STUDENT_ID+"="+studentID,null,null,null,null);
        cursor.moveToFirst();
        Student student = parseStudent(cursor);
        cursor.close();
        return student;
    }

    public void deleteStudent(Student student){
        long id = student.getId();
        db.delete(SimpleDBWrapper.TABLE_NAME,SimpleDBWrapper.STUDENT_ID+"="+id,null);
    }

    public List getAllStudents(){
        List students = new ArrayList();
        Cursor cursor = db.query(SimpleDBWrapper.TABLE_NAME,STUDENT_TABLE_COLUMNS,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Student student = parseStudent(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        return students;
    }

    private Student parseStudent(Cursor c){
        Student student = new Student();
        int indexId = c.getColumnIndex("id");
        int indexName = c.getColumnIndex("name");
        long id = c.getInt(indexId);
        String n = c.getString(indexName);
        student.setId(id);
        student.setName(n);
        return student;
    }
}
