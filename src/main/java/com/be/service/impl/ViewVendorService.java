package com.be.service.impl;

import com.be.model.*;

import com.be.model.dto.ViewVendor;
import com.be.repository.*;
import com.be.service.IViewVendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ViewVendorService implements IViewVendor {
    @Autowired
    IBillRepository iBillRepository;
    @Autowired
    IAccountRepository iAccountRepository;
    @Autowired
    IStatusRepository iStatusRepository;
    @Autowired
    IHouseRepository iHouseRepository;

    public Double getTotalPriceByAccount(Account account) {
        return iBillRepository.getTotalPriceByAccount(account);
    }

    public int countHousesByAccount(Account account) {
        return iHouseRepository.countHousesByAccount(account);
    }

    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public List<Account> findVendorsByRoleName() {
        return iAccountRepository.findAccountsByRoleName_Vendor();
    }

    @Override
    public List<ViewVendor> findAllVendors() {
        List<Status> statuses = iStatusRepository.findAll();
        List<ViewVendor> viewVendors = new ArrayList<>();
        ViewVendor viewVendor;
        for (Account account : findVendorsByRoleName()) {
            Double totalPrice = getTotalPriceByAccount(account);
            double resultPrice = (totalPrice != null) ? totalPrice : 0;
            Integer countHouses = countHousesByAccount(account);
            int resultCount = (countHouses != null) ? countHouses : 0;
            viewVendor = new ViewVendor(0, resultPrice, resultCount, account, statuses);
            viewVendors.add(viewVendor);
        }
        return viewVendors;
    }

    @Override
    public Account findByID(int id) {
        return iAccountRepository.findById(id).get();
    }


}
