package com.semana03.tipcalcv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar propina;
    EditText input;
    TextView result;
    TextView hint;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        propina = findViewById(R.id.seekBar);
        input = findViewById(R.id.input);
        propina.setOnSeekBarChangeListener(new EvenSeek());
        result = findViewById(R.id.result);
        hint = findViewById(R.id.hint);
        title = findViewById(R.id.title);
    }

    private class EvenSeek implements SeekBar.OnSeekBarChangeListener{
        double outputValue = 0;
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            if(String.valueOf(input.getText()).isEmpty()){
                Toast.makeText(MainActivity.this, "Digite um valor!", Toast.LENGTH_SHORT).show();
            }else{
                hint.setText(i+"/100%");
                try{
                    outputValue = Double.valueOf(String.valueOf(input.getText()));
                    outputValue += (outputValue*i/100);
                    outputValue = Math.round(outputValue * 100.0)/100.0;
                    result.setText("Total a Pagar: R$ " + String.valueOf(outputValue));
                    if(i<10){
                        title.setText("Outr@ fiel cliente Mao de Vaca");
                    }else if(i < 30){
                        title.setText("seguro pode ir mais a sua direita");
                    }else if(i < 50){
                        title.setText("bom, pelo menos deu alguma coisa");
                    }else if (i<80){
                        title.setText("Agora sim, querido cliente!");
                    }else{
                        title.setText("Falei Cliente? É Irmão <3");
                    }
                }catch(NumberFormatException e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            if(String.valueOf(input.getText()).isEmpty())
                Toast.makeText(MainActivity.this, "Digite um valor!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
