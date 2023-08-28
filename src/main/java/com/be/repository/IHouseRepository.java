package com.be.repository;

import com.be.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHouseRepository extends JpaRepository<House,Integer> {
}
