package com.thupq.coffee.service;

import com.thupq.coffee.models.request.UserRequest;
import com.thupq.coffee.models.request.UserSearchRequest;
import com.thupq.coffee.models.response.PageResponse;
import com.thupq.coffee.models.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse create(UserRequest userRequest);

    UserResponse getDetails(UUID id);

    PageResponse<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable);

    UserResponse update(UUID id, UserRequest userUpdateRequest);

    String delete(UUID id);

    String signin(String userName, String password);
}
