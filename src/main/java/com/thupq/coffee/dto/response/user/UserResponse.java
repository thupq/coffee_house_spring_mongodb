package com.thupq.coffee.dto.response.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UUID id;

    private String code;

    private String userName;

    private String fullName;

    private String contactPhone;

    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone="GMT+7")
    private Date dateOfBirth;

    private String gender;

    private String description;

    private String status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT+7")
    private Date createDate;

    private String createBy;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone="GMT+7")
    private Date updateDate;

    private String updateBy;
}
