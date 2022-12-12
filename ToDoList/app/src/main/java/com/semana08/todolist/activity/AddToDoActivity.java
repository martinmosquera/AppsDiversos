package com.semana08.todolist.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.semana08.todolist.R;
import com.semana08.todolist.helper.ToDoDAO;
import com.semana08.todolist.model.ToDo;

public class AddToDoActivity extends AppCompatActivity {

    private EditText newToDo;
    private ToDo currentToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        newToDo = findViewById(R.id.editTextNewTask);
        currentToDo = (ToDo) getIntent().getSerializableExtra("selectedToDo");
        if(currentToDo != null){
            newToDo.setText(currentToDo.getToDoName());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_to_do,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemSalvar){
            ToDoDAO toDoDAO = new ToDoDAO(getApplicationContext());
            if(currentToDo != null){
                String strNewToDo = newToDo.getText().toString();
                if(!strNewToDo.isEmpty()){
                    ToDo toDo = new ToDo();
                    toDo.setToDoName(strNewToDo);
                    toDo.setId(currentToDo.getId());

                    if(toDoDAO.updateToDo(toDo)){
                        finish();
                        Toast.makeText(this, "Tarefa Aatualizada!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Erro ao Atualizar a tarefa", Toast.LENGTH_SHORT).show();
                    }
                }
            }else{
                String newToDoS = newToDo.getText().toString();
                if(!newToDoS.isEmpty()){
                    ToDo toDo = new ToDo();
                    toDo.setToDoName(newToDoS);
                    if(toDoDAO.insertToDo(toDo)){
                        finish();
                        Toast.makeText(this, "Tarefa Salva!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Erro ao Salvar a tarefa", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(this, "Insira a tarefa", Toast.LENGTH_SHORT).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}