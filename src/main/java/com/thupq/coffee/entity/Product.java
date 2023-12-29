package com.thupq.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product extends AuditEntity {
    @Id
    private UUID id;

    private UUID idFile;

    private UUID idVoucher;

    private String code;

    private String name;

    private double price;

    private String description;

    private String status;

}
