package com.nike.labtests.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResultDto implements Serializable {
    private String name;
    private Float value;
    private String date;
    private String units;
    private Level level;
}
