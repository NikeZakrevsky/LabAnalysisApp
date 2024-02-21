package com.nike.labtests.service;

import androidx.lifecycle.LiveData;

import com.google.common.util.concurrent.ListenableFuture;
import com.nike.labtests.MyApp;
import com.nike.labtests.dto.Level;
import com.nike.labtests.model.AnalysisResult;
import com.nike.labtests.model.AnalysisResultWithInfo;
import com.nike.labtests.persistence.AnalysisResultsRepository;

import java.util.List;

public class AnalysisServiceImpl implements AnalysisService {

	private final AnalysisResultsRepository analysisRepository =
			new AnalysisResultsRepository(MyApp.getContext());

	private final AnalysisResultsRepository analysisResultsRepository =
			new AnalysisResultsRepository(MyApp.getContext());

	public LiveData<List<AnalysisResultWithInfo>> getAnalysisWithResults() {
		return analysisRepository.getAll();
	}

	@Override
	public Level getLevel(AnalysisResultWithInfo resultWithInfo) {
		if (resultWithInfo.getAnalysisThreshold() != null) {
			float thresholdMin = resultWithInfo.getAnalysisThreshold().getThresholdMin();
			float thresholdMax = resultWithInfo.getAnalysisThreshold().getThresholdMax();
			float value = resultWithInfo.getAnalysisResult().getValue();

			if (value < thresholdMin) {
				return Level.LOW;
			} else if (value >= thresholdMin && value <= thresholdMax) {
				return Level.NORMAL;
			} else if (value > thresholdMax) {
				return Level.HIGH;
			}
		}
		return Level.UNKNOWN;
	}

	@Override
	public ListenableFuture<Long> addResult(AnalysisResult analysisResult) {
		return analysisResultsRepository.insertAnalysis(analysisResult);
	}
}
