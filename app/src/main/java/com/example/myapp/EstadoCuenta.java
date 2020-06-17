package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EstadoCuenta extends AppCompatActivity {
    private TextView saldo,tipo_tramite;
    private Button regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_cuenta);

        saldo = (TextView)findViewById(R.id.tv_saldo);
        tipo_tramite = (TextView)findViewById(R.id.tv_tipo_tramite);
        regresar= (Button)findViewById(R.id.btn_volver_usuario);
    }

    public void nuevaTransaccion(View view){
        Intent i = new Intent(getApplicationContext(), Transaccion.class);
        startActivity(i);
    }
}
