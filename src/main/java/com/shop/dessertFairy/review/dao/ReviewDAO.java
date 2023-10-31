package com.shop.dessertFairy.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.review.dto.ReviewDTO;

@Mapper
public interface ReviewDAO {

	int getReviewCnt();
	
    int reviewWrite(ReviewDTO rdto);

    List<ReviewDTO> getReviewList(ReviewDTO rdto);

	int updateReadCnt(ReviewDTO rdto);


}