package com.example.campusbookshare.service;

import com.example.campusbookshare.model.Review;
import com.example.campusbookshare.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        review.setCreated_at(new Date());
        return reviewRepository.save(review);
    }
}