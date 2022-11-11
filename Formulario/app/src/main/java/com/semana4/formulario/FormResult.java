package com.semana4.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.santalu.maskara.widget.MaskEditText;

public class FormResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_result);

        Intent intent = getIntent();
        if(intent != null){
            Bundle params = intent.getExtras();
            if(params != null){
                EditText nome = findViewById(R.id.nomeResultEditText);
                MaskEditText idade = findViewById(R.id.idadeResultEditText);
                MaskEditText telefone = findViewById(R.id.telefoneResultEditText);
                EditText login = findViewById(R.id.loginResultEditText);
                EditText senha = findViewById(R.id.senhaResultEditText);
                nome.setText(params.getString("nome"));
                idade.setText(String.valueOf(params.getInt("idade")));
                telefone.setText(params.getString("telefone"));
                login.setText(params.getString("login"));
                senha.setText(params.getString("senha"));
            }
        }
    }
}