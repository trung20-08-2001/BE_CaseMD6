package com.be.service;

import com.be.model.Feedback;

import java.util.List;

public interface IFeedBackService {
    void saveFeedback(Feedback feedback);
    List<Feedback> findFeedbackByStatusAndHouse(int idHouse);

    Feedback findFeedbackByHouseAndUser(int idUser,int idHouse);
    List<Feedback> getAllByHouse_Id(int houseId);
    Feedback updateFeedback(int feedbackId);
    List<Feedback> getAllByStar(int houseId,int start);
    List<Feedback> getAllFeedbackByComment(int houseId);

}
