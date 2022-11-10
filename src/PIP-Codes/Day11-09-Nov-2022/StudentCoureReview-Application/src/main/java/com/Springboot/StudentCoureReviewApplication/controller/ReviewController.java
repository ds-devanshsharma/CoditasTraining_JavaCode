package com.Springboot.StudentCoureReviewApplication.controller;

import com.Springboot.StudentCoureReviewApplication.dto.request.ReviewDto;
import com.Springboot.StudentCoureReviewApplication.entities.ReviewEntity;
import com.Springboot.StudentCoureReviewApplication.service.ReviewService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping("/addReview")
    ResponseEntity addReviewController(@RequestBody ReviewDto reviewDto){
        try{
            ReviewEntity addedReview = reviewService.addReview(reviewDto);
            if(addedReview != null)
                return new ResponseEntity(addedReview,HttpStatus.ACCEPTED);
            else
                return new ResponseEntity("REVIEW NOT ADDED !!",HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
