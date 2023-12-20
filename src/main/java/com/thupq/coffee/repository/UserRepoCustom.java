package com.thupq.coffee.repository;

import com.thupq.coffee.models.request.UserSearchRequest;
import com.thupq.coffee.models.response.PageResponse;
import com.thupq.coffee.models.response.UserResponse;
import org.springframework.data.domain.Pageable;

public interface UserRepoCustom {
    PageResponse<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable);
}
