package com.semana03.conversordemoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view){
        RadioButton deReal = findViewById(R.id.radioButtondeReal);
        RadioButton deDolar = findViewById(R.id.radioButtondeDolar);
        RadioButton deEuro = findViewById(R.id.radioButtonDeEuro);
        RadioButton paraReal = findViewById(R.id.radioButtonParaReal);
        RadioButton paraDolar = findViewById(R.id.radioButtonParaDolar);
        RadioButton paraEuro = findViewById(R.id.radioButtonParaEuro);
        EditText input = findViewById(R.id.input);
        TextView result = findViewById(R.id.result);
        String valorInput = String.valueOf(input.getText());
        String valorOutput = "";
        if(valorInput.isEmpty()){
            Toast.makeText(this, "Digite o valor", Toast.LENGTH_SHORT).show();
        }else{
            double inputMoney =  Double.parseDouble(String.valueOf(input.getText()));
            double outputMoney = 0;
            if(deReal.isChecked() && paraDolar.isChecked()){
                outputMoney = inputMoney*5.50;
                valorOutput = "$";
            }else if(deReal.isChecked() && paraEuro.isChecked()){
                outputMoney = inputMoney*6.20;
                valorOutput = "€";
            }else if(deDolar.isChecked() && paraReal.isChecked()){
                outputMoney = inputMoney/5.50;
                valorOutput = "R$";
            }else if(deDolar.isChecked() && paraEuro.isChecked()){
                outputMoney = inputMoney/1.272;
                valorOutput = "€";
            }else if(deEuro.isChecked() && paraReal.isChecked()){
                outputMoney = inputMoney/6.20;
                valorOutput = "R$";
            }else if(deEuro.isChecked() && paraDolar.isChecked()){
                outputMoney = inputMoney*1.272;
                valorOutput = "$";
            }else{
                Toast.makeText(this, "Opção não valida", Toast.LENGTH_SHORT).show();
            }
            outputMoney = Math.round(outputMoney * 100.0)/100.0;
            result.setText(valorOutput +" "+ String.valueOf(outputMoney));
        }

    }
}