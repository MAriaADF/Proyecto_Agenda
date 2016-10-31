package com.example.hellen.proyecto_agenda;

/**
 * Created by A on 01/05/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHandler extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "datos.db";
        public static final String TABLA_DATOS = "datos";
        public static final String COLUMN_ID = "Id_Datos";
        public static final String COLUMN_TITULO = "Titulo";
        public static final String COLUMN_HORA = "Hora";
        public static final String COLUMN_LUGAR = "Lugar";
        public static String COLUMN_DESCRIP = "Descripcion";


        public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLA_DATOS + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITULO + " TEXT, " +
                    COLUMN_HORA + " INTEGER, " +
                    COLUMN_LUGAR + " TEXT, " +
                    COLUMN_DESCRIP + " TEXT, " +
                    ");";

            db.execSQL(query);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLA_DATOS);
            onCreate(db);
        }

        //Añade un nuevo Row a la Base de Datos

        public void addPersona(Datos datos) {

            ContentValues values = new ContentValues();
            values.put(COLUMN_TITULO, datos.get_Titulo());
            values.put(COLUMN_HORA, datos.get_Hora());
            values.put(COLUMN_LUGAR, datos.get_Lugar());
            values.put(COLUMN_DESCRIP, datos.get_Descripcion());
            SQLiteDatabase db = getWritableDatabase();
            db.insert(TABLA_DATOS, null, values);
            db.close();

        }

        public void updatepersona(Datos datos) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_TITULO, datos.get_Titulo());
            values.put(COLUMN_HORA, datos.get_Hora());
            values.put(COLUMN_LUGAR, datos.get_Lugar());
            values.put(COLUMN_DESCRIP, datos.get_Descripcion());
            SQLiteDatabase db = getWritableDatabase();
            db.update(TABLA_DATOS, values, COLUMN_ID + "= ?", new String[]{String.valueOf(datos.get_Id_Datos())});
            db.close();

        }

        // Borrar una persona de la Base de Datos

        public void borrarPersona(int Id_Dato) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLA_DATOS + " WHERE " + COLUMN_ID + " = " + Id_Dato + ";");
            db.close();
        }

        //listar por id

        public Cursor personabyid(int id) {
            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT * FROM " + TABLA_DATOS + " WHERE " + COLUMN_ID + " = " + id + ";";
            Cursor c = db.rawQuery(query, null);

            if (c != null) {
                c.moveToFirst();
            }

            return c;
        }

        //listar a todas las personas
        public Cursor listarpersonas() {
            SQLiteDatabase db = getReadableDatabase();
            String query = ("SELECT * FROM " + TABLA_DATOS + " WHERE 1 ORDER BY " + COLUMN_TITULO + ";");
            Cursor c = db.rawQuery(query, null);

            if (c != null) {
                c.moveToFirst();
            }
            return c;
        }

    }




