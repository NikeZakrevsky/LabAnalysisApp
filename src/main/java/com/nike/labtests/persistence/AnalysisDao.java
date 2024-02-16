package com.nike.labtests.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.nike.labtests.model.Analysis;

import java.util.List;

@Dao
public interface AnalysisDao {
    @Insert
    void insert(Analysis analysis);

    @Query("SELECT * FROM analysis_results")
    LiveData<List<Analysis>> getAll();
}
