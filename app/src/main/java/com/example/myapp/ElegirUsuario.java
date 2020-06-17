package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class ElegirUsuario extends AppCompatActivity {
    private Switch cliente, tienda;
    private Button btn_aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_usuario);

        cliente = (Switch) findViewById(R.id.switch_usuario);
        tienda = (Switch)findViewById(R.id.switch_tienda);
        btn_aceptar = (Button)findViewById(R.id.btn_aceptar_usuario);

        cliente.setChecked(true);

        tienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tienda.setChecked(true);
                cliente.setChecked(false);
                validarBotonTienda();
            }
        });

        cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View va) {
                tienda.setChecked(false);
                cliente.setChecked(true);
                validarBotonUsuario();

            }
        });
    }

    public void validarBotonUsuario(){

        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiarActivity = new Intent(getApplicationContext(), Transaccion.class);
                startActivity(cambiarActivity);
            }
        });
    }

    public void validarBotonTienda(){
        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiarActivity = new Intent(getApplicationContext(), LeerQR.class);
                startActivity(cambiarActivity);
            }
        });
    }
}
