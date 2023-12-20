package com.thupq.coffee.controllers;

import com.thupq.coffee.models.request.UserRequest;
import com.thupq.coffee.models.request.UserSearchRequest;
import com.thupq.coffee.models.response.PageResponse;
import com.thupq.coffee.models.response.ResultResponse;
import com.thupq.coffee.models.response.UserResponse;
import com.thupq.coffee.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/i/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signin")
    @Operation(summary = "UserController.signin")
    public String login(@RequestParam String userName, @RequestParam String password) {
        return userService.signin(userName, password);
    }

    @Operation(summary = "Create a users")
    @PostMapping
    public ResultResponse<UserResponse> createTeacher(@Valid @RequestBody UserRequest userRequest) {
        return ResultResponse.success(userService.create(userRequest));
    }

    @Operation(summary = "Get detail of a user")
    @GetMapping("/{id}")
    public ResultResponse<UserResponse> detail(@PathVariable(name = "id") UUID id) {
        return ResultResponse.success(userService.getDetails(id));
    }

    @Operation(summary = "Update a user info")
    @PutMapping("/{id}")
    public ResultResponse<UserResponse> update(@PathVariable("id") UUID id, @Valid @RequestBody UserRequest userUpdateRequest) {
        return ResultResponse.success(userService.update(id, userUpdateRequest));
    }

    @Operation(summary = "Get user list with filter supported")
    @PostMapping("/search")
    public ResultResponse<PageResponse<UserResponse>> search(@RequestBody UserSearchRequest userSearchRequest, Pageable pageable) {
        log.debug("REST request to search Teacher : {}", userSearchRequest);
        PageResponse pageResponse = userService.searchUser(userSearchRequest, pageable);
        return ResultResponse.success(pageResponse);
    }

    @Operation(summary = "Delete a user info (update status = 0 )")
    @PutMapping("/delete/{id}")
    public ResultResponse<String> update(@PathVariable("id") UUID id) {
        return ResultResponse.success(userService.delete(id));
    }

}
