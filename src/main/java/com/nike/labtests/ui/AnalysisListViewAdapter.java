package com.nike.labtests.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nike.labtests.R;
import com.nike.labtests.model.Analysis;

import java.util.List;

public class AnalysisListViewAdapter extends ArrayAdapter<Analysis> {

    private Activity context;
    private List<Analysis> dataSet;

    public AnalysisListViewAdapter(final List<Analysis> data, final Activity context) {
        super(context, R.layout.analysis_row, data);
        this.dataSet = data;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.analysis_row, parent, false);
        }

        TextView textViewName = currentItemView.findViewById(R.id.analysis_name);
        TextView textViewDescription = currentItemView.findViewById(R.id.analysis_description);

        Analysis analysis = dataSet.get(position);
        textViewName.setText(analysis.getTitle());
        textViewDescription.setText(analysis.getDescription());
        return currentItemView;
    }

    public void setData(List<Analysis> newData) {
        dataSet.clear();
        if (newData != null) {
            dataSet.addAll(newData);
        }
        notifyDataSetChanged();
    }
}
