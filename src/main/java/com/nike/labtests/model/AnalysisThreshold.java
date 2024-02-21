package com.nike.labtests.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "analysis_thresholds",
        foreignKeys = @ForeignKey(entity = Element.class,
                parentColumns = "id",
                childColumns = "element_id"))
public class AnalysisThreshold {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "element_id")
    private Integer elementId;

    @NonNull
    @ColumnInfo(name = "age_min")
    private int ageMin;

    @NonNull
    @ColumnInfo(name = "age_max")
    private int ageMax;

    @NonNull
    @ColumnInfo(name = "threshold_min")
    private float thresholdMin;

    @NonNull
    @ColumnInfo(name = "threshold_max")
    private float thresholdMax;

    @NonNull
    @ColumnInfo(name = "sex")
    private String sex;
}
