package com.be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Revenue {
    private int year;
    private List<Double> months;
}
