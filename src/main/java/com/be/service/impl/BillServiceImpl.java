package com.be.service.impl;

import com.be.model.dto.Revenue;
import com.be.repository.IBillRepository;
import com.be.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    IBillRepository iBillRepository;

    @Override
    public List<Integer> findAllYearActiveOfHost(int idHost) {
        return iBillRepository.findAllYearActiveOfHost(idHost);
    }

    @Override
    public  List<Revenue> findRevenueOfHost(int idHost) {
        List<Integer> years = findAllYearActiveOfHost(idHost);
         List<Revenue> result = new ArrayList<>();
        if (years.isEmpty()) return result;
        for (Integer year : years) {
            List<Double> revenueByMonth=new ArrayList<>();
            for(byte i=1;i<=12;i++){
                Double revenue=iBillRepository.calculateTotalRevenueByTime(i,year,idHost).orElse(0.0);
                revenueByMonth.add(revenue);
            }
            result.add(new Revenue(year,revenueByMonth));
        }
        return result;
    }




}
