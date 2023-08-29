package com.be.repository;

import com.be.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHouseRepository extends JpaRepository<House,Integer> {
    @Query(value = "select h from House h where h.a")
    List<House>  findByNameAndStatus(String name,String status);
}
