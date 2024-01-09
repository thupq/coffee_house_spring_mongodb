package com.thupq.coffee.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "ap_param")
public class ApParam {
    @Id
    public Long id;

    private String parGroup;

    private String parType;

    private String parName;

    private String parValue;

    private String description;

    private String isModify;

    private String applicationName;
}
