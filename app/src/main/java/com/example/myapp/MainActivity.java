package com.example.myapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usuario, contrasena;
    private Button btn_entrar, btn_registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText) findViewById(R.id.txt_usuario);
        contrasena = (EditText) findViewById(R.id.contrasena);
        btn_entrar = (Button) findViewById(R.id.btn_entrar);
        btn_registrar = (Button) findViewById(R.id.btn_regresar);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = usuario.getText().toString();
                String pass = contrasena.getText().toString();
                if(user.equals(null) || pass.equals(null)){
                    Toast.makeText(getApplicationContext(), "Llena todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        AdministradorUsuarios db = new AdministradorUsuarios(getApplicationContext());
                        String cadena = db.validar(user,pass);
                        if(cadena.equals(user+pass)){
                            Toast.makeText(getApplicationContext(), "Inicio exitoso", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), ElegirUsuario.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(getApplicationContext(), "Verifique los datos", Toast.LENGTH_SHORT).show();
                        }
                    }catch (SQLException s){
                        s.printStackTrace();
                    }
                }

            }
        });

    }


    public void activityRegistro(View view) {
        Intent cambiarActivity = new Intent(this, Registro.class);
        startActivity(cambiarActivity);
    }
}
