package com.be.repository;

import com.be.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStatusRepository extends JpaRepository<Status,Integer> {
    Status findById(int id);

    @Query("SELECT s FROM Status s WHERE s.name = :name")
    Status findByName(@Param("name") String name);
}
