package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ElegirTienda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_tienda);
        ImageView navegar = (ImageView)findViewById(R.id.navegar);
        Toast.makeText(this, "Mostrando las tiendas disponibles", Toast.LENGTH_LONG).show();
    }
    public void cerrarNavegacion(View view){
        Intent cambiarActivity = new Intent(this,GenerarCodigo.class);
        startActivity(cambiarActivity);
    }
}
