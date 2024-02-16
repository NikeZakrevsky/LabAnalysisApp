package com.nike.labtests.ui;

import android.content.Intent;
import android.os.Bundle;

import com.nike.labtests.R;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startAnalysisListActivity();
    }

    private void startAnalysisListActivity() {
        Intent intent = new Intent(MainActivity.this, AnalysisListActivity.class);
        startActivity(intent);
    }
}