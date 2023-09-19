package com.be.service.impl;

import com.be.model.Feedback;
import com.be.model.House;
import com.be.model.Status;
import com.be.repository.IFeedbackRepository;
import com.be.repository.IHouseRepository;
import com.be.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements IFeedBackService {
    @Autowired
    IFeedbackRepository iFeedbackRepository;
    @Autowired
    IHouseRepository iHouseRepository;


    @Override
    public void saveFeedback(Feedback feedback) {
        iFeedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> findFeedbackByStatusAndHouse(int idHouse) {
        return iFeedbackRepository.findFeedbackByStatusAndHouse(idHouse);
    }

    @Override
    public Feedback findFeedbackByHouseAndUser(int idUser, int idHouse) {
        List<Feedback> feedbacks = iFeedbackRepository.getFeedbackByHouseAndUser(idHouse, idUser).orElse(null);
        if (feedbacks == null || feedbacks.isEmpty()) return null;
        else return feedbacks.get(0);
    }


    @Override
    public List<Feedback> getAllByHouse_Id(int houseId) {
        House house = iHouseRepository.findById(houseId);
        if (house != null) {
            return iFeedbackRepository.getAllByHouse_Id(houseId);
        } else {
            return null;
        }
    }

    @Override
    public Feedback updateFeedback(int feedbackId) {
        Feedback feedback = iFeedbackRepository.findById(feedbackId).get();
        if (feedback != null) {
            Status status = new Status(3, "BLOCKED");
            feedback.setStatus(status);
            return iFeedbackRepository.save(feedback);
        }
        return null;
    }

    @Override
    public List<Feedback> getAllByStar(int houseId, int start) {
        House house = iHouseRepository.findById(houseId);
        if (house != null) {
            return iFeedbackRepository.getAllFeedbackByStar(houseId, start);
        } else {
            return null;
        }
    }

    @Override
    public List<Feedback> getAllFeedbackByComment(int houseId) {
        return iFeedbackRepository.getAllFeedbackByComment(houseId);
    }
}