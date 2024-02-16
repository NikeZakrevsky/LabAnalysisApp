package com.nike.labtests.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.nike.labtests.model.Analysis;

import java.util.List;

public class AnalysisResultsRepository {

    private AnalysisDao analysisDao;

    public AnalysisResultsRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        analysisDao = db.analysisDao();
    }

    public void insertAnalysis(final Analysis analysis) {
        new Thread(() -> analysisDao.insert(analysis)).start();
    }

    public LiveData<List<Analysis>> getAll() {
        return analysisDao.getAll();
    }
}
