package com.be.controller.host;

import com.be.model.Feedback;
import com.be.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/feedback")
public class FeedbackController {
    @Autowired
    IFeedBackService iFeebbackService;
    @GetMapping("getAllFeedback/{houseId}")
    public List<Feedback> getAllByHouseId(@PathVariable int houseId) {
        return iFeebbackService.getAllByHouse_Id(houseId);
    }
    @PostMapping("updateFeedback/{feedbackId}")
    public Feedback updateFeedback(@PathVariable int feedbackId){
        return iFeebbackService.updateFeedback(feedbackId);
    }
    @GetMapping("getAllByStar/{houseId}/{star}")
    public List<Feedback> getAllByStar(@PathVariable int houseId,
                                       @PathVariable int star) {
        return iFeebbackService.getAllByStar(houseId,star);
    }
}
