package com.be.repository;

import com.be.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill,Integer> {
}
