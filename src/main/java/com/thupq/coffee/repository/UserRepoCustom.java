package com.thupq.coffee.repository;

import com.thupq.coffee.dto.request.user.UserSearchRequest;
import com.thupq.coffee.dto.response.PageResponse;
import com.thupq.coffee.dto.response.user.UserResponse;
import org.springframework.data.domain.Pageable;

public interface UserRepoCustom {
    PageResponse<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable);
}
