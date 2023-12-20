package com.thupq.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    @Id
    private UUID id;

    private String code;

    private String name;

    private double price;

    private String name;

    private String description;

    private String status;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

}
