package com.nike.labtests.service;

import androidx.lifecycle.LiveData;

import com.nike.labtests.MyApp;
import com.nike.labtests.model.Analysis;
import com.nike.labtests.persistence.AnalysisResultsRepository;

import java.util.List;

public class AnalysisServiceImpl implements AnalysisService {

	private final AnalysisResultsRepository analysisResultsRepository =
			new AnalysisResultsRepository(MyApp.getContext());

	public LiveData<List<Analysis>> getData() {
		return analysisResultsRepository.getAll();
	}

	public void addAll(final List<Analysis> analysisList) {
		for (Analysis analysis : analysisList) {
			analysisResultsRepository.insertAnalysis(analysis);
		}
	}
}
