package com.thupq.coffee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PageResponse<T> {

    private List<T> content = new ArrayList();
    private int page;
    private int size;
    private long totalItem;

}