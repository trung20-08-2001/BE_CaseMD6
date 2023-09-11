package com.be.service;

import com.be.model.Feedback;

import java.util.List;

public interface IFeebbackService {
    List<Feedback> getAllByHouse_Id(int houseId);
    Feedback updateFeedback(int feedbackId);
    List<Feedback> getAllByStar(int houseId,int start);
}
