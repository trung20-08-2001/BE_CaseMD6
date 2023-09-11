package com.be.repository;

import com.be.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("select fb from Feedback fb where fb.house.id= :houseId order by fb.id desc ")
    List<Feedback> getAllByHouse_Id(@Param("houseId") int houseid);

    @Query("select fb from Feedback fb where fb.house.id= :houseId and fb.numberOfStars= :star order by fb.id desc")
    List<Feedback> getAllFeedbackByStar(@Param("houseId") int houseId, @Param("star") int star);

}
