package com.thupq.coffee.service.mapper;

import com.thupq.coffee.common.Constants;
import com.thupq.coffee.entity.User;
import com.thupq.coffee.dto.request.user.UserRequest;
import com.thupq.coffee.dto.response.user.UserResponse;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper extends EntityMapper<UserResponse, User>{
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "createDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
    @Mapping(target = "createBy", defaultValue = "system")
    @Mapping(target = "updateDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))")
    @Mapping(target = "updateBy", defaultValue = "system")
    @Mapping(target = "status", defaultValue = Constants.STATUS_ACTIVE)
    User toEntityCreate(UserRequest userRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({
            @Mapping(target = "updateDate", expression = "java(new java.sql.Date(System.currentTimeMillis()))"),
            @Mapping(target = "updateBy", constant = "system"),
    })
    void partialUpdate(@MappingTarget User entity, UserRequest dto);
}
