package com.be.controller.admin;

import com.be.model.Account;
import com.be.model.Status;
import com.be.model.dto.ViewVendor;
import com.be.repository.IStatusRepository;
import com.be.service.IViewVendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class ViewVendorController {
    @Autowired
    IViewVendor iViewVendor;
    @Autowired
    IStatusRepository iStatusRepository;

    @GetMapping("/vendors")
    public List<ViewVendor> findAllVendor() {
        return iViewVendor.findAllVendors();
    }

    @PostMapping("/vendor/{id}/status")
    public void updateVendorStatus(@PathVariable int id, @RequestBody Status status) {
        Account vendor = iViewVendor.findByID(id);
        Status status1 = iStatusRepository.findByName(status.getName());
        vendor.setStatus(status1);
        iViewVendor.save(vendor);
    }

    @GetMapping("/vendor/{id}")
    public ViewVendor findVendorByID(@PathVariable int id) {
        return iViewVendor.findVendorByID(id);
    }

}
