package com.thupq.coffee.dto.response.apparam;

import com.thupq.coffee.entity.ApParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApParamResponse {
    private Long id;

    private String parGroup;

    private String parType;

    private String parName;

    private String parValue;

    private String description;

    private String isModify;

    private List<String> applicationName;


    public static ApParamResponse createResponse(ApParam apParam) {
        List<String> listApp = Collections.emptyList();

        if (!StringUtils.isEmpty(apParam.getApplicationName())) {
            listApp = Arrays.asList(apParam.getApplicationName().split(","));
        }

        return ApParamResponse.builder()
                .id(apParam.getId())
                .parGroup(apParam.getParGroup())
                .parName(apParam.getParName())
                .parType(apParam.getParType())
                .parValue(apParam.getParValue())
                .isModify(apParam.getIsModify())
                .description(apParam.getDescription())
                .applicationName(listApp)
                .build();
    }

}
