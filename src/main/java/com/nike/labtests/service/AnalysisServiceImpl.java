package com.nike.labtests.service;

import com.nike.labtests.MyApp;
import com.nike.labtests.model.Analysis;
import com.nike.labtests.persistence.AnalysisResultsRepository;

import java.util.List;

public class AnalysisServiceImpl implements AnalysisService {

	private final AnalysisResultsRepository analysisResultsRepository =
			new AnalysisResultsRepository(MyApp.getContext());

	public List<Analysis> getData() {

		List<Analysis> data = analysisResultsRepository.getAll();

		return data;
	}

	public void addAll(final List<Analysis> analysisList) {
		for (Analysis analysis : analysisList) {
			analysisResultsRepository.insert(analysis);
		}
	}
}
