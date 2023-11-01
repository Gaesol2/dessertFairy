package com.shop.dessertFairy.review.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.common.dto.PageDTO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

public interface ReviewService {

   int reviewWrite(ReviewDTO rdto, MultipartFile file);

   Map<String, Object> getReviewList(ReviewDTO rdto, PageDTO pageDto, String orderby);

   ReviewDTO getReviewcontent(ReviewDTO rdto);

}	