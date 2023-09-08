package com.be.repository;

import com.be.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFeedbackRepository extends JpaRepository<Feedback,Integer> {
    @Query("select f  from Feedback f where f.house.id= :idHouse and f.status.id=1 ")
    List<Feedback> findFeedbackByStatusAndHouse(@Param("idHouse") int idHouse);


}
