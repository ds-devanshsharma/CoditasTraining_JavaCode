package com.Springboot.StudentCoureReviewApplication.controller;

import com.Springboot.StudentCoureReviewApplication.dto.request.RemoveReviewDto;
import com.Springboot.StudentCoureReviewApplication.dto.request.ReviewDto;
import com.Springboot.StudentCoureReviewApplication.entities.ReviewEntity;
import com.Springboot.StudentCoureReviewApplication.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @PostMapping("/addReview")
    ResponseEntity addReviewController(@RequestBody ReviewDto reviewDto){
        try{
            int status= reviewService.addReview(reviewDto);
            if(status ==1)
                return new ResponseEntity("STUDENT NOT FOUND !" ,HttpStatus.NOT_FOUND);
            else if(status ==2)
                return new ResponseEntity("COURSE NOT FOUND !" ,HttpStatus.NOT_FOUND);
            else if(status ==3)
                return new ResponseEntity("STUDENT NOT REGISTERED IN THIS COURSE ",HttpStatus.NOT_ACCEPTABLE);
            else
                return new ResponseEntity("REVIEW ADDED !" , HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/removeReview")
    ResponseEntity removeReviewController(@RequestBody RemoveReviewDto removeReview){
        try{
            if(reviewService.removeReview(removeReview))
                return new ResponseEntity("REVIEW REMOVED SUCCESSFULLY !",HttpStatus.OK);
            else
                return new ResponseEntity("REVIEW NOT FOUND !",HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchReviewGivenByStudent/{studentId}")
    ResponseEntity fetchReviewGivenByStudent(@PathVariable Long studentId){
        try{
            List<ReviewEntity> reviewList = reviewService.showReviewGivenByStudent(studentId);
            if(!reviewList.isEmpty())
                return new ResponseEntity(reviewList,HttpStatus.FOUND);
            else
                return new ResponseEntity("NO REVIEW FOUND !",HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
