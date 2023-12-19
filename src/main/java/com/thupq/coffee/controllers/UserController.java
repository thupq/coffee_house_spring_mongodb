package com.thupq.coffee.controllers;

import com.thupq.coffee.models.request.UserRequest;
import com.thupq.coffee.models.request.UserSearchRequest;
import com.thupq.coffee.models.response.RestResult;
import com.thupq.coffee.models.response.UserResponse;
import com.thupq.coffee.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/i/users")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @PostMapping("/signin")
    @Operation(summary =  "UserController.signin")
    public String login( @RequestParam String userName, @RequestParam String password) {
        return userService.signin(userName, password);
    }

    @Operation(summary = "Create a users")
    @PostMapping
    public ResponseEntity<RestResult<UserResponse>> createTeacher(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(RestResult.ok(userService.create(userRequest)));
    }

    @Operation(summary = "Get detail of a user")
    @GetMapping("/{id}")
    public ResponseEntity<RestResult<UserResponse>> detail(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok(RestResult.ok(userService.getDetails(id)));
    }

    @Operation(summary = "Update a user info")
    @PutMapping("/{id}")
    public ResponseEntity<RestResult<UserResponse>> update(@PathVariable("id") UUID id, @Valid @RequestBody UserRequest userUpdateRequest) {
        return ResponseEntity.ok(RestResult.ok(userService.update(id,userUpdateRequest)));
    }

    @Operation(summary = "Get user list with filter supported")
    @PostMapping("/search")
    public ResponseEntity<RestResult<Page<UserResponse>>> search(@RequestBody UserSearchRequest userSearchRequest, Pageable pageable) {
        log.debug("REST request to search Teacher : {}", userSearchRequest);
        return ResponseEntity.ok(RestResult.ok(userService.searchUser(userSearchRequest, pageable)));
    }

    @Operation(summary = "Delete a user info (update status = 0 )")
    @PutMapping("/delete/{id}")
    public ResponseEntity<RestResult<String>> update(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(RestResult.ok(userService.delete(id)));
    }

}
