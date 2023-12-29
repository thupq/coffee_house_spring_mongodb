package com.thupq.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ap_param")
public class ApParam {
    public Long id;

    private String parGroup;

    private String parType;

    private String parName;

    private String parValue;

    private String description;

    private String isModify;

    private String applicationName;
}
