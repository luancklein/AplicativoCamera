package app.br.edu.ifc.cameraapp;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter ad;
    ListView listViewThings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buscarDados();
        criarListagem();

    }

    public void buscarDados ()
    {

        try{
            db = openOrCreateDatabase("Tags.db", Context.MODE_PRIVATE, null);
            cursor = db.rawQuery("SELECT * from dataImage", null);
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void criarListagem()
    {
        listViewThings = (ListView) findViewById(R.id.listView);
        String[] from = {"wayToImage", "tagImage"};
        int[] to = {R.id.way, R.id.tag};

        ad = new SimpleCursorAdapter(getApplicationContext(), R.layout.activity_main3, cursor, from, to);

        listViewThings.setAdapter(ad);
    }
}