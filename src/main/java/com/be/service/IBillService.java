package com.be.service;

import com.be.model.Bill;
import com.be.model.dto.Revenue;

import java.util.List;

public interface IBillService {
    List<Integer> findAllYearActiveOfHost(int idHost);
    List<Revenue> findRevenueOfHost(int idHost);
}
