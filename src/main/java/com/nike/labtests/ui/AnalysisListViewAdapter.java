package com.nike.labtests.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nike.labtests.R;
import com.nike.labtests.dto.AnalysisDto;
import com.nike.labtests.dto.ResultDto;

import java.util.List;

public class AnalysisListViewAdapter extends ArrayAdapter<AnalysisDto> {

    private List<AnalysisDto> dataSet;

    public AnalysisListViewAdapter(final List<AnalysisDto> data, final Activity context) {
        super(context, R.layout.analysis_row, data);
        this.dataSet = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.analysis_row, parent, false);
        }

        TextView textViewName = currentItemView.findViewById(R.id.analysis_name);
        TextView textViewValue= currentItemView.findViewById(R.id.analysis_value);
        TextView textViewDescription = currentItemView.findViewById(R.id.analysis_description);
        ImageView analysisIcon = currentItemView.findViewById(R.id.analysis_icon);

        AnalysisDto analysis = dataSet.get(position);
        textViewName.setText(analysis.getName());
        textViewDescription.setText(analysis.getDescription());
        List<ResultDto> results = analysis.getResults();
        ResultDto lastResultDto = results.get(results.size() - 1);
        if (results.size() > 0) {
            textViewValue.setText(lastResultDto.getValue() + " " + analysis.getUnits());
        }

        switch (lastResultDto.getLevel()) {
            case LOW:
                analysisIcon.setImageResource(R.drawable.arrow_downward);
                break;
            case HIGH:
                analysisIcon.setImageResource(R.drawable.arrow_upward);
                break;
            case NORMAL:
                analysisIcon.setImageResource(R.drawable.checkmark);
                break;
        }

        return currentItemView;
    }

    public void setData(List<AnalysisDto> newData) {
        dataSet.clear();
        if (newData != null) {
            dataSet.addAll(newData);
        }
        notifyDataSetChanged();
    }
}
