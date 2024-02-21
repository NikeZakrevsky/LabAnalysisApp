package com.nike.labtests.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.nike.labtests.model.AnalysisResult;
import com.nike.labtests.model.AnalysisThreshold;
import com.nike.labtests.model.Element;

@Database(entities = {AnalysisResult.class, Element.class, AnalysisThreshold.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
        }
    };

    public abstract AnalysisResultsDao analysisWithResultsDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "analysis_database.sqlite")
                    .addMigrations(MIGRATION_5_6)
                    .build();
        }
        return instance;
    }
}
