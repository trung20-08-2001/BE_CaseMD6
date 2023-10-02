package com.be.repository;

import com.be.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IImageRepository extends JpaRepository<Image,Integer> {
    @Query(value = "select i from Image i where i.house.id=:idHouse")
    List<Image> findImageByIdHouse(@Param("idHouse") Integer idHouse);

    @Transactional
    @Modifying
    @Query("DELETE FROM Image i WHERE i.house.id=:idHouse")
    void deleteAllInBatch(@Param("idHouse") Integer idHouse);

}
