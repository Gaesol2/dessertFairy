package com.shop.dessertFairy.review.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.shop.dessertFairy.review.dto.ReviewDTO;

@Mapper
public interface ReviewDAO {

	int reviewWrite(ReviewDTO rdto);

}
