package com.nike.labtests.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnalysisResultWithInfo implements Serializable {

    @Embedded
    public AnalysisResult analysisResult;

    @Relation(
            parentColumn = "element_id",
            entityColumn = "id"
    )
    public Element element;

    @Relation(
            parentColumn = "element_id",
            entityColumn = "id"
    )
    public AnalysisThreshold analysisThreshold;
}
