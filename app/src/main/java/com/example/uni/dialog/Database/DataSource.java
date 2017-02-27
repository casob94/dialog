package com.example.uni.dialog.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.uni.dialog.Database.Objects.Factor;

public class DataSource {

    private static final String LOG_TAG = DataSource.class.getName();

    private String[] _factor_columns = {
            DatabaseHelper.FACTOR_COL_ID,
            DatabaseHelper.FACTOR_COL_FACTOR_MORNING,
            DatabaseHelper.FACTOR_COL_FACTOR_MIDDAY,
            DatabaseHelper.FACTOR_COL_FACTOR_EVENING,
            DatabaseHelper.FACTOR_COL_FACTOR_CORRECTION,
            DatabaseHelper.FACTOR_COL_TIME_MORNING,
            DatabaseHelper.FACTOR_COL_TIME_MIDDAY,
            DatabaseHelper.FACTOR_COL_TIME_EVENING
    };

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

    public Factor cursorToFactor(Cursor fr) {
        int idMorningFactor = fr.getColumnIndex(DatabaseHelper.FACTOR_COL_FACTOR_MORNING);
        int idMiddayFactor = fr.getColumnIndex(DatabaseHelper.FACTOR_COL_FACTOR_MIDDAY);
        int idEveningFactor = fr.getColumnIndex(DatabaseHelper.FACTOR_COL_FACTOR_EVENING);
        int idCorrectionFactor = fr.getColumnIndex(DatabaseHelper.FACTOR_COL_FACTOR_CORRECTION);
        int idMorningTime = fr.getColumnIndex(DatabaseHelper.FACTOR_COL_TIME_MORNING);
        int idMiddayTime = fr.getColumnIndex(DatabaseHelper.FACTOR_COL_TIME_MIDDAY);
        int idEveningTime = fr.getColumnIndex(DatabaseHelper.FACTOR_COL_TIME_EVENING);

        Factor result = new Factor(fr.getDouble(idMorningFactor), fr.getDouble(idMiddayFactor), fr.getDouble(idEveningFactor), fr.getInt(idCorrectionFactor), fr.getInt(idMorningTime), fr.getInt(idMiddayTime), fr.getInt(idEveningTime));
        return result;
    }

    public Factor getFactor() {
        Cursor cursor = _database.query(DatabaseHelper.TABLE_FACTOR, _factor_columns, null, null, null, null, null);
        cursor.moveToFirst();
        return cursorToFactor(cursor);
    }

    public long setFactor(Factor factor) {
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.FACTOR_COL_FACTOR_MORNING, factor.getMorningFactor());
        values.put(DatabaseHelper.FACTOR_COL_FACTOR_MIDDAY, factor.getMiddayFactor());
        values.put(DatabaseHelper.FACTOR_COL_FACTOR_EVENING, factor.getEveningFactor());
        values.put(DatabaseHelper.FACTOR_COL_FACTOR_CORRECTION, factor.getCorrectionFactor());
        values.put(DatabaseHelper.FACTOR_COL_TIME_MORNING, factor.getMorningTimeMinutes());
        values.put(DatabaseHelper.FACTOR_COL_TIME_MIDDAY, factor.getMiddayTimeMinutes());
        values.put(DatabaseHelper.FACTOR_COL_TIME_EVENING, factor.getEveningTimeMinutes());

        long insertId = _database.insert(DatabaseHelper.TABLE_FACTOR, null, values);
        removeFactorExcept(insertId);

        return insertId;
    }

    private void removeFactorExcept(long id) {
        _database.delete(DatabaseHelper.TABLE_FACTOR, DatabaseHelper.FACTOR_COL_ID + "!=" + id, null);
    }
}
