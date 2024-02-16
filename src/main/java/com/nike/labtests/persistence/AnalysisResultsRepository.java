package com.nike.labtests.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nike.labtests.model.Analysis;

import java.util.ArrayList;
import java.util.List;

public class AnalysisResultsRepository extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "analysis.db";
    public static final String TABLE_NAME = "analysis_results";

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";

    public static final String CREATE_TABLE_QUERY = "create table " + TABLE_NAME +
            " (" + ID + " integer primary key, " + TITLE + " text, " + DESCRIPTION + " text)";
    public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public AnalysisResultsRepository(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL(DROP_TABLE_QUERY);
        onCreate(database);
    }

    public boolean insert(Analysis analysis) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, analysis.getTitle());
        values.put(DESCRIPTION, analysis.getDescription());

        database.insert(TABLE_NAME, null, values);
        return true;
    }

    public List<Analysis> getAll() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursorAnalysis = database.rawQuery("select * from " + TABLE_NAME, null);

        List<Analysis> analysisList = new ArrayList<>();
        if (cursorAnalysis.moveToFirst()) {
            do {
                Analysis analysis = new Analysis(cursorAnalysis.getString(1), cursorAnalysis.getString(2));
                analysisList.add(analysis);
            } while (cursorAnalysis.moveToNext());
        }

        cursorAnalysis.close();

        return analysisList;
    }
}
