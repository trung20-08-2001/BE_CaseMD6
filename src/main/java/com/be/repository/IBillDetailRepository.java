package com.be.repository;

import com.be.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
}
