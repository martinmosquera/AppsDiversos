package com.semana07.simpledb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentOperations studentOperations;
    ListView studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentOperations = new StudentOperations(this);
        studentOperations.open();

        studentList = findViewById(R.id.listView);
        List values = studentOperations.getAllStudents();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,values);
        studentList.setAdapter(adapter);

    }

    public void addStudent(View view){
        ArrayAdapter adapter = (ArrayAdapter) studentList.getAdapter();
        EditText studentName = findViewById(R.id.studentNameEditText);
        Student student = studentOperations.addStudent(studentName.getText().toString());
        adapter.add(student);
        studentName.setText("");
    }

    public void deleteFirstStudent(View view){
            ArrayAdapter adapter = (ArrayAdapter) studentList.getAdapter();
            Student student = null;
            // verificar se tamanho da lista maior que 0
            if(studentList.getAdapter().getCount() > 0){
                student = (Student) studentList.getAdapter().getItem(0);
                studentOperations.deleteStudent(student);
                adapter.remove(student);
            }else{
                Toast.makeText(this, "Lista Vazia!!", Toast.LENGTH_SHORT).show();
            }
    }
}