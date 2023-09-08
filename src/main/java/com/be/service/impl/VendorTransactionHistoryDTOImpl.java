package com.be.service.impl;

import com.be.model.*;
import com.be.model.dto.UserTransactionHistoryDTO;
import com.be.model.dto.VendorTransactionHistoryDTO;
import com.be.repository.IBillDetailRepository;
import com.be.repository.IStatusRepository;
import com.be.service.IUserTransactionHistoryService;
import com.be.service.IVendorTransactionHistoryDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorTransactionHistoryDTOImpl implements IVendorTransactionHistoryDTOService {
    @Autowired
    IBillDetailRepository iBillDetailRepository;
    @Autowired
    IStatusRepository iStatusRepository;

    @Override
    public List<VendorTransactionHistoryDTO> findAllBill_Vendor(Account vendor) {
        List<VendorTransactionHistoryDTO> vendorTransactionHistoryDTOList = new ArrayList<>();
        VendorTransactionHistoryDTO vendorTransactionHistoryDTO;
        int countId = 0;
        for (BillDetail billDetail : iBillDetailRepository.findAllByBill_VendorOrderByBill_Status_IdAscBill_IdDesc(vendor)) {
            House house = billDetail.getHouse();
            Bill bill = billDetail.getBill();
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
