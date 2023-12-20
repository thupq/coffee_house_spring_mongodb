package com.thupq.coffee.service;

import com.thupq.coffee.dto.request.user.UserRequest;
import com.thupq.coffee.dto.request.user.UserSearchRequest;
import com.thupq.coffee.dto.response.PageResponse;
import com.thupq.coffee.dto.response.user.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    UserResponse getDetails(UUID id);

    PageResponse<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable);

    UserResponse update(UUID id, UserRequest userUpdateRequest);

    String delete(UUID id);

    String signin(String userName, String password);
}
