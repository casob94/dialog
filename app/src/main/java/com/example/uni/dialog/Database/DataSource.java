package com.example.uni.dialog.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataSource {

    private static final String LOG_TAG = DataSource.class.getName();

    private SQLiteDatabase _database;
    private DatabaseHelper _dbHelper;

    public DataSource(Context context) {
        _dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        _database = _dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Datasource opened");
    }

    public void close() {
        _dbHelper.close();
        Log.d(LOG_TAG, "Datasource closed");
    }
}
