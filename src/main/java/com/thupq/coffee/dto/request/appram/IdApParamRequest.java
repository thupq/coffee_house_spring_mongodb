package com.thupq.coffee.dto.request.appram;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdApParamRequest {
    private String idApParam;
    private String reason;
}

