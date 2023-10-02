package com.be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
public class CustomPage<E> {
    private List<E> content;
    private int totalPages;
    private int currentPage;
}
