package com.nike.labtests.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.nike.labtests.R;
import com.nike.labtests.model.Analysis;

public class AnalysisActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        Analysis analysis = (Analysis) getIntent().getSerializableExtra("data");

        TextView textViewName = findViewById(R.id.title);
        textViewName.setText(analysis.getTitle());
    }
}