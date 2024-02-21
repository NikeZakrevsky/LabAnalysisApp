package com.nike.labtests.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.nike.labtests.model.AnalysisResult;
import com.nike.labtests.model.AnalysisResultWithInfo;

import java.util.List;
import java.util.concurrent.Executors;

public class AnalysisResultsRepository {
    private AnalysisResultsDao analysisResultsDao;
    private final ListeningExecutorService executorService;

    public AnalysisResultsRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        analysisResultsDao = db.analysisWithResultsDao();
        executorService = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());
    }

    public ListenableFuture<Long> insertAnalysis(final AnalysisResult analysisResult) {
        return executorService.submit(() -> analysisResultsDao.insert(analysisResult));
    }

    public LiveData<List<AnalysisResultWithInfo>> getAll() {
        return analysisResultsDao.getAnalysisResultsWithInfo();
    }
}
