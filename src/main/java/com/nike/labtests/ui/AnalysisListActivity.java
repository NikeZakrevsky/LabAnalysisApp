package com.nike.labtests.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.nike.labtests.R;
import com.nike.labtests.model.Analysis;
import com.nike.labtests.service.AnalysisService;
import com.nike.labtests.service.AnalysisServiceImpl;

import java.util.ArrayList;

public class AnalysisListActivity extends BaseActivity {

    private AnalysisService analysisService = new AnalysisServiceImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_list);
        ListView analysisListView = findViewById(R.id.analysis_list);

        AnalysisListViewAdapter analysisListViewAdapter =
                new AnalysisListViewAdapter(new ArrayList<>(), this);
        analysisListView.setAdapter(analysisListViewAdapter);

        analysisService.getData().observe(this, analysisListViewAdapter::setData);

        analysisListView.setOnItemClickListener((adapterView, view, position, id) -> {
            Analysis analysis = analysisListViewAdapter.getItem(position);
            Intent intent = new Intent(AnalysisListActivity.this, AnalysisActivity.class);
            intent.putExtra("data", analysis);
            startActivity(intent);
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }
}