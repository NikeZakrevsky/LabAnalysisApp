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

    public AnalysisResultsRepository(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(
                "create table " + TABLE_NAME + " (id integer primary key, title text, description text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        database.execSQL("DROP TABLE IF EXISTS analysis_results");
        onCreate(database);
    }

    public boolean insert(Analysis analysis) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", analysis.getTitle());
        values.put("description", analysis.getDescription());

        database.insert(TABLE_NAME, null, values);
        return true;
    }

    public List<Analysis> getAll() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursorAnalysis = database.rawQuery("select * from " + TABLE_NAME, null);

        List<Analysis> analysisList = new ArrayList<>();
        if (cursorAnalysis.moveToFirst()) {
            do {
                Analysis analysis = new Analysis(cursorAnalysis.getString(1), cursorAnalysis.getString(2), 1.0f);
                analysisList.add(analysis);
            } while (cursorAnalysis.moveToNext());
        }

        cursorAnalysis.close();

        return analysisList;
    }
}
