package com.nike.labtests.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnalysisDto implements Serializable {
    private int elementId;
    private String name;
    private String description;
    private String units;
    private List<ResultDto> results;
}
