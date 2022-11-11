package com.semana4.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.santalu.maskara.widget.MaskEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view){

        EditText nome = findViewById(R.id.nomeEditText);
        MaskEditText idade = findViewById(R.id.idadeEditText);
        MaskEditText telefone = findViewById(R.id.telefoneEditText);
        EditText login = findViewById(R.id.loginEditText);
        EditText senha = findViewById(R.id.senhaEditText);

        if(nome.getText().toString().isEmpty() || idade.getText().toString().isEmpty() || !telefone.isDone() ||
        login.getText().toString().isEmpty() || senha.getText().toString().isEmpty()){
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(MainActivity.this,FormResult.class);
            Bundle params = new Bundle();

            params.putString("nome",nome.getText().toString());
            params.putInt("idade",Integer.parseInt(idade.getText().toString()));
            params.putString("telefone",telefone.getMasked());
            params.putString("login",login.getText().toString());
            params.putString("senha",senha.getText().toString());

            intent.putExtras(params);

            startActivity(intent);
        }
    }

}