package com.thupq.coffee.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> content = new ArrayList();
    private int page;
    private int size;
    private long totalItem;

}