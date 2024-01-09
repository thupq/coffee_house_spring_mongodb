package com.thupq.coffee.service;

import com.thupq.coffee.dto.request.appram.ApCreateRequest;
import com.thupq.coffee.dto.request.appram.ApUpdateRequest;
import com.thupq.coffee.dto.request.appram.IdApParamRequest;
import com.thupq.coffee.dto.request.appram.SearchApParamRequest;
import com.thupq.coffee.dto.response.ResultResponse;
import com.thupq.coffee.dto.response.apparam.ApParamResponse;
import com.thupq.coffee.entity.ApParam;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ApParamService {
    List<ApParam> loadParamByGroup(String groupCode, String parType);

    ResultResponse<List<ApParam>> searchApParam(SearchApParamRequest searchApParamRequest, Pageable pageable);

    ApParam create(ApCreateRequest apRequest) throws IllegalAccessException, NoSuchFieldException;

    ApParam update(Long id, ApUpdateRequest apUpdateRequest) throws IllegalAccessException, NoSuchFieldException;

    ApParamResponse getDetail(IdApParamRequest idApParamRequest);

    ApParam delete(IdApParamRequest idApParamRequest) throws NoSuchFieldException, IllegalAccessException;

    List<String> loadValueToSearch(String value);

}
