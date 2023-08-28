package com.be.repository;

import com.be.model.HouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHouseDetailRepository extends JpaRepository<HouseDetail,Integer> {
}
