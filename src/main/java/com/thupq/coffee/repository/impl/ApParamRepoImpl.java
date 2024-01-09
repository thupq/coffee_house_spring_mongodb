package com.thupq.coffee.repository.impl;

import com.thupq.coffee.dto.request.appram.SearchApParamRequest;
import com.thupq.coffee.dto.response.PageResponse;
import com.thupq.coffee.entity.ApParam;
import com.thupq.coffee.repository.ApParamRepoCustom;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ApParamRepoImpl implements ApParamRepoCustom {

    private final MongoTemplate mongoTemplate;

    @Override
    public PageResponse<ApParam> searchApParam(SearchApParamRequest searchApParamRequest, Pageable pageable) {
        Criteria criteria = new Criteria();

        if (!StringUtils.isEmpty(searchApParamRequest.getParGroup())) {
            criteria = criteria.and("UPPER(PAR_GROUP)").is(searchApParamRequest.getParGroup().toUpperCase());
        }

        if (!StringUtils.isEmpty(searchApParamRequest.getParType())) {
            criteria = criteria.and("PAR_TYPE").is(searchApParamRequest.getParType());
        }

        if (!StringUtils.isEmpty(searchApParamRequest.getApplicationName())) {
            criteria = criteria.and("APPLICATION_NAME").is(searchApParamRequest.getApplicationName());
        }

        Query query = new Query(criteria);
        long total = mongoTemplate.count(query, ApParam.class);

        if (pageable != null) {
            query = query.with(pageable);
        }

        List<ApParam> apParams = mongoTemplate.find(query, ApParam.class)
                .stream()
                .collect(Collectors.toList());
        return new PageResponse<>(apParams, pageable.getPageNumber(), pageable.getPageSize(), total);
    }
}
