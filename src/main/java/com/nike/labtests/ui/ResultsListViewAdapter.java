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
import com.nike.labtests.dto.ResultDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ResultsListViewAdapter extends ArrayAdapter<ResultDto> {

    private List<ResultDto> dataSet;

    public ResultsListViewAdapter(final List<ResultDto> data, final Activity context) {
        super(context, R.layout.analysis_row, data);
        this.dataSet = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.result_row, parent, false);
        }

        TextView resultValue = currentItemView.findViewById(R.id.result_value);
        TextView resultDate = currentItemView.findViewById(R.id.result_date);
        ImageView removeImageView = currentItemView.findViewById(R.id.result_remove_icon);
        ImageView resultImageView = currentItemView.findViewById(R.id.result_icon);

        ResultDto resultDto = dataSet.get(position);
        removeImageView.setImageResource(R.drawable.ic_clear);
        resultValue.setText(resultDto.getValue() + " " + resultDto.getUnits());
        resultDate.setText(changeDateFormat(resultDto.getDate()));

        switch (resultDto.getLevel()) {
            case LOW:
                resultImageView.setImageResource(R.drawable.arrow_downward);
                break;
            case HIGH:
                resultImageView.setImageResource(R.drawable.arrow_upward);
                break;
            case NORMAL:
                resultImageView.setImageResource(R.drawable.checkmark);
                break;
        }

        return currentItemView;
    }

    private String changeDateFormat(String date) {
        try {
            SimpleDateFormat originDateFormat = new SimpleDateFormat("MM/dd/yyy", Locale.getDefault());
            Date originDate = originDateFormat.parse(date);
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyy", new Locale("ru"));
            return newDateFormat.format(originDate);
        } catch (ParseException e) {
            return date;
        }
    }

    public void setData(List<ResultDto> newData) {
        dataSet.clear();
        if (newData != null) {
            dataSet.addAll(newData);
        }
        notifyDataSetChanged();
    }
}
