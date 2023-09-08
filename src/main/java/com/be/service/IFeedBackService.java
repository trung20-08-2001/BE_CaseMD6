package com.be.service;

import com.be.model.Feedback;

import java.util.List;

public interface IFeedBackService {
    void saveFeedback(Feedback feedback);

    List<Feedback> findFeedbackByStatusAndHouse(int idHouse);
}
