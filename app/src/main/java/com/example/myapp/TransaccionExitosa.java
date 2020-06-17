package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransaccionExitosa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaccion_exitosa);
    }

    public void nuevaTransaccion(View view){
        Intent i = new Intent(getApplicationContext(), LeerQR.class);
        startActivity(i);
    }

}
