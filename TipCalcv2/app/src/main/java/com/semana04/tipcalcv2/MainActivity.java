package com.semana04.tipcalcv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double currentBillTotal;
    private int currentCustomPrecent;
    private int quantidadePessoas =1;
    private EditText tip10EditText;
    private EditText tip15EditText;
    private EditText tip20EditText;
    private EditText total10EditText;
    private EditText total15EditText;
    private EditText total20EditText;
    private TextView customTipTextView;
    private EditText billEditText;
    private EditText tipCustomEditText;
    private EditText totalCustomEditText;
    private EditText totalPessoaEditText;
    private TextView quantidadePessoasTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tip10EditText = (EditText) findViewById(R.id.tip10EditTextField);
        tip15EditText = (EditText) findViewById(R.id.tip15EditTextField);
        tip20EditText = (EditText) findViewById(R.id.tip20EditTextField);

        total10EditText = (EditText) findViewById(R.id.total10EditTextField);
        total15EditText = (EditText) findViewById(R.id.total15EditTextField);
        total20EditText = (EditText) findViewById(R.id.total20EditTextField);

        customTipTextView = (TextView) findViewById(R.id.customTipTextView);
        tipCustomEditText = (EditText) findViewById(R.id.tipCustomEditTextField);
        totalCustomEditText = (EditText) findViewById(R.id.totalCustomEditTextField);
        totalPessoaEditText = (EditText) findViewById(R.id.totalPessoasEditTextField);
        quantidadePessoasTextView = (TextView) findViewById(R.id.quantidadePessoasTextView);

        billEditText = (EditText) findViewById(R.id.billEditText);
        SeekBar customSeekBar = (SeekBar) findViewById(R.id.customSeekBar);
        SeekBar pessoasSeekBar = (SeekBar) findViewById(R.id.pessoasSeekBar);

        currentCustomPrecent = customSeekBar.getProgress();
        quantidadePessoas = pessoasSeekBar.getProgress();

        billEditText.addTextChangedListener(billTextWatcher);

        customSeekBar.setOnSeekBarChangeListener(customSeekBarListener);
        pessoasSeekBar.setOnSeekBarChangeListener(pessoasSeekBarListener);
    }

    // funcao para atualizar os campos standar de 10 15 e 20 %
    public void updateStandard(){
        double tenPercentTip = currentBillTotal * .10;
        double tenPercentTotal = currentBillTotal + tenPercentTip;

        double fifteenPercentTip = currentBillTotal * 0.15;
        double fifteenPercentTotal = currentBillTotal + fifteenPercentTip;

        double twentyPercentTip = currentBillTotal * 0.20;
        double twentyPercentTotal = currentBillTotal + twentyPercentTip;

        tip10EditText.setText(String.format("%.02f",tenPercentTip));
        total10EditText.setText(String.format("%.02f",tenPercentTotal));

        tip15EditText.setText(String.format("%.02f",fifteenPercentTip));
        total15EditText.setText(String.format("%.02f",fifteenPercentTotal));

        tip20EditText.setText(String.format("%.02f",twentyPercentTip));
        total20EditText.setText(String.format("%.02f",twentyPercentTotal));
    }

    // funcao para atualizar os valores customizados com a seekBar
    public void updateCustom(){
        customTipTextView.setText(currentCustomPrecent + "%");

        double customTipAmount = currentBillTotal * currentCustomPrecent * 0.01;
        double customTotalAmount = currentBillTotal +customTipAmount;

        tipCustomEditText.setText(String.format("%.02f",customTipAmount));
        totalCustomEditText.setText(String.format("%.02f",customTotalAmount));
    }

    //funcao para atualizar o total entre as pessoas
    public void updatePessoas(){

        quantidadePessoasTextView.setText(String.valueOf(quantidadePessoas));
        double valorAtual = currentBillTotal+(currentBillTotal * currentCustomPrecent * 0.01);
        double valorPessoa = valorAtual/quantidadePessoas;
        totalPessoaEditText.setText(String.format("%.02f",valorPessoa));
    }

    // evento da mudança  de posição da propina no seekBar
    private SeekBar.OnSeekBarChangeListener customSeekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            currentCustomPrecent = i;
            updateCustom();
            updatePessoas();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    // evento de mudanca de posicao das pessoas no seek bar
    private SeekBar.OnSeekBarChangeListener pessoasSeekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            if(i == 0) quantidadePessoas = 1;
            else quantidadePessoas =i;
            updatePessoas();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    // evento de mudanza no textEdit
    private TextWatcher billTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try{
                currentBillTotal = Double.parseDouble(charSequence.toString());
            }catch(NumberFormatException e){
                currentBillTotal = 0.0;
            }
            updateCustom();
            updateStandard();
            updatePessoas();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}