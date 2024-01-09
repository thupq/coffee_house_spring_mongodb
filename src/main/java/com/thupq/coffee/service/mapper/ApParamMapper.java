package com.thupq.coffee.service.mapper;

import com.thupq.coffee.dto.request.appram.ApCreateRequest;
import com.thupq.coffee.dto.request.appram.ApUpdateRequest;
import com.thupq.coffee.entity.ApParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApParamMapper {
    @Mapping(target = "parGroup", expression = "java(apRequest.getParGroup().toUpperCase())")
    @Mapping(target = "parType", expression = "java(apRequest.getParType().toUpperCase())")
    @Mapping(target = "parName", expression = "java(apRequest.getParName().toUpperCase())")
    @Mapping(target = "parValue", expression = "java(apRequest.getParValue().toUpperCase())")
    @Mapping(target = "isModify", defaultValue = "YES")
    ApParam toEntityApParam(ApCreateRequest apRequest);

    @Mapping(target = "id", source = "id")
    ApParam toUpdateEntityApParam(ApUpdateRequest apUpdateRequest, Long id);
}

