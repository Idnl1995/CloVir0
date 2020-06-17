package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class CodigoQR extends AppCompatActivity {

    private Button generarQR,btn_aceptar;
    private ImageView imagenQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_qr);

        imagenQR = (ImageView)findViewById(R.id.codigo_qr);
        generarQR = (Button)findViewById(R.id.generar_codigo);
        btn_aceptar = (Button)findViewById(R.id.btn_continuar);
        btn_aceptar.setEnabled(false);
    }

    public void generarCodigo(View view){
        btn_aceptar.setEnabled(true);
        imagenQR.setImageResource(R.drawable.qr);
    }

    public void cambiarDeActivity(View view){
        Intent cambiarActivity = new Intent(this, EstadoCuenta.class);
        startActivity(cambiarActivity);
    }
}
