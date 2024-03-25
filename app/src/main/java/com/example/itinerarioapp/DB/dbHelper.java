package com.example.itinerarioapp.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.itinerarioapp.Objetos.Tarjeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="Itinerario.db";
    public static final String TABLE="Reservaciones";

    static int c1;
     static String c2,c3,c4,c5,c6,c7,c8;

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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    public void inserta(SQLiteDatabase db){
        db.execSQL("INSERT INTO " + TABLE + "(id, area, fecha, horai, horaf, nombre, actividad, telefono) VALUES (14, 'Informatica', '2024-02-14', '10:00', '10:00', 'Nay', 'desa', '3421096968')");
    }

    //consulta general
    public List<Tarjeta> getAllTarjetas(SQLiteDatabase dbr) {
        List<Tarjeta> tarjetas = new ArrayList<>();
        Cursor cursor = dbr.rawQuery("SELECT * FROM " + TABLE, null);

        while (cursor.moveToNext()) {
            c1 = cursor.getInt(0);
            c2 = cursor.getString(1);
            c3 = cursor.getString(2);
            c4 = cursor.getString(3);
            c5 = cursor.getString(4);
            c6 = cursor.getString(5);
            c7 = cursor.getString(6);
            c8 = cursor.getString(7);

            Tarjeta tarjeta = new Tarjeta(c1,c2,c3,c4,c5,c6, c7,c8);
            tarjetas.add(tarjeta);
        }
        cursor.close();
        return tarjetas;
    }

    //consulta por fecha
    public static List<Tarjeta> getAllTarjetasFecha(SQLiteDatabase dbr, String date) {
        List<Tarjeta> tarjetas = new ArrayList<>();
       // Cursor cursor = dbr.rawQuery("SELECT * FROM " + TABLE +" WHERE fecha='"+date+"'", null);
        Cursor cursor = dbr.rawQuery("SELECT * FROM " + TABLE +" WHERE fecha='" + String.format("%1$tY-%1$tm-%1$td", date) + "'", null);


        // Log para verificar la consulta SQL
        Log.d("Consulta SQL", "SELECT * FROM " + TABLE +" WHERE fecha='"+date+"'");

        while (cursor.moveToNext()) {
            c1 = cursor.getInt(0);
            c2 = cursor.getString(1);
            c3 = cursor.getString(2);
            c4 = cursor.getString(3);
            c5 = cursor.getString(4);
            c6 = cursor.getString(5);
            c7 = cursor.getString(6);
            c8 = cursor.getString(7);

            Tarjeta tarjeta = new Tarjeta(c1,c2,c3,c4,c5,c6, c7,c8);
            tarjetas.add(tarjeta);
        }
        cursor.close();

        // Log para verificar el tamaño de la lista de tarjetas
        Log.d("Tamaño de la lista", String.valueOf(tarjetas.size()));

        return tarjetas;
    }



}
