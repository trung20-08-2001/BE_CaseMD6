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
    public Account findByID(int id) {
        return iAccountRepository.findById(id).get();
    }

    @Override
    public List<ViewVendor> findAllVendors() {
        List<Status> statuses = iStatusRepository.findAll();
        List<ViewVendor> viewVendors = new ArrayList<>();
        ViewVendor viewVendor;
        for (Account account : iAccountRepository.findAllByIdDesc()) {
            if (((account.getStatus().getId() == 2) && (account.getRole().getId() == 3)) || account.getRole().getId() == 2) {
                Double totalPrice = getTotalPriceByAccount(account);
                double resultPrice = (totalPrice != null) ? totalPrice : 0;
                Integer countHouses = countHousesByAccount(account);
                int resultCount = (countHouses != null) ? countHouses : 0;
                viewVendor = new ViewVendor(0, resultPrice, resultCount, account, statuses);
                viewVendors.add(viewVendor);
            }
        }
        return viewVendors;
    }

    @Override
    public ViewVendor findVendorByID(int id) {
        for (ViewVendor viewVendor : findAllVendors()) {
            if (viewVendor.getAccount().getId() == id) {
                if (viewVendor.getAccount().getAvatar() == null) {
                    viewVendor.getAccount().setAvatar("https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/2048px-User-avatar.svg.png");
                }
                return viewVendor;
            }
        }
        return null;
    }


}
