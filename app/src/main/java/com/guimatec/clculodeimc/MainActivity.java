package com.guimatec.clculodeimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editPeso ;
    EditText editAltura;
    TextView tvResultado;
    TextView tvDescricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        tvResultado = findViewById(R.id.tvResultado);
        tvDescricao = findViewById(R.id.tvDescricao);



        final float [] imc = new float[1];

        Button btClean = findViewById(R.id.btClean);
        btClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editAltura.setText("");
                editPeso.setText("");
                tvDescricao.setText("");
                tvResultado.setText("");

            }
        });


        Button btCalcular = findViewById(R.id.btCalcular);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int peso = Integer.parseInt(editPeso.getText().toString());
                float altura = Float.parseFloat(editAltura.getText().toString());

                imc [0] = peso / (altura * altura);

                if (imc[0]<18.5){
                    tvResultado.setText(imc[0]+ "");
                    tvDescricao.setText("Baixo peso");
                } else {
                    if (imc[0]<25){
                        tvResultado.setText(imc[0]+ "");
                        tvDescricao.setText("Peso adequado");
                    } else {
                        if (imc[0]<30){
                            tvResultado.setText(imc[0]+ "");
                            tvDescricao.setText("Sobrepeso");
                        } else {
                            tvResultado.setText(imc[0]+ "");
                            tvDescricao.setText("Obesidade");

                        }

                    }

                    }



            }

        });
    }



}
