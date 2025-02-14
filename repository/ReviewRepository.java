package com.example.campusbookshare.repository;

import com.example.campusbookshare.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}