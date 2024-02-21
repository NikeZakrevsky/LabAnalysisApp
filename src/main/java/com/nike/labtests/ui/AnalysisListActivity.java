package com.nike.labtests.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.lifecycle.Observer;

import com.nike.labtests.R;
import com.nike.labtests.dto.AnalysisDto;
import com.nike.labtests.model.AnalysisResultWithInfo;
import com.nike.labtests.service.AnalysisService;
import com.nike.labtests.service.AnalysisServiceImpl;
import com.nike.labtests.conterter.AnalysisToAnalysisDtoConverter;

import java.util.ArrayList;
import java.util.List;

public class AnalysisListActivity extends BaseActivity {

    private AnalysisService analysisService = new AnalysisServiceImpl();
    private AnalysisToAnalysisDtoConverter analysisDtoConverter = new AnalysisToAnalysisDtoConverter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_list);
        ListView analysisListView = findViewById(R.id.analysis_list);

        AnalysisListViewAdapter analysisListViewAdapter =
                new AnalysisListViewAdapter(new ArrayList<>(), this);
        analysisListView.setAdapter(analysisListViewAdapter);

        analysisService.getAnalysisWithResults().observe(this, new Observer<List<AnalysisResultWithInfo>>() {
            @Override
            public void onChanged(List<AnalysisResultWithInfo> analysisResultWithInfo) {
                List<AnalysisDto> result = analysisDtoConverter.convert(analysisResultWithInfo);
                analysisListViewAdapter.setData(result);
            }
        });

        analysisListView.setOnItemClickListener((adapterView, view, position, id) -> {
            AnalysisDto analysisDto = analysisListViewAdapter.getItem(position);
            Intent intent = new Intent(AnalysisListActivity.this, AnalysisActivity.class);
            intent.putExtra("data", analysisDto);
            startActivity(intent);
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }
}