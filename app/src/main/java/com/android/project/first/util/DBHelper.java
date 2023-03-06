package com.android.project.first.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private final static String name = "banco_db";
    private final static int version = 1;

    public DBHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL("CREATE TABLE IF NOT EXISTS prontuarios(id integer PRIMARY KEY AUTOINCREMENT," +
                    "nome varchar(255), idade integer(3), tempCorporal integer(3), periodoTosse integer(3)," +
                    "periodoDorCabeca integer(3), tempoViagem integer(3), situacao varchar (255))");


            Log.i("INFO DB","Sucesso");
        }catch (Exception e){
            Log.i("INFO DB","Voce falhou miseravelmente" + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE prontuarios");
        onCreate(db);
    }
}
