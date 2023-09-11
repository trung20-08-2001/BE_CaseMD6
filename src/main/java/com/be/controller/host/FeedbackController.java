package com.be.controller.host;

import com.be.model.Feedback;
import com.be.service.IFeebbackService;
import com.be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/feedback")
public class FeedbackController {
    @Autowired
    IFeebbackService iFeebbackService;
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
