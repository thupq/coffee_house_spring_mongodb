package com.thupq.coffee.dto.request.appram;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApCreateRequest {
    private String parGroup;

    private String parType;

    private String parName;

    private String parValue;

    private String description;

    private String isModify;

    private String applicationName;

    private String reason;
}


