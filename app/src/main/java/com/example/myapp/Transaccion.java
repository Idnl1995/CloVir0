package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;


public class Transaccion extends AppCompatActivity {
    private Button btn_aceptar;
    private Switch btn_retirar, btn_depositar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaccion);

        btn_retirar = (Switch)findViewById(R.id.btn_retirar);
        btn_depositar = (Switch)findViewById(R.id.btn_depositar);
        btn_aceptar = (Button) findViewById(R.id.btn_aceptar);
        btn_retirar.setChecked(true);

        btn_retirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_retirar.isChecked()){
                    btn_depositar.setChecked(false);
                    btn_retirar.setChecked(true);
                }
            }
        });

        btn_depositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_depositar.isChecked()){
                    btn_retirar.setChecked(false);
                    btn_depositar.setChecked(true);
                }
            }
        });

    }

    public void validarBoton(View view){
        Intent cambiarActivity = new Intent(this, ElegirTienda.class);
        startActivity(cambiarActivity);
    }
}
