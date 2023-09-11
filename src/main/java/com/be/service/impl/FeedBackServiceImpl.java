package com.be.service.impl;

import com.be.model.Feedback;
import com.be.repository.IFeedbackRepository;
import com.be.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FeedBackServiceImpl implements IFeedBackService {
    @Autowired
    IFeedbackRepository iFeedbackRepository;

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
        List<Feedback> feedbacks= iFeedbackRepository.getFeedbackByHouseAndUser(idHouse,idUser).orElse(null);
        if (feedbacks == null || feedbacks.isEmpty()) return null;
        else return feedbacks.get(0);
    }
}
