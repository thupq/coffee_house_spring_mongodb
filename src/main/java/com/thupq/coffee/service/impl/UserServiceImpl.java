package com.thupq.coffee.service.impl;

import com.thupq.coffee.common.Constants;
import com.thupq.coffee.common.MessageCode;
import com.thupq.coffee.configurations.security.UserAuthenticationProvider;
import com.thupq.coffee.exceptions.CustomizeException;
import com.thupq.coffee.entity.User;
import com.thupq.coffee.dto.request.user.UserRequest;
import com.thupq.coffee.dto.request.user.UserSearchRequest;
import com.thupq.coffee.dto.response.PageResponse;
import com.thupq.coffee.dto.response.user.UserResponse;
import com.thupq.coffee.repository.UserRepoCustom;
import com.thupq.coffee.repository.UserRepository;
import com.thupq.coffee.service.UserService;
import com.thupq.coffee.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.CharBuffer;
import java.util.Date;
import java.util.UUID;

import static com.thupq.coffee.common.MessageUtils.getMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserRepoCustom userRepoCustom;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @Override
    @Transactional
    public UserResponse create(UserRequest userRequest) {
        User user = userMapper.toEntityCreate(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserResponse getDetails(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new CustomizeException(getMessage(MessageCode.Teacher.NOT_EXISTS)));
    }

    @Override
    public PageResponse<UserResponse> searchUser(UserSearchRequest userSearchRequest, Pageable pageable) {
        return userRepoCustom.searchUser(userSearchRequest, pageable);
    }

    @Override
    @Transactional
    public UserResponse update(UUID id, UserRequest userUpdateRequest) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new CustomizeException(getMessage(MessageCode.Teacher.NOT_EXISTS))
        );
        userMapper.partialUpdate(user, userUpdateRequest);
        user.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public String delete(UUID id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new CustomizeException(getMessage(MessageCode.Teacher.NOT_EXISTS))
        );
        user.setStatus(Constants.STATUS_INACTIVE);
        user.setUpdateBy("System");
        user.setUpdateDate(new Date(System.currentTimeMillis()));
        try {
            userRepository.save(user);
            return "Success";
        } catch (Exception ex) {
            return "Failed";
        }
    }

    @Override
    public String signin(String userName, String password) {
        User user = userRepository.findByUserName(userName).orElseThrow(
                () -> new CustomizeException(getMessage(MessageCode.Teacher.NOT_EXISTS))
        );
        if (passwordEncoder.matches(CharBuffer.wrap(password), user.getPassword())) {
            return userAuthenticationProvider.createToken(userName);
        }
        throw new CustomizeException("Invalid username/password supplied");
    }

}
