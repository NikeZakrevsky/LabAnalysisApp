package com.nike.labtests.conterter;

import com.nike.labtests.dto.AnalysisDto;
import com.nike.labtests.dto.Level;
import com.nike.labtests.dto.ResultDto;
import com.nike.labtests.model.AnalysisResultWithInfo;
import com.nike.labtests.service.AnalysisService;
import com.nike.labtests.service.AnalysisServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalysisToAnalysisDtoConverter implements Converter<List<AnalysisDto>, List<AnalysisResultWithInfo>> {

    private AnalysisService analysisService = new AnalysisServiceImpl();

    public List<AnalysisDto> convert(final List<AnalysisResultWithInfo> analysisResultWithInfo) {
        Map<Integer, AnalysisDto> result = new HashMap<>();
        for (AnalysisResultWithInfo resultWithInfo : analysisResultWithInfo) {
            Level level = analysisService.getLevel(resultWithInfo);
            if (!result.containsKey(resultWithInfo.getElement().getId())) {
                List<ResultDto> results = new ArrayList<>();
                ResultDto resultDto = new ResultDto(resultWithInfo.getElement().getName(),
                        resultWithInfo.getAnalysisResult().getValue(), resultWithInfo.getAnalysisResult().getDate(),
                        resultWithInfo.getElement().getUnits(), level);
                results.add(resultDto);
                result.put(resultWithInfo.getElement().getId(),
                        new AnalysisDto(
                                resultWithInfo.getElement().getId(),
                                resultWithInfo.getElement().getName(),
                                resultWithInfo.getElement().getDescription(),
                                resultWithInfo.getElement().getUnits(),
                                results
                        ));
            } else {
                AnalysisDto analysisDto = result.get(resultWithInfo.getElement().getId());
                ResultDto resultDto = new ResultDto(resultWithInfo.getElement().getName(),
                        resultWithInfo.getAnalysisResult().getValue(), resultWithInfo.getAnalysisResult().getDate(),
                        resultWithInfo.getElement().getUnits(), level);
                analysisDto.getResults().add(resultDto);
            }
        }

        return new ArrayList<>(result.values());
    }

}
