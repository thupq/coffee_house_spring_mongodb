package com.thupq.coffee.repository.impl;

import com.thupq.coffee.exceptions.CustomizeException;
import com.thupq.coffee.entity.User;
import com.thupq.coffee.dto.request.user.UserSearchRequest;
import com.thupq.coffee.dto.response.PageResponse;
import com.thupq.coffee.dto.response.user.UserResponse;
import com.thupq.coffee.repository.UserRepoCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepoCustom {

    private final MongoTemplate mongoTemplate;

    public PageResponse<UserResponse> searchUser(UserSearchRequest param, Pageable pageable) {
        validateDate(param);
        Criteria criteria = new Criteria();

        if (!ObjectUtils.isEmpty(param)) {
            if (!ObjectUtils.isEmpty(param.getFromDate())) {
                criteria = criteria.and("createDate").gt(param.getFromDate());
            }
            if (!ObjectUtils.isEmpty(param.getToDate())) {
                criteria = criteria.and("createDate").lt(param.getToDate().plusDays(1));
            }
            if (!StringUtils.isEmpty(param.getUserName())) {
                criteria = criteria.and("userName").is(param.getUserName());
            }
        }

        Query query = new Query(criteria);
        long total = mongoTemplate.count(query, User.class);

        if (pageable != null) {
            query = query.with(pageable);
        }

        List<UserResponse> userResponses = mongoTemplate.find(query, User.class)
                .stream()
                .map(this::convertToUserResponse)
                .collect(Collectors.toList());

        return new PageResponse<>(userResponses, pageable.getPageNumber(), pageable.getPageSize(), total);
    }


    private void validateDate(UserSearchRequest param) {
        if (param.getFromDate() == null) {
            throw new CustomizeException("Từ ngày không được để trống!", "ERR01");
        }
        if (param.getToDate() == null) {
            throw new CustomizeException("Đến ngày không được để trống!", "ERR02");
        }
        if (param.getToDate().isBefore(param.getFromDate())) {
            throw new CustomizeException("Từ ngày không được > đến ngày!", "ERR03");
        }
    }

    public UserResponse convertToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setCode(user.getCode());
        userResponse.setUserName(user.getUserName());
        userResponse.setFullName(user.getFullName());
        userResponse.setContactPhone(user.getContactPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setGender(user.getGender());
        userResponse.setDescription(user.getDescription());
        userResponse.setStatus(user.getStatus());
        userResponse.setCreateDate(user.getCreateDate());
        userResponse.setCreateBy(user.getCreateBy());
        userResponse.setUpdateDate(user.getUpdateDate());
        userResponse.setUpdateBy(user.getUpdateBy());
        return userResponse;
    }

}
