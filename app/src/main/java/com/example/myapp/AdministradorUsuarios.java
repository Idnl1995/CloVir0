package com.example.myapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdministradorUsuarios extends SQLiteOpenHelper{

    public static final int DATA_BASE_VERSION = 1;
    public static final String DATABASE_NAME = "Usuarios.db";


    public AdministradorUsuarios(Context context) {
        super(context, DATABASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase BD) {
        BD.execSQL("create table Usuarios(numero integer primary key autoincrement, usuario text, contrasena text)");

    }

    public String validar(String Usuario, String contrasena)throws SQLException {
        String user = null;
        String pass = null;
        Cursor c = null;
        SQLiteDatabase db = this.getReadableDatabase();
        c = db.rawQuery("select numero, usuario, contrasena from Usuarios",null);
        if(c!=null && c.getCount()>0){
            c.moveToFirst();
            do{
                user = c.getString(c.getColumnIndex("usuario"));
                pass = c.getString(c.getColumnIndex("contrasena"));
            }while(c.moveToNext());

        }
        db.close();
        System.out.println(user+pass);
        return user+pass;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
