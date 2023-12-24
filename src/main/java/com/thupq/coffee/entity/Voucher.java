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
@Document(collection = "voucher")
public class Voucher extends AuditEntity{
    @Id
    private UUID id;

    private int percentDiscount;

    private long maxDiscount;

    private String description;

    private String status;
}
