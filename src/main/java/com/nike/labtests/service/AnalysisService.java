package com.nike.labtests.service;

import com.nike.labtests.model.Analysis;

import java.util.List;

public interface AnalysisService {
	List<Analysis> getData();
	void addAll(List<Analysis> analysisList);
}
