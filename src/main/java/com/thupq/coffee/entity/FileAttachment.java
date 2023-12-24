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
@Document(collection = "file_attachment")
public class FileAttachment extends AuditEntity{
    @Id
    private UUID id;

    private String fileNameOrigin;

    private String fileName;

    private String filePath;

    private int priority;

}
