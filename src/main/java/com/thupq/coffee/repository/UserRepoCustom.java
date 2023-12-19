package com.thupq.coffee.repository;

import com.thupq.coffee.models.request.UserSearchRequest;
import com.thupq.coffee.models.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepoCustom {
    Page<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable);
}
