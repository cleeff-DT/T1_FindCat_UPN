package com.example.gato.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Gatos extends SQLiteOpenHelper {
    //datos para el constructor
    private  static final String nombreDB= "Gatos.db";
    private static  final int versionDB= 1;
    //cadenas para DDL (lenjuage de definicion de datos) en SQLite;
    private static final String createTableUsuario = "create table if not exists Usuarios(id integer, correo varchar(255), clave varchar(255));";
    private static final String dropTableUsuario = "drop table if exists Usuarios;";

    public Gatos(@Nullable Context context) {
        super(context, nombreDB, null, versionDB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //aca se recomienda crear el esquema de sqlite
        sqLiteDatabase.execSQL(createTableUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(dropTableUsuario);
        sqLiteDatabase.execSQL(createTableUsuario);
    }
    //funcion create en sqlite
    public  boolean agregarUsuario(int id, String correo, String clave){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            String sentencia = "insert into Usuarios values("+id+",'"+correo+"','"+clave+"');";
            db.execSQL(sentencia);
            db.close();
            return true;
        }
        return false;
    }
    //funcion para validad si recordo sesion
    public boolean recordoSesion(){
        SQLiteDatabase db = getReadableDatabase();
        if (db !=null){
            String consulta = "Select * from Usuarios;";
            Cursor cursos = db.rawQuery(consulta,null);
            if (cursos.moveToNext())
                return true;
        }
        return  false;
    }
    //funcion para obtener data
    public String getValue(String value){
        SQLiteDatabase db = getReadableDatabase();
        if (db != null){
            String consulta = "select "+value+" from Usuarios;";
            Cursor cursor = db.rawQuery(consulta, null);
            if(cursor.moveToNext())
                return cursor.getString(0);
        }
        return null;
    }
    //funcion eliminar datos de la tabla usuarios
    public  boolean eliminarUsuarios(){
        SQLiteDatabase db = getReadableDatabase();
        if (db != null){
            String consulta = "delete from Usuarios;";
            db.execSQL(consulta);
            db.close();
            return true;
        }
        return false;
    }
    //funcion actualziar un campo
    public boolean actualizarValor(String llave, String valor){
        SQLiteDatabase db = getReadableDatabase();
        if (db != null){
            String consulta = "update Usuarios set "+llave+" = '"+valor+"';";
            db.execSQL(consulta);
            db.close();
            return true;
        }
        return false;
    }
}
