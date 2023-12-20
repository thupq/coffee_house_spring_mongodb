package com.thupq.coffee.entity;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class FileAttachment {
    @Id
    private UUID id;

    private String code;
}
