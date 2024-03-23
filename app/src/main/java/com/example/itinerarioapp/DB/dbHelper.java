package com.example.itinerarioapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Vector;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="Itinerario.db";
    public static final String TABLE="Reservaciones";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        //CREA LA BASE DE DATOS
        db.execSQL("CREATE TABLE " + TABLE + "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "area TEXT NOT NULL," +
                "fecha TEXT NOT NULL," +
                "horai TEXT NOT NULL," +
                "horaf TEXT NOT NULL," +
                "nombre TEXT NOT NULL," +
                "actividad TEXT NOT NULL," +
                "telefono TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserta(SQLiteDatabase db){
        db.execSQL("INSERT INTO " + TABLE + "(id,area,fecha,horai,horaf, nombre,actividad, telefono) VALUES (1,'Informatica', '2023-01-01','10:00','10:00','Nay','desa','3421096968')");
    }

    //consulta general
    public String consultar(SQLiteDatabase dbr) {
        int c1;
        String c2,c3,c4,c5,c6,c7,c8,r;
        r="";
        Vector<String> result = new Vector<String>();
        Cursor cursor = dbr.rawQuery("SELECT * FROM " + TABLE + " ORDER BY nombre ", null);
        while (cursor.moveToNext()) {
            c1=cursor.getInt(0);
            c2=cursor.getString(1);
            c3=cursor.getString(2);
            c4=cursor.getString(3);
            c5=cursor.getString(4);
            c6=cursor.getString(5);
            c7=cursor.getString(6);
            c8=cursor.getString(7);
            r=r+c1+ " "+c2+ " " + c3 + " " + c4 + " " + c5+ " " + c6+ " " + c7 + " " + c8+  "\n";
        }
        cursor.close();
        return r;
    }

    //consulta por fecha
   /* public String consultaF(SQLiteDatabase dbr) {
        int c1;
        String c2,c3,c4,c5,c6,c7,c8,r;
        r="";
        Vector<String> result = new Vector<String>();
        Cursor cursor = dbr.rawQuery("SELECT * FROM " + TABLE + " WHERE fecha= '' ", null);
        while (cursor.moveToNext()) {
            c1=cursor.getInt(0);
            c2=cursor.getString(1);
            c3=cursor.getString(2);
            c4=cursor.getString(3);
            c5=cursor.getString(4);
            c6=cursor.getString(5);
            c7=cursor.getString(6);
            c8=cursor.getString(7);
            r=r+c1+ " "+c2+ " " + c3 + " " + c4 + " " + c5+ " " + c6+ " " + c7 + " " + c8+  "\n";
        }
        cursor.close();
        return r;
    }*/

}
