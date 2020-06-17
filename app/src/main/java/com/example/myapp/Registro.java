package com.example.myapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText usuario, contrasena, confirma_contrasena;
    private Button btn_regresar, btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario = (EditText)findViewById(R.id.txt_usuario);
        contrasena = (EditText)findViewById(R.id.contrasena);
        confirma_contrasena = (EditText)findViewById(R.id.confirma_contrasena);
        btn_registrar = (Button)findViewById(R.id.btn_registrar);
        btn_regresar = (Button)findViewById(R.id.btn_regresar);

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { ;
                String user = usuario.getText().toString();
                String pass = contrasena.getText().toString();
                String pass2 = confirma_contrasena.getText().toString();

                if(user.equals(null) || pass.equals(null) || pass2.equals(null)){
                    Toast.makeText(getApplicationContext(), "Llena todos los campos", Toast.LENGTH_SHORT).show();
                }else if(!pass.equals(pass2)){
                    Toast.makeText(getApplicationContext(), "Verifica los datos", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        AdministradorUsuarios db  = new AdministradorUsuarios(getApplicationContext());
                        SQLiteDatabase data = db.getWritableDatabase();
                        ContentValues value = new ContentValues();

                        value.put("usuario",user);
                        value.put("contrasena", pass);

                        data.insert("Usuarios", null,value);
                        Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), ElegirUsuario.class);
                        startActivity(i);
                        usuario.setText(null);
                        contrasena.setText(null);
                    }catch(SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
