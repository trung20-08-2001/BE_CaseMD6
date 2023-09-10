package com.be.repository;

import com.be.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IFeedbackRepository extends JpaRepository<Feedback,Integer> {
    @Query("select f  from Feedback f where f.house.id= :idHouse and f.status.id=1 order by f.id desc")
    List<Feedback> findFeedbackByStatusAndHouse(@Param("idHouse") int idHouse);

    @Query(value = "select f from Feedback f where f.house.id= :idHouse and f.account.id=:idUser and f.comment=null and f.date=null ")
    Optional<Feedback> getFeedbackByHouseAndUser(@Param("idHouse") int idHouse, @Param("idUser")int idUser);

}
