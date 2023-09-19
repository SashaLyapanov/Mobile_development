package com.labsmobilka.lab5;

import static android.app.DownloadManager.COLUMN_ID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    Button buttonAdd, buttonRead, buttonClear, buttonUpdate, buttonFindByID;
    EditText editName, editEmail, necId;
    TextView dataFromDB;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = (Button) findViewById(R.id.button);
        buttonAdd.setOnClickListener(this:: onClick);
        buttonRead = (Button) findViewById(R.id.button2);
        buttonRead.setOnClickListener(this:: onClick);
        buttonClear = (Button) findViewById(R.id.button3);
        buttonClear.setOnClickListener(this:: onClick);
        buttonUpdate = (Button) findViewById(R.id.button4);
        buttonUpdate.setOnClickListener(this:: onClick);
        buttonFindByID = (Button) findViewById(R.id.button5);
        buttonFindByID.setOnClickListener(this:: onClick);
        editName = (EditText) findViewById(R.id.editText1);
        editEmail = (EditText) findViewById(R.id.editText2);
        necId = (EditText) findViewById(R.id.editText3);
        dataFromDB = (TextView) findViewById(R.id.dataFromDB);
        dbHelper = new DBHelper(this);
    }


    protected void onClick(View v) {
        //создаем объект для данных
        ContentValues cv = new ContentValues();

        //подключаемя к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (v.getId() == R.id.button) {
            String name = editName.getText().toString();
            String email = editEmail.getText().toString();
            Log.d(LOG_TAG, "---Insert in mytable: ---");
            //Подготовим данные для вставки в виде пар: наименование стоблца - значение
            cv.put("name", name);
            cv.put("email", email);
            //Вставляем запись и получаем ее id
            long rowId = db.insert("mytable", null, cv);
            Log.d(LOG_TAG, "row inserted, ID = " + rowId);
            editName.setText(null);
            editEmail.setText(null);
            necId.setText(null);
        }
        if (v.getId() == R.id.button2) {
            Log.d(LOG_TAG, "---Read from database: ---");
            //Делаем запрос всех хранящихся данных в таблице и получаем объект Cursor
            Cursor cursor = db.query("mytable", null, null, null, null, null, null);
            //Ставим позицию курсор на первую строку выборки. Если же в полученной выборке нет строк, вернется false
            if (cursor.moveToFirst()) {
                //Определяем номер столбцов по имени в выборке
                int idColIndex = cursor.getColumnIndex("id");
                int nameColIndex = cursor.getColumnIndex("name");
                int emailColIndex = cursor.getColumnIndex("email");
                do {
                    //получаем значения по номерам столбцов и пишем все в лог
                    Log.d(LOG_TAG,"ID = " + cursor.getInt(idColIndex) + ", name = "
                            + cursor.getString(nameColIndex) + ", email = "
                            + cursor.getString(emailColIndex));
                } while (cursor.moveToNext());
            } else
                Log.d(LOG_TAG, "0 rows");
            cursor.close();
        }
        if (v.getId() == R.id.button3) {
            Log.d(LOG_TAG, "---Clear mytable: ---");
            int clearCount = db.delete("mytable", null, null);
            Log.d(LOG_TAG, "deleted rows count = " + clearCount);
            editName.setText(null);
            editEmail.setText(null);
            necId.setText(null);
            }
        if (v.getId() == R.id.button4) {
            String name = editName.getText().toString();
            String email = editEmail.getText().toString();
            Log.d(LOG_TAG, "---Update" + necId.getText().toString() + " row: ---");
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("email", email);
            db.update("mytable", contentValues,  "id =" + necId.getText().toString(), null);
            editName.setText(null);
            editEmail.setText(null);
            necId.setText(null);
        }
        if (v.getId() == R.id.button5) {
            String id = necId.getText().toString();
            if (id != null) {
                Cursor cursor = db.rawQuery("select * from mytable where ID=?", new String[]{String.valueOf(id)});
                cursor.moveToFirst();
                int nameColIndex = cursor.getColumnIndex("name");
                int emailColIndex = cursor.getColumnIndex("email");
                String name = cursor.getString(nameColIndex);
                String email = cursor.getString(emailColIndex);
                dataFromDB.setText(name + " " + email);
            }
        }
        dbHelper.close();
        }

    class DBHelper extends SQLiteOpenHelper {
        public static final String COLUMN_ID = "id";

        public DBHelper(Context context) {
            super(context, "myDB", null, 1);
        }
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "---onCreate database");
            //создаем таблицу и необходимые поля
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "email text" + ");");
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

