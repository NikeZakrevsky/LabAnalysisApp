package com.nike.labtests.service;

import androidx.lifecycle.LiveData;

import com.nike.labtests.model.Analysis;

import java.util.List;

public interface AnalysisService {
	LiveData<List<Analysis>> getData();
	void addAll(List<Analysis> analysisList);
}
