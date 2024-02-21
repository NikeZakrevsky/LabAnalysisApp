package com.nike.labtests.ui;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.nike.labtests.R;
import com.nike.labtests.dto.AnalysisDto;

public class AnalysisActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        AnalysisDto analysisWithResults = (AnalysisDto) getIntent().getSerializableExtra("data");

        TextView resultName = findViewById(R.id.result_name);
        resultName.setText(analysisWithResults.getName());

        TextView resultDescription = findViewById(R.id.result_description);
        resultDescription.setText(analysisWithResults.getDescription());

        ResultsListViewAdapter resultsListViewAdapter = new ResultsListViewAdapter(analysisWithResults.getResults(), this);
        ListView resultsListView = findViewById(R.id.results_list);
        resultsListView.setAdapter(resultsListViewAdapter);
    }
}