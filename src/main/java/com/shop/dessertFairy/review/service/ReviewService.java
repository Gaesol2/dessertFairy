package com.shop.dessertFairy.review.service;

import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.review.dto.ReviewDTO;

public interface ReviewService {

   int reviewWrite(ReviewDTO rdto, MultipartFile file);

}