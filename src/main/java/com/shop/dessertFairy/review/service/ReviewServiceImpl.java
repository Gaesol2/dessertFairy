package com.shop.dessertFairy.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dessertFairy.review.dao.ReviewDAO;
import com.shop.dessertFairy.review.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDao;
	
	@Override
	public int reviewWrite(ReviewDTO rdto) {
		return reviewDao.reviewWrite(rdto);
	}

}
