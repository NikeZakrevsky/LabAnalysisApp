package com.nike.labtests.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nike.labtests.model.Analysis;

@Database(entities = {Analysis.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    public abstract AnalysisDao analysisDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "analysis_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
