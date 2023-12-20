package com.thupq.coffee.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchRequest {
    private String userName;

    private String status;

    private String contactPhone;

    private LocalDate fromDate;

    private LocalDate toDate;
}
