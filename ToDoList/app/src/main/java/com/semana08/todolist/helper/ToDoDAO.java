package com.semana08.todolist.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.semana08.todolist.model.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public ToDoDAO(Context context){
        DBHelper db = new DBHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    public boolean insertToDo(ToDo toDo){
        ContentValues values = new ContentValues();
        values.put("name",toDo.getToDoName());
        try{
            write.insert(DBHelper.TABLE_NAME,null,values);
            Log.i("INFO","Tarefa salva com sucesso!");
        }catch(Exception e){
            Log.e("INFO","Erro ao salvar a tarefa"+e.getMessage());
            return false;
        }
        return true;
    }
    public boolean updateToDo(ToDo toDo){
        ContentValues values = new ContentValues();
        values.put("name",toDo.getToDoName());
        try{
            String[] args = {String.valueOf(toDo.getId())};
            write.update(DBHelper.TABLE_NAME,values,"id=?",args);
            Log.i("INFO","Tarefa Atualizada com sucesso!");
        }catch(Exception e){
            Log.e("INFO","Erro ao atualizar a tarefa"+e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteToDo(ToDo toDo){
        try{
            String[] args = {String.valueOf(toDo.getId())};
            write.delete(DBHelper.TABLE_NAME,"id=?",args);
            Log.i("INFO","Tarefa removida com sucesso!");
        }catch(Exception e){
            Log.e("INFO","Erro ao remover a tarefa"+e.getMessage());
            return false;
        }
        return true;
    }

    public List<ToDo> getAllToDos(){
        List<ToDo> lista = new ArrayList<>();
        Cursor cursor = read.query(DBHelper.TABLE_NAME,new String[]{"id","name"},null,null,null,null,null);
        while(cursor.moveToNext()){
            ToDo toDo = new ToDo();
            int indexId = cursor.getColumnIndex("id");
            int indexName = cursor.getColumnIndex("name");
            Long id = cursor.getLong(indexId);
            String name = cursor.getString(indexName);
            toDo.setId(id);
            toDo.setToDoName(name);
            lista.add(toDo);
        }
        return lista;
    }
}
