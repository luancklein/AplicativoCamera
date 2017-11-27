package app.br.edu.ifc.cameraapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String BANCO_DADOS = "Tags";
    private static int VERSAO = 1;

    public DatabaseHelper(Context context)
    {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE dataImage (_id INTEGER PRIMARY KEY, wayToImage TEXT, imageTag TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}


}
