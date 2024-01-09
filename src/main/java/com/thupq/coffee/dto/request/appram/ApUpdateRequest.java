package com.thupq.coffee.dto.request.appram;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApUpdateRequest {

    private String description;

    private String applicationName;

    private String parValue;

    private String reason;
}


