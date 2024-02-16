package com.nike.labtests.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.nike.labtests.R;
import com.nike.labtests.model.Analysis;
import com.nike.labtests.service.AnalysisService;
import com.nike.labtests.service.AnalysisServiceImpl;

import java.util.List;

public class AnalysisListActivity extends BaseActivity {

    private AnalysisService analysisService = new AnalysisServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_list);

        List<Analysis> result = analysisService.getData();

        ListView analysisListView = findViewById(R.id.analysis_list);
        AnalysisListViewAdapter analysisListViewAdapter = new AnalysisListViewAdapter(result, this);

        analysisListView.setAdapter(analysisListViewAdapter);
        analysisListView.setOnItemClickListener((adapterView, view, position, id) -> {
            Analysis analysis = result.get(position);
            Intent intent = new Intent(AnalysisListActivity.this, AnalysisActivity.class);
            intent.putExtra("data", analysis);
            startActivity(intent);
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }
}