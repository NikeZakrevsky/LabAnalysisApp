package com.nike.labtests.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.nike.labtests.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class MainActivity extends BaseActivity {

    private static final String PREFS_NAME = "MyPrefsFile";
    private static final String DB_COPIED_KEY = "db_copied";
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isDbCopied = prefs.getBoolean(DB_COPIED_KEY, false);
        isDbCopied=false;
        if (!isDbCopied) {
            // Если файл еще не скопирован, копируем его
            copyDatabaseFile();
            // Обновляем флаг, указывающий на то, что файл скопирован
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(DB_COPIED_KEY, true);
            editor.apply();
        }

        startAnalysisListActivity();
    }

    private void copyDatabaseFile() {
        InputStream inputStream = getResources().openRawResource(R.raw.analysis_database);
        File destinationFile = getDatabasePath("analysis_database.sqlite");
        try {
            OutputStream outputStream = Files.newOutputStream(destinationFile.toPath());
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startAnalysisListActivity() {
        Intent intent = new Intent(MainActivity.this, AnalysisListActivity.class);
        startActivity(intent);
    }
}