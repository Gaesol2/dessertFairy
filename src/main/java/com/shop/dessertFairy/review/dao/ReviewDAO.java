package com.shop.dessertFairy.review.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shop.dessertFairy.review.dto.ReviewDTO;

@Mapper
public interface ReviewDAO {

	int reviewWrite(ReviewDTO rdto);

}
