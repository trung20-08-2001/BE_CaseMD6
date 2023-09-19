package com.be.repository;

import com.be.model.Feedback;
import com.be.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("select fb from Feedback fb where fb.house.id= :houseId order by fb.id desc ")
    List<Feedback> getAllByHouse_Id(@Param("houseId") int houseid);

    @Query("select fb from Feedback fb where fb.house.id= :houseId and fb.numberOfStars= :star order by fb.id desc")
    List<Feedback> getAllFeedbackByStar(@Param("houseId") int houseId, @Param("star") int star);

    @Query("select f  from Feedback f where f.house.id= :idHouse and f.status.id=1 order by f.id desc")
    List<Feedback> findFeedbackByStatusAndHouse(@Param("idHouse") int idHouse);

    @Query(value = "select f from Feedback f where f.house.id= :idHouse and f.account.id=:idUser and f.comment=null and f.date=null order by f.id desc")
    Optional<List<Feedback>> getFeedbackByHouseAndUser(@Param("idHouse") int idHouse, @Param("idUser") int idUser);

    @Query("SELECT fb FROM Feedback fb WHERE fb.house.id= :houseId and fb.comment != '' order by fb.id desc ")
    List<Feedback> getAllFeedbackByComment(@Param("houseId")int houseId);
}
