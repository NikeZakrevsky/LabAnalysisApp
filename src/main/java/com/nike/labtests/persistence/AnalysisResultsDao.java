package com.nike.labtests.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.nike.labtests.model.AnalysisResult;
import com.nike.labtests.model.AnalysisResultWithInfo;

import java.util.List;

@Dao
public interface AnalysisResultsDao {
    @Insert
    Long insert(AnalysisResult analysis);
    @Transaction
    @Query("SELECT * FROM analysis_results")
    LiveData<List<AnalysisResultWithInfo>> getAnalysisResultsWithInfo();
}
