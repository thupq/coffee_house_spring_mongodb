package com.thupq.coffee.repository;

import com.thupq.coffee.dto.request.appram.SearchApParamRequest;
import com.thupq.coffee.dto.response.PageResponse;
import com.thupq.coffee.entity.ApParam;
import org.springframework.data.domain.Pageable;

public interface ApParamRepoCustom {
    PageResponse<ApParam> searchApParam(SearchApParamRequest searchApParamRequest, Pageable pageable);

}
