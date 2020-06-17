package com.example.myapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class LeerQR extends AppCompatActivity{
    private TextView texto;
    private Button btn_escanear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_qr);
        btn_escanear = (Button)findViewById(R.id.txt_btn_QR);
        texto = (TextView)findViewById(R.id.QR_descifrado);

        btn_escanear.setOnClickListener(evento);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode,data);
        if(result != null){
            if(result.getContents() != null){
                codigoTransaccion(result.getContents());
            }else{
                Toast.makeText(this, "Error al leer el código QR", Toast.LENGTH_LONG).show();
            }
        }
    }

    private View.OnClickListener evento = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.txt_btn_QR:
                    new IntentIntegrator(LeerQR.this).initiateScan();
                    break;
            }
        }
    };

    public void codigoTransaccion(String codigoTransaccion){
        Toast.makeText(this, "Código de transacción: "+codigoTransaccion, Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), TransaccionExitosa.class);
        startActivity(i);
    }
}
