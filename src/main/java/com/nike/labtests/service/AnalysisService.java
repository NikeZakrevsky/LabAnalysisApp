package com.nike.labtests.service;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;
import com.nike.labtests.dto.Level;
import com.nike.labtests.model.AnalysisResult;
import com.nike.labtests.model.AnalysisResultWithInfo;

import java.util.List;

public interface AnalysisService {

	ListenableFuture<Long> addResult(final AnalysisResult analysisResult);

	LiveData<List<AnalysisResultWithInfo>> getAnalysisWithResults();

    Level getLevel(AnalysisResultWithInfo resultWithInfo);
}
