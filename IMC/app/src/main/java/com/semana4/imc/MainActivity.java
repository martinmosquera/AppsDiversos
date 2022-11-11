package com.semana4.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calcular(View view){

        EditText nome = findViewById(R.id.nomeEditText);
        EditText altura = findViewById(R.id.alturaEditText);
        EditText peso = findViewById(R.id.pesoEditText);

        String nomeStr = String.valueOf(nome.getText());
        double alturaNum= 0.0;
        double pesoNum = 0.0;
        double imc =0.0;
        try{
            if(nomeStr.isEmpty()) throw new RuntimeException();
            alturaNum = Double.parseDouble(String.valueOf(altura.getText()));
            pesoNum = Double.parseDouble(String.valueOf(peso.getText()));
            imc = pesoNum/(alturaNum*alturaNum);
            Intent it = new Intent(MainActivity.this,Result.class);
            Bundle params = new Bundle();
            params.putString("nome",nomeStr);
            params.putDouble("imc",imc);
            it.putExtras(params);
            // limpo as entradas do usuario
            nome.setText("");
            altura.setText("");
            peso.setText("");
            // inicio a activity da resposta
            startActivity(it);
        }catch(RuntimeException e){
            Toast.makeText(this, "Complete todos os Campos", Toast.LENGTH_SHORT).show();
        }
    }
}