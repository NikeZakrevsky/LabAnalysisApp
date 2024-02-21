package com.nike.labtests.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "analysis_results",
        foreignKeys = @ForeignKey(entity = Element.class,
                parentColumns = "id",
                childColumns = "element_id"))
public class AnalysisResult implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "element_id")
    private Long elementId;

    @NonNull
    @ColumnInfo(name = "value")
    private Float value;

    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    public AnalysisResult(long elementId, float value, String date) {
        this.elementId = elementId;
        this.value = value;
        this.date = date;
    }
}
