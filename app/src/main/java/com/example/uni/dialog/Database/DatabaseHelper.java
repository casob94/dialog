package com.example.uni.dialog.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = DatabaseHelper.class.getName();

    public static final String DB_NAME = "dialog.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_GLUCOSE_RECORD = "glucose_record";
    public static final String TABLE_FACTOR = "factor";

    public static final String GLUCOSE_RECORD_COL_ID = "_id";
    public static final String GLUCOSE_RECORD_COL_GLUCOSE = "glucose";
    public static final String GLUCOSE_RECORD_COL_DATE = "date";
    public static final String GLUCOSE_RECORD_COL_CARBONHYDRATE = "carbonhydrate";
    public static final String GLUCOSE_RECORD_COL_INSULIN = "insulin";

    public static final String FACTOR_COL_ID = "_id";
    public static final String FACTOR_COL_FACTOR_MORNING = "factor_morning";
    public static final String FACTOR_COL_FACTOR_MIDDAY = "factor_midday";
    public static final String FACTOR_COL_FACTOR_EVENING = "factor_evening";
    public static final String FACTOR_COL_FACTOR_CORRECTION = "correction_factor";
    public static final String FACTOR_COL_TIME_MORNING = "morning_time";
    public static final String FACTOR_COL_TIME_MIDDAY = "midday_time";
    public static final String FACTOR_COL_TIME_EVENING = "evening_time";

    public static final String SQL_CREATE_GLUCOSE_RECORD = "CREATE TABLE " + TABLE_GLUCOSE_RECORD +
            "(" + GLUCOSE_RECORD_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GLUCOSE_RECORD_COL_GLUCOSE + " INTEGER NOT NULL, " +
            GLUCOSE_RECORD_COL_CARBONHYDRATE + " REAL, " +
            GLUCOSE_RECORD_COL_INSULIN + " INTEGER, " +
            GLUCOSE_RECORD_COL_DATE + " TEXT NOT NULL);";

    public static final String SQL_CREATE_FACTOR = "CREATE TABLE " + TABLE_FACTOR +
            "(" + FACTOR_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FACTOR_COL_FACTOR_MORNING + " REAL NOT NULL, " +
            FACTOR_COL_FACTOR_MIDDAY + " REAL NOT NULL, " +
            FACTOR_COL_FACTOR_EVENING + " REAL NOT NULL, " +
            FACTOR_COL_FACTOR_CORRECTION + " REAL NOT NULL, " +
            FACTOR_COL_TIME_MORNING + " TEXT NOT NULL, " +
            FACTOR_COL_TIME_MIDDAY + " TEXT NOT NULL, " +
            FACTOR_COL_TIME_EVENING + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(SQL_CREATE_GLUCOSE_RECORD);
            db.execSQL(SQL_CREATE_FACTOR);
        } catch(Exception ex) {
            Log.e(LOG_TAG, ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
