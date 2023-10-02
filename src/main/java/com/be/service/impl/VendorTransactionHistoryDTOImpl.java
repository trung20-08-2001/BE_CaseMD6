package com.be.service.impl;

import com.be.model.*;
import com.be.model.dto.VendorTransactionHistoryDTO;
import com.be.repository.IBillRepository;
import com.be.repository.IStatusRepository;

import com.be.service.IVendorTransactionHistoryDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorTransactionHistoryDTOImpl implements IVendorTransactionHistoryDTOService {
    @Autowired
    IBillRepository iBillRepository;
    @Autowired
    IStatusRepository iStatusRepository;

    @Override
    public List<VendorTransactionHistoryDTO> findAllBill_Vendor(Account vendor) {
        List<VendorTransactionHistoryDTO> vendorTransactionHistoryDTOList = new ArrayList<>();
        VendorTransactionHistoryDTO vendorTransactionHistoryDTO;
        int countId = 0;
        for (Bill bill : iBillRepository.findAllByVendorOrderByDescendingIdAndStatusId(vendor)) {
            House house = bill.getHouse();
            vendorTransactionHistoryDTO = new VendorTransactionHistoryDTO(countId++, house, bill);
            vendorTransactionHistoryDTOList.add(vendorTransactionHistoryDTO);
        }
        return vendorTransactionHistoryDTOList;
    }

    @Override
    public List<VendorTransactionHistoryDTO> findBill_rentingHouse_Vendor(Account vendor) {
        List<VendorTransactionHistoryDTO> vendorTransactionHistoryDTOList = new ArrayList<>();
        for (VendorTransactionHistoryDTO vendorTransactionHistoryDTO : findAllBill_Vendor(vendor)) {
            if (vendorTransactionHistoryDTO.getHouse().getStatus().getId() == 5) {
                vendorTransactionHistoryDTOList.add(vendorTransactionHistoryDTO);
            }
        }
        return vendorTransactionHistoryDTOList;
    }

}
