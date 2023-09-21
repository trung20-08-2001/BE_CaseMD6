package com.be.controller.user;

import com.be.model.Feedback;
import com.be.service.IBillService;
import com.be.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/feedBack")
public class FeedBackController {
    @Autowired
    IFeedBackService iFeedBackService;
    @Autowired
    IBillService iBillService;

    @PostMapping("/addFeedBack")
    public void createFeedback(@RequestBody Feedback feedback) {
       iFeedBackService.saveFeedback(feedback);
    }
    @GetMapping("/showFeedback/{idHouse}")
    public ResponseEntity<List<Feedback>> getFeedbackList(@PathVariable int idHouse){
        List<Feedback> feedbacks = iFeedBackService.findFeedbackByStatusAndHouse(idHouse);
        return ResponseEntity.ok(feedbacks);
    }

    @GetMapping("/findFeedbackByHouseAndUser/{idUser}/{idHouse}")
    public Feedback checkConditionsFeedback(@PathVariable int idUser, @PathVariable int idHouse){
        return iFeedBackService. findFeedbackByHouseAndUser(idUser, idHouse);
    }
}
