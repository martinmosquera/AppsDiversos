package com.semana4.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView nome = findViewById(R.id.resultTextView);
        TextView imc = findViewById(R.id.imcTextView);
        TextView frase = findViewById(R.id.fraseTextView);

        String[] frases = {"Extremamente abaixo do peso","Gravemente Abaixo do Peso","Abaixo do Peso Ideal","Faixa de peso ideal","Sobrepeso","Obecidade grau I","Obesidade grau II (grave)","Obesidade grau III(mórbida)"};

        Intent it = getIntent();

        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String nomeStr = params.getString("nome");
                Double imcNum = params.getDouble("imc");
                String fraseStr;
                nome.setText(nomeStr);
                imc.setText("IMC: "+String.format("%.02f",imcNum));
                if(imcNum < 15){
                    fraseStr = frases[0];
                }else if(imcNum < 16){
                    fraseStr = frases[1];
                }else if(imcNum < 18.5){
                    fraseStr = frases[2];
                }else if(imcNum < 25){
                    fraseStr = frases[3];
                }else if(imcNum < 30){
                    fraseStr = frases[4];
                }else if(imcNum < 35){
                    fraseStr = frases[5];
                }else if(imcNum < 40){
                    fraseStr = frases[6];
                }else{
                    fraseStr = frases[7];
                }
                frase.setText(fraseStr);

            } // end of if params != null

        } // end if it != null

    }

}