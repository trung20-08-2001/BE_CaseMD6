package com.be.service;

import com.be.model.Account;
import com.be.model.Service;
import com.be.model.Status;
import com.be.model.dto.ViewVendor;

import java.util.List;

public interface IViewVendor {
    void save(Account account);
    Account findByID(int id);
    List<Account> findVendorsByRoleName();
    List<ViewVendor> findAllVendors();
}
