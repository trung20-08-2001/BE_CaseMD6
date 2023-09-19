package com.be.repository;

import com.be.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface INotificationRepository extends JpaRepository<Notification,Integer> {
    @Query(value = "select n from Notification n where n.account.id=:idAccount order by n.time desc")
    List<Notification> findByIdAccount(@Param("idAccount") int idAccount);
}
